package test;

import main.java.WordSquareSetup;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class WordSquareSetupTest {
    private String userInputString = "eeeeddoonnnsssrv";
    private String testString = "aabbbcccc";


    private List testList = new ArrayList<String>();

    private String[] array = {"rose", "oven", "send", "ends"};


    @Test
    void createMapOfString() {
    }

    @Test
    void checkIfValidWordSquare() {
    }

    @Test
    void check_that_valid_word_square_returns_valid_word_square() throws IOException {

        testList.add("rose");
        testList.add("oven");
        testList.add("send");
        testList.add("ends");

        WordSquareSetup wordSquareSetup = new WordSquareSetup();
        Map map = wordSquareSetup.createMapOfString(userInputString);

        List list = wordSquareSetup.checkIfValidWordSquare(array, map);

        assertEquals(list, testList);
        Assert.assertTrue("test that word square returns correct number of words",list.size() == 4);
    }

    @Test
    void check_that_return_map_test_returns_correct_mapping() {
        WordSquareSetup wordSquareSetup = new WordSquareSetup();

        Map<String, Integer> myMap = new HashMap<>();
        myMap.put("a", 2);
        myMap.put("b", 3);
        myMap.put("c", 4);

        Map map = wordSquareSetup.createMapOfString(testString);

        assertEquals(map.toString(), myMap.toString());
    }
}