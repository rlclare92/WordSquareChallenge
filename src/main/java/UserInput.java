package main.java;

import java.util.Scanner;

/*
 *   Future Improvements
 *
 *    userNumberInput Method
 *   - Convert into a try catch to help with handling error exceptions and be more defence code.
 *   - Could look at if possible to use a smaller typecast and limit the number to help with memory consumption.
 *
 *    userLettersInput Method
 *   - Place conditional statement to prevent invalid special and numeric characters being used. i.e., numbers, *, !, ., £ and ect.
 *   - Add condition statement to ensure the is enough letters the user inputs to create the word square.
 *   - Look into how to set up unit tests with the use of the scanner class.
 */

public class UserInput {
    // Print out into the console for the user to input the length of the word square.
    // Return input check through the dictionary for words with the same length.
    public int userNumberInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter a integer value for the length of the grid and hit enter once finish: ");
        if (!sc.hasNextInt()) {
            String incorrectInt = sc.next();
            System.err.println(incorrectInt + " is not a integer, please enter a integer value only");
        }
        int wordLength = sc.nextInt();
        return wordLength;
    }


    // Print out into the console for the user to input the chosen letters
    // Return the input for further to check the letters are contained within the words found in the dictionary check.
    public String userLettersInput() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter alphabetical only values and hit enter once finish: ");
        String letters = sc.next().toLowerCase();
        return letters;
    }
}
