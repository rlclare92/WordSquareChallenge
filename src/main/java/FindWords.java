package main.java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindWords {

   /*
   * The aim of this class is to read our dictionary text file.
   * Use the user's input to loop through and get a sense of what values we have and a count of those.
   * Read through each line of the file, creating a similar count to the users letters
   * comparing the length of the valid words to what the user has set as the size of the square (the length of the word)
   * And sort the words that met our requirements into a new ArrayList, we cna later used to loop over and set up our word square.
   *
   * Future Improvements
   *    - Look at calling the dictionary API, rather than having the text file within th eproject, as it is a large file and take memory and performance issues.
   *    - Look at having the condition maximumWordLength == currentWord.length() done towards the beginning of the for loop, to improve the response time.
   *    - Adding in some try/ catches to help guard against any errors that may rise and provide clear logs of the issue.
   */

    List<String> words = new ArrayList<>();

    private String dictionaryPath = "src/main/resources/dictionary.txt";

    public List<String> words(int maximumWordLength, String letters) throws IOException {
        Map<Character, Integer> lettersCountMap = getCharacterCountMap(letters);

        // Read file through BufferedReader as it reads each line of the file, rather than each character.
        BufferedReader reader = new BufferedReader(new FileReader(dictionaryPath));

        // Read the first line of the text file and add to the variable.
        // Stay in the loop unto we receive null.
        // To keep iterating over within the loop we call readLine to move to the next line.
        for (String currentWord = reader.readLine(); currentWord != null;  currentWord = reader.readLine()) {
            Map<Character, Integer> currentWordMap = getCharacterCountMap(currentWord);

            boolean canMakeCurrentWord = true;
            // Similar to the loop in the method below, but instead of looping through the users input,we are looping through each word from our dictionary text file. compare if we have as many in our letters count and match the same length as the user's input.
            for (Character character : currentWordMap.keySet()) {
                int currentWordCharCount = currentWordMap.get(character);
                int lettersCharCount = lettersCountMap.containsKey(character) ? lettersCountMap.get(character) : 0;

                // Compare if we have as many in our letters count.
                if (currentWordCharCount > lettersCharCount) {
                    canMakeCurrentWord = false;
                    break;
                }
            }
            // Compare the canMakeCurrentWord is the same length as the has set as the maximum length of the square.
            if (canMakeCurrentWord && maximumWordLength == currentWord.length()) {
                words.add(currentWord);
            }
        }
        System.out.println(words);
        return words;
    }

    // We loop through the user input and update the count of how many of each letter we have and store within lettersCountMap.
    // For example, if the users input is "aabrt", then we have a -> 2, b -> 1, c -> 0... r -> 1, t -> 1.
    private static Map<Character, Integer> getCharacterCountMap(String letters) {
        Map<Character, Integer> lettersCountMap = new HashMap<>();

        for(int i = 0; i < letters.length(); i++) {
            char currentChar = letters.charAt(i);

            int count = lettersCountMap.containsKey(currentChar) ? lettersCountMap.get(currentChar) : 0;

            lettersCountMap.put(currentChar, count + 1);
        }
        return lettersCountMap;
    }
};
