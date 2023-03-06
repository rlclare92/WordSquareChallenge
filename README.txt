      Instructions to run program.
        Run the WordSquareApp class.
        The console will prompt the user to input a number and press enter.
        The console will then prompt the user to input letters and press enter.
        If the program was successful at creating a word square, the square will appear below the user's input moments later.
        If the program was unsuccessful at creating a word square, a message will appear with the following, Unable to create a valid word square! :( .

      Initial Thoughts and ideas

       1. First will need some input from the user in the console.
       2. Starting with what the maximum length should be for the grid.
       3. Then ask for a LIST of letters of their own choosing.
       4a. Sort the LIST to be in alphabetical order. (later added to my process to help with organising the letters and iterating over them)
       4b. Select a random letter from the users list.
       5. Call the txt file
       6. Search for a word that starts with the random letter
       7. Check it matches the maximumWordLength.
       8. Check the word contains letters from the users list.

       With the 1st lot of my steps I was struggling to clearly set out what I would need to do next with the users input and felt like I was overcomplicating it.


      2nd Solution Idea
      Separate the challenge into 3 main areas originally
      1. Set-up user Input, will need a an int value for the length of the grid/words and a string for the letters chosen.
      2. Find a way to loop through the dictionary text file, and printout/sort each word.
      3. From the users input loop through each character and count how many of each letter the was.
      4. From the dictionary loop go through each character of each line and count how many of each letter was there.
      5. Compare each dictionary word count to the user's to find only words that could match.
      6. Compare the lengths so only words with the same size as the user's original input were stored.
      7.



      Feedback and  Overall Improvements