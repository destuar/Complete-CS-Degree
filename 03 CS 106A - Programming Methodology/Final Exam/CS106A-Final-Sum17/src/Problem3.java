/* FILE: Problem3.java
 * -------------------------
 * This program models messages as arrays of bits (1 and 0).
 * The first step is it "corrects" corrupted bits; the rule for
 * correcting is there should be no more than 3 of the same bits in a row.
 * Bits should be flipped from left to right to ensure this.
 * 
 * The second step is to translate the bits into letters.  Every K
 * bits represent 1 letter, where K = decodeLength.  You are provided
 * a decode map mapping strings of K bits to a letter.  This program
 * translates each K bits into its letter (assume the bits are evenly 
 * divisible by K, and each K bits translates into a letter), and
 * returns the decoded message.
 */

import acm.program.*;
import java.util.*;

public class Problem3 extends ConsoleProgram {

	// Test code
	public void run() {
		int[] message = {0, 0, 0, 1, 1, 1, 0, 1};
		HashMap<String, Character> decode = new HashMap<>();
		decode.put("0001", 'a');
		decode.put("1101", 'b');
		println(correctAndDecodeMessage(message, 4, decode));
		
		int[] message2 = {0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 0};	// 0 0 0 1 1 1 0 0 0 1 1 0
		decode.put("000", 'a');
		decode.put("111", 'b');
		decode.put("110", 'c');
		println(correctAndDecodeMessage(message2, 3, decode));
	}

	// Test code
	private String correctAndDecodeMessage(int[] message, int decodeLength, HashMap<String, Character> decodeMap) {
		correctMessage(message);
		// correctMessageAlternate(message);
		return decodeMessage(message, decodeLength, decodeMap);
	}

	// Part 1
	private void correctMessage(int[] message) {
		if (message.length == 0) {
			return;
		}

		// The current repetition length, and its repeated bit
		int currentRepetitionLength = 1;
		int repeatedBit = message[0];

		// Iterate over the rest of the bits and flip as needed
		for (int i = 1; i < message.length; i++) {
			if (message[i] == repeatedBit) {
				currentRepetitionLength++;

				// If we reach 4 in a row, flip the bit and start our counting over.
				if (currentRepetitionLength == 4) {
					message[i] = 1 - message[i];
					currentRepetitionLength = 1;
					repeatedBit = message[i];
				}
			} else {
				currentRepetitionLength = 1;
				repeatedBit = message[i];
			}
		}
	}
	
	// Alternate solution
	private void correctMessageAlternate(int[] message) {
		// Check every combination of sequential 4 bits
		for (int i = 0; i <= message.length - 4; i++) {
			
			// Check if i, i+1, i+2, i+3 are the same
			int count = 0;
			for (int checkIndex=i+1; checkIndex < i+4; checkIndex++) {
				if (message[checkIndex - 1] == message[checkIndex]) {
					count++;
				}
			}
			
			// If all bits are the same, flip the last one
			if (count == 3) {
				message[i+3] = 1 - message[i+3];
			}
		}
	}

	// Part 2
	private String decodeMessage(int[] message, int decodeLength, HashMap<String, Character> decodeMap) {
		// Build up our decoded message by decoding each chunk of bits
		String decodedMessage = "";
		for (int i = 0; i < message.length; i+= decodeLength) {
			// Build up a string containing our current chunk of bits
			String currMessage = "";
			for (int j = i; j < i+decodeLength; j++) {
				currMessage += message[j];
			}

			// Add the decoded letter to our messagge
			decodedMessage += decodeMap.get(currMessage);
		}
		return decodedMessage;
	}
}

