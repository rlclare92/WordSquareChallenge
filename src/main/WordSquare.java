package main;
import java.io.*;

public class WordSquare {
/* WORD SQUARE CHALLENGE - https://www.reddit.com/r/dailyprogrammer/comments/49o3ho/20160309_challenge_257_intermediate_word_squares/
 * Our goal is to narrow down our options as much and as quickly as possible. First, filter out as many unusable
 * words as possible. Then, build a trie that contains the remaining valid words. From there, just recursively
 * try all combinations using the trie, aborting branches that can't continue without breaking the rules of the square.
 */

    static int n;
    public static void main(String argv[]) throws IOException{
        long startTime = System.nanoTime();

        String[] args = "4 aaccdeeeemmnnnoo".split(" ");
        n = Integer.parseInt(args[0]);
        char[] charset = args[1].toCharArray();

        Node wordTrie = new Node();
        int[] charFreq = new int[26];
        for (char c : charset)
            charFreq[c - 'a']++;

        BufferedReader br = new BufferedReader(new FileReader("/Users/ruthclare/Documents/MyGit/wordsquare/dictionary.txt"));
        String dictWord;
        while ((dictWord = br.readLine()) != null) {
            if (dictWord.length() == n && fitsInLetterBank(dictWord, charFreq)) {
                Node curNode = wordTrie;
                for (int i = 0; i < dictWord.length(); i++) {
                    int c = dictWord.charAt(i) - 'a';
                    if (curNode.children[c] == null)
                        curNode.children[c] = new Node(c);
                    curNode = curNode.children[c];
                }
            }
        }
        char[][] result = getWordSquare(wordTrie, charFreq);
        long endTime = System.nanoTime();

        if (result != null)
            for (int i = 0; i < result.length; i++)
                System.out.println(new String(result[i]));
        else
            System.out.println("No valid word square could be made.");

        System.out.println("\nExecution Time: " + Double.toString((endTime - startTime) / 1000000000.0)+"s");
    }

    static char[][] getWordSquare(Node trieRoot, int[] charFreq) {
        Node[][] mat = new Node[n][n+1];
        for (int i = 0; i < mat.length; i++)
            mat[i][0] = trieRoot;
        int[] bank = charFreq.clone();
        if (rec(0, 1, mat, bank)) {
            char[][] result = new char[n][n];
            for (int r = 0; r < n; r++)
                for (int c = 0; c < n; c++)
                    result[r][c] = (char) (mat[r][c + 1].val + 'a');
            return result;
        } else {
            return null;
        }
    }

    // fills out the word bank, one character at a time. Keep in mind that the first column of every row
    // contains the root node, so indexes needed to be adjusted accordingly.
    static boolean rec(int r, int c, Node[][] mat, int[] bank)  {
        int incrAmt = r==c-1 ? 1 : 2; // need 1 for a diagonal, 2 otherwise (since it's mirrored)

        for (int l = 0; l < 26; l++) {
            Node node = mat[r][c-1].children[l];
            Node nodeMirrorSide = mat[c-1][r].children[l];
            if (node != null && nodeMirrorSide != null && bank[l] >= incrAmt) {

                mat[r][c] = node;
                mat[c - 1][r + 1] = nodeMirrorSide;
                bank[l] -= incrAmt; // remove letter from bank

                // try next position
                if (c == n) { // no more columns in this row
                    if (r == n - 1 // no more rows either; end of word square (SUCCESS)
                            || rec(r + 1, r + 2, mat, bank)) { // move to next row
                        return true;
                    }
                } else if (rec(r, c + 1, mat, bank)) { // move to next column
                    return true;
                }

                bank[l] += incrAmt; // add letter back to bank
            }
        }
        return false; // current branch cannot produce a valid word square
    }

    // returns whether the word can be used, given the letters provided. Takes into account the fact that all
    // but one of the letters (the one on the diagonal) in the word must occur twice in the final word square.
    private static boolean fitsInLetterBank(String word, int[] charFreq) {
        int[] charsUsed = new int[26];
        boolean diagonalUsed = false;
        for (int i = 0; i < word.length(); i++) {
            int c = word.charAt(i) - 'a';

            int spaceLeft = charFreq[c] - charsUsed[c];
            if (spaceLeft > 1) { // try fitting letter in a non-diagonal slot
                charsUsed[c] += 2;
            } else if (spaceLeft == 1 && !diagonalUsed) { // else, try fitting it in the diagonal slot
                charsUsed[c] += 1;
                diagonalUsed = true;
            } else { // no space for letter
                return false;
            }
        }
        return true;
    }

    // Used to build the trie. Sacrifices space for lightning fast lookups.
    static class Node {
        int val;
        Node[] children;

        Node() {
            children = new Node[26];
        }
        Node(int val){
            this();
            this.val = val;
        }
    }
}