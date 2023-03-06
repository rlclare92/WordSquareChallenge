package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class WordSquareApp {
    public static void main(String[] args) throws IOException {

        List<String> words = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter a numeric value for the length of the grid: ");
        int maximumWordLength = sc.nextInt();

        System.out.println("Please enter alphabetical only values: ");
        String letters = sc.next().toLowerCase();

        Map<Character, Integer> lettersCountMap = getCharacterCountMap(letters);

        BufferedReader reader = new BufferedReader(new FileReader("/Users/ruthclare/Documents/MyGit/wordsquare/dictionary.txt"));

        for (String currentWord = reader.readLine(); currentWord != null; currentWord = reader.readLine()) {
            Map<Character, Integer> currentWordMap = getCharacterCountMap(currentWord);

            boolean canMakeCurrentWord = true;
            for (Character character : currentWordMap.keySet()) {
                int currentWordCharCount = currentWordMap.get(character);
                int lettersCharCount = lettersCountMap.containsKey(character) ? lettersCountMap.get(character) : 0;

                if (currentWordCharCount > lettersCharCount) {
                    canMakeCurrentWord = false;
                    break;
                }
            }
            if (canMakeCurrentWord && maximumWordLength == currentWord.length()) {
                words.add(currentWord);
            }
        }
        WordSquareSetup wordSquareSetup = new WordSquareSetup();
        wordSquareSetup.wordSquareSetup(words);
    };

    private static Map<Character, Integer> getCharacterCountMap(String letters) {
        Map<Character, Integer> lettersCountMap = new HashMap<>();

        for(int i = 0; i < letters.length(); i++) {
            char currentChar = letters.charAt(i);

            int count = lettersCountMap.containsKey(currentChar) ? lettersCountMap.get(currentChar) : 0;

            lettersCountMap.put(currentChar, count + 1);
        }
        return lettersCountMap;
    }
}
