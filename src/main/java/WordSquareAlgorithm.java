package main.java;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/*
        takes the list of possible words and creates word squares.
        for example string "eeeeddoonnnsssrv" with a size of 4 produces 86 possible word squares.
 */

public class WordSquareAlgorithm {

    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> result = new LinkedList<>();
        Trie trie = new Trie();
        for (int i = 0; i < words.length; i++) {
            trie.add(words[i]);
        }
        List<String> tmp = new LinkedList<>();
        for (int i = 0; i < words.length; i++) {
            tmp.add(words[i]);
            process(words[0].length(), tmp, 1, trie, result);
            tmp.clear();
        }
        return result;
    }

    private class Trie {
        public Node root;

        private Trie() {
            root = new Node();
        }

        private void add(String s) {
            Node node = root;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (!node.children.containsKey(c)) {
                    node.children.put(c, new Node());
                }
                node = node.children.get(c);
                node.cands.add(s);
                if (i == s.length() - 1) {
                    node.isLeaf = true;
                }
            }
        }

        private Node search(String prefix) {
            Node node = root;
            for (int i = 0; i < prefix.length(); i++) {
                char c = prefix.charAt(i);
                if (!node.children.containsKey(c)) {
                    return null;
                }
                node = node.children.get(c);
            }
            return node;
        }

        private List<String> getCands(String prefix) {
            Node node = search(prefix);
            if (node == null) {
                return null;
            }
            return node.cands;
        }
    }

    private class Node {
        public boolean isLeaf;
        public HashMap<Character, Node> children;
        public List<String> cands;

        public Node() {
            isLeaf = false;
            children = new HashMap<>();
            cands = new LinkedList<>();
        }
    }

    private void process(int n, List<String> tmp, int level, Trie trie, List<List<String>> result) {
        if (level == n) {
            result.add(new LinkedList<>(tmp));
            return;
        }
        StringBuilder prefix = new StringBuilder();
        for (int i = 0; i < tmp.size(); i++) {
            prefix.append(tmp.get(i).charAt(level));
        }

        List<String> cds = trie.getCands(prefix.toString());
        if (cds == null) {
            return;
        }
        for (String s : cds) {
            tmp.add(s);
            process(n, tmp, level + 1, trie, result);
            tmp.remove(tmp.size() - 1);
        }
    }



}
