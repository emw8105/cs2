import java.util.*;
public class Hangman {

	public static void main(String[] args) {
		String[] words = { "write", "program", "that", "receive", "positive" };
		char menuChoice = 'y';
		Scanner input = new Scanner(System.in);
		do {
			int rand = (int) (Math.random() * words.length); // get random word from the list
			String trueWordStr = words[rand];
			int wordLength = trueWordStr.length(); // store the length of the string for looping
			char[] trueWord = new char[wordLength]; // declare array of chars with the size of random word
			char[] hiddenWord = new char[wordLength]; // same as above but will be filled with asterisks until guessed
			for (int i = 0; i < wordLength; i++) { // loop through array
				trueWord[i] = trueWordStr.charAt(i); // fill array of chars with letters in string
				hiddenWord[i] = '*';
			}

			int numGuess = 0;
			int numMisses = 0;
			char[] guessesList = new char[26]; // should only have letters so 26 is enough
			boolean wordCompleted = false;

			while (wordCompleted == false) { // loop until guesses are out or word is solved
				System.out.print("(Guess) Enter a letter in word "); // prompt user and show currently resolved word
				for (int i = 0; i < wordLength; i++) {
					System.out.print(hiddenWord[i]);
				}
				System.out.print(" > ");
				char guess = input.next().charAt(0); // effectively nextChar(), will just grab first char of string
				boolean alreadyGuessed = false;
				for (int i = 0; i < guessesList.length; i++) {
					if (guess == guessesList[i]) { // if the letter has already been guessed
						System.out.println("\t" + guess + " is already in the word");
						alreadyGuessed = true; // set to true to get next input instead of searching for letter
					}
				}
				
				if (alreadyGuessed == false) { // only look for letter if the guess is a new one
					
					guessesList[numGuess] = guess; // add the new guess to the list of guesses

					boolean miss = true;
					for (int i = 0; i < wordLength; i++) {
						if (guess == trueWord[i]) { // if there was a matching letter in the word
							hiddenWord[i] = trueWord[i]; // reveal the placement of the letter in hiddenWord
							miss = false;
						}
					}
					if (miss == true) { // if a matching letter was not found
						System.out.println("\t" + guess + " is not in the word");
						numMisses++;
					}

					numGuess++; // increment numGuess, not incremented if guess was a previous guess though

					int numRevealed = 0;
					for (int i = 0; i < wordLength; i++) { // check if the word is completed
						if (hiddenWord[i] == trueWord[i]) {
							numRevealed++;
						}
					}
					if (numRevealed == wordLength) { // if every letter has been revealed
						wordCompleted = true;
						System.out.print("The word is " + trueWordStr + ". You missed ");
						if (numMisses == 1) // grammatically correct output
							System.out.println(numMisses + " time");
						else
							System.out.println(numMisses + " times");
					}
				}
			} // once loop is escaped, prompt user by asking if they want to play again
			System.out.println("Do you want to guess another word? Enter y or n>");
			menuChoice = input.next().charAt(0); // receive user input

		} while (menuChoice == 'y'); // loop as long as the user would like to play

		input.close();
	}

}
