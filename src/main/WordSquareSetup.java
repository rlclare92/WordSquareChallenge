package main;

import main.java.WordSquareAlgorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WordSquareSetup {

    /*
         Creates a map of the number of times a letter is in a string. abbccc would return a map of {a:1,b:2,c:3}
         I think the Map I used on the FindWords class could reuse here and change slightly to do the same thing.
     */
    public static Map createMapOfString(String string) {
        Map letterMap = string.toLowerCase().chars().mapToObj(i -> (char) i)
                .collect(Collectors.groupingBy(Object::toString, Collectors.counting()));

        return letterMap;

    }

    /*
        Takes a list of Strings and concatenates them into a single string with no spaces
    */
    private static String stringCompressor(List list) {
        String string = String.join(",", list).replace(",", "").toLowerCase();
        return string;
    }

    /*
        Takes an array of words of the correct size and containing the correct letters and a map of the letters input by the user.
        checks if those words can form a valid word square then concatenates those words and maps the resulting string.
        it checks if the maps match. if yes prints out the word and returns that word square.
 */
    public static List<String> checkIfValidWordSquare(String[] array, Map mapA) {
        WordSquareAlgorithm wordSquareAlgorithm = new WordSquareAlgorithm();

        List<String> squareWords = new ArrayList<>();

        boolean flag = false;

        for (List n : wordSquareAlgorithm.wordSquares(array)) {

            String string = stringCompressor(n);

            Map mapB = createMapOfString(string);

            if (mapA.equals(mapB)) {
                System.out.println();
                System.out.println("Valid word square is: ");
                System.out.println();

                for (Object word : n) {
                    System.out.println("\t" + word.toString());
                    squareWords.add(word.toString());

                    flag = true;
                }
            }

        }
        if (!flag) {
            System.out.println("Unable to create a valid word square! :( ");
        }

        return squareWords;

    }
};
