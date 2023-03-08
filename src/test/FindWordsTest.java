package test;

import main.java.FindWords;
import org.junit.jupiter.api.Test;
import org.junit.Assert;

import java.io.IOException;
import java.util.List;

class FindWordsTest {
    int maximumWordLength = 4;
    String letters = "abbartdsbfjdesfd";
    int wordLength = letters.length();

    @Test
    void check_that_myWords_is_returning_correct_length_of_words() throws IOException {
        FindWords findWords = new FindWords();
        List<String> myWords = findWords.words(maximumWordLength, letters);
        
        for(String word : myWords) {
            Assert.assertTrue(word.length() == maximumWordLength);
        }
    }
}