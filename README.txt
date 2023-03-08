      Instructions to run program.
        Run the WordSquareApp class.
        The console will prompt the user to input a number and press enter.
        The console will then prompt the user to input letters and press enter.
        If the program was successful at creating a word square, the square will appear below the user's input moments later.
        If the program was unsuccessful at creating a word square, a message will appear with the following, Unable to create a valid word square! :( .


      Thought process
      1. Will need to start with user Input,
            1a. Int value for the size of the grid/words.
            1b. String for the letters from the user's input.
      2. Find a way to read the dictionary text file, and be able to sort the words that are valid and be able to store them.
      3a.Using the users input loop through each character and count how many of each letter the is.
      3b.From the dictionary loop go through each character of each word and count how many of each letter was contained in each word.
      5. Compare each dictionary word count to the user's to find only words that contained the correct letters.
      6. Compare the lengths so only words with the same size as the user's original input were stored. (This is a stage I think could be done a lot sooner to make the process faster.)
      7. Now at this stage we should have valid words that can be used to try and make a valid word square, this was a point I really struggle to figure out how to go about doing and had to look heavy at Google and also use examples to help me achieve the final goal the word square.
        7a. The first was based off a similar tech challenge where you have to create a word square form an array of words provided, however, once I try to adapt and implement it into my code, I didn't like that it produced 2Dimensional arrays nested and a lot of duplicate words in some sets and was really struggling to also get the nice square shape displayed on the console.
        7b. The 2nd option is the one implemented which doing the word square setup was easy to understand and break down, and I think the is maybe a few things I can do there. However, the algorithm I do somewhat struggle to understand what it is doing but know that it helps to create a square that cna be read horizontally and vertically.
