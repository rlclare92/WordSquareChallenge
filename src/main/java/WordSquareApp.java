package main.java;

import main.WordSquareSetup;

import java.io.IOException;
import java.util.*;

public class WordSquareApp {
    private static Object String;

    public static void main(String[] args) throws IOException {

        // Ask for userInput for the length of the words and the letters they wish to use.
        UserInput userInput = new UserInput();
        int maximumWordLength = userInput.userNumberInput();
        String letters = userInput.userLettersInput();
        System.out.println(maximumWordLength);
        System.out.println(letters);

        // Use the dictionary text file to loop through the words and create an array of words matching the length and letters given by the user.
        FindWords findWords = new FindWords();
        List<String> myWords = findWords.words(maximumWordLength, letters);

        //creat a map of the user string
        WordSquareSetup wordSquareSetup = new WordSquareSetup();
        Map map = wordSquareSetup.createMapofString(letters);

        //Create array of applicable words
        String[] array = myWords.toArray(new String[0]);
        //create wordsquares from the list of applicable words, and output valid wordsquares.
        List<String> wordDescription = WordSquareSetup.checkIfValidWordSquare(array,map);

    }
}
