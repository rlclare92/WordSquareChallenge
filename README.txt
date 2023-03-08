    Instructions to run the program.
      Run the WordSquareApp class.
      The console will prompt the user to input a number and press enter.
      The console will then prompt the user to input letters and press enter.
      If the program successfully creates a word square, the square will appear below the user's input moments later.
      If the program is unsuccessful at creating a word square, a message will appear: Unable to create a valid word square! :( .


    Thought Process
    1. We will need to start with user Input,
      1a. Int value for the size of the grid/words.
      1b. String for the letters from the user's input.
    2. Find a way to read the dictionary text file, sort the valid words, and store them.
    3a.Using the user's input, loop through each character and count the amount of each letter.
    3b. From the dictionary loop, go through each character of each word. Next, count how many of each character is contained in each word.
    5. Compare each dictionary word count to the user's to find only words that contain the correct letters.
    6. Compare the lengths so that only words the same size as the user's original input are stored. (For future reference, I think I could do this stage much sooner to make the process faster.)
    7. Now, at this stage, we should have valid words that the program can use to try and make a valid word square. At this point, I struggled to figure out my next steps, and I researched examples via Google. From here, I used the best samples to help me achieve the final goal, the word square.
      7a. The first was based on a similar tech challenge where you have to create a word square from an array of words provided. However, once I tried to adapt and implement it into my code, I didn't like that it produced 2Dimensional arrays nested and many duplicate words in some sets and was also struggling to get the desired square shape displayed on the console.
      7b. The 2nd option is implemented, which is within the wordSquareSetup, the idea is to take the lists form the dictionary and the user and compare if any words could be set together, this is with the use of the wordSquareAlgorithm to make this possible.
      I felt this way was a lot clearer to understand how the word square is being set up. While I need help and further learning to understand the algorithm fully, I understand it helps create a square that can be read horizontally and vertically.
