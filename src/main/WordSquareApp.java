package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class WordSquareApp {
    public static void main(String[] args) throws IOException {

        /*
         * Initial Solution/ Steps
         * 1. First will need some input from the user in the console.
         * 2. Starting with what the maximum length should be for the grid.
         * 3. Then ask for a LIST of letters of their own choosing.
         * 4a. Sort the LIST to be in alphabetical order. (later added to my process to help with organising the letters and iterating over them)
         * 4b. Select a random letter from the users list.
         * 5. Call the txt file
         * 6. Search for a word that starts with the random letter
         * 7. Check it matches the maximumWordLength.
         * 8. Check the word contains letters from the users list.
         * 9.
         *
         * With the 1st lot of my steps I was struggling to clearly set out what I would need to do next with the users input.
         * And felt like I was overcomplicating it.
         *
         * 2nd solution idea
         * Separate the challenge into two main tasks.
         * 1. with the user input search for words that contain the letters given and have the maximum length.
         * 2. With the words provided create a word square of them.
         */

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
