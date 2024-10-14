/*
 * File: CountLetterFrequencies.java
 * ---------------------------------
 * This program counts the frequency of letters in user-entered text.
 */

import acm.program.*;

/**
 * This program creates a table of the letter frequencies in a 
 * paragraph of input text terminated by a blank line.
 */
public class CountLetterFrequencies extends ConsoleProgram {

	public void run() {
		println("This program counts letter frequencies.");
		println("Enter a blank line to indicate the end of the text.");
		initFrequencyTable();
		while (true) {
			String line = readLine();
			if (line.length() == 0) break;
			countLetterFrequencies(line);
		}
		printFrequencyTable();
	}

/* Initializes the frequency table to contain zeros */
	private void initFrequencyTable() {
		frequencyTable = new int[26];
		for (int i = 0; i < 26; i++) {
			frequencyTable[i] = 0;
		}
	}

/* Counts the letter frequencies in a line of text */
	private void countLetterFrequencies(String line) {
		for (int i = 0; i < line.length(); i++) {
			char ch = line.charAt(i);
			if (Character.isLetter(ch)) {
				int index = Character.toUpperCase(ch) - 'A';
				frequencyTable[index]++;
			}
		}
	}

/* Displays the frequency table */
	private void printFrequencyTable() {
		for (char ch = 'A'; ch <= 'Z'; ch++) {
			int index = ch - 'A';
			println(ch + ": " + frequencyTable[index]);
		}
	}

	/* Private instance variables */
	private int[] frequencyTable;

}
