/*
 * File: ReverseString.java
 * ------------------------
 * This program reverses a string.
 */

import acm.program.*;

/**
 * This class reverses the characters in a string.
 */

public class ReverseString extends ConsoleProgram {
	
/** Runs the program */
	public void run() {
		println("This program reverses a string.");
		while (true) {
			String str = readLine("Enter a string: ");
			if (str.length() == 0) break;
			println("Reverse: " + reverseString(str));
		}
	}

/** Returns a string with the characters reversed */
	public String reverseString(String str) {
		String result = "";
		for (int i = 0; i < str.length(); i++) {
			result = str.charAt(i) + result;
		}
		return result;
	}
}

