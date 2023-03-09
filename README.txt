    Instructions to run the program.
      Run the WordSquareApp class to begin the program.
      The console will prompt the user to input a number and press enter.
      The console will then prompt the user to input letters and press enter again.
      If the program is successful a word square will be display with words made up from the user's letters.
      If the program is unsuccessful at creating a word square, a message will appear: Unable to create a valid word square! :( .


    Thought Process
    1. We will need to start with user Input,
        1a. Int value for the size of the grid/words.
        1b. String for the letters from the user's input.
    2. Find a way to read the dictionary text file.
    3. At this point we would want to loop though each word from dictionary file and store this and also loop through the user input letters and create a count for each letter for both the user input and the dictionary current word.
    4. Compare each dictionary word count to the user's to find only words that contain the correct letters, i.e if our user input has 2 a's, 1 b and 1 r then we only want words that contain only those letters ("baa, bar"...).
    5. Compare the lengths so that only words the same size as the user's original input are stored. (For future reference, I think I could do this stage much sooner to make the process faster.)
    6. Now, at this stage, we should have valid words that the program can use to try and make a valid word square.
    At this point, my idea was for it to be a trail and error like approach,
        a. It would take the first word and set that as the first row and column,
        b. Then from the 2nd letter of the first word, try to find a valid word beginning with that letter to set on the 2nd row and column.
        c. This pattern would continue using the next letter from the first word to try and find a valid match, unto the square is complete.
        d. However, if it was not able to produce the next valid word, then it would remove the previous word and try to build with a different word starting with the same character.

     I struggled to figure out how to implement this, and after looking over similar challenges and examples. I came to 2 options that would help me achieve the final goal of creating the word.
        6a. The first was based on a similar tech challenge where you have to create a word square from an array of words provided. However, once I tried to adapt and implement it into my code, I didn't like that it produced 2Dimensional arrays nested and many duplicate words in some sets and was also struggling to get the desired square shape displayed on the console.
        6b. The 2nd option is implemented, which is within the wordSquareSetup, the idea is to take the lists form the dictionary and the user and compare if any words could be set together, this is with the use of the wordSquareAlgorithm to make this possible.
     I felt this way was a lot clearer to understand how the word square is being set up. While I need help and further learning to understand the algorithm fully, I understand it helps create a square that can be read horizontally and vertically.
