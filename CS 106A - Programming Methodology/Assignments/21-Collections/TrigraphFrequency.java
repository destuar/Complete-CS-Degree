/*
 * File: TrigraphFrequency.java
 * ----------------------------
 * This file computes trigraph frquencies for an input text.
 */

import acm.program.*;
import acm.util.*;

import java.io.*;
import java.util.*;

public class TrigraphFrequency extends ConsoleProgram {

	public void run() {
		BufferedReader rd = openInputFile("Enter name of text file: ");
		String[] lineArray = readLineArray(rd);
		produceTrigraphReport(lineArray);
	}

/**
 * Produces a report showing all of the trigraphs (three character sequences)
 * and their counts in the file.
 */
	private void produceTrigraphReport(String[] lineArray) {
		TreeMap<String,Integer> trigraphMap = new TreeMap<String,Integer>();
		for (String line : lineArray) {
			countTrigraphsInLine(line, trigraphMap);
		}
		printTrigraphCounts(trigraphMap);
	}

/**
 * Tabulates the trigraph count for the specified line, updating
 * the values in trigraphMap.
 */
	private void countTrigraphsInLine(String line, Map<String,Integer> trigraphMap) {
		line = line.toUpperCase();
		for (int i = 0; i < line.length() - 2; i++) {
			String trigraph = line.substring(i, i + 3);
			if (containsOnlyLetters(trigraph)) {
				if (trigraphMap.containsKey(trigraph)) {
					trigraphMap.put(trigraph, trigraphMap.get(trigraph) + 1);
				} else {
					trigraphMap.put(trigraph, 1);
				}
			}
		}
	}

/** Checks if a string contains only letters */
	private boolean containsOnlyLetters(String str) {
		for (int i = 0; i < str.length(); i++) {
			if (!Character.isLetter(str.charAt(i))) return false;
		}
		return true;
	}

/** Displays the table of letter counts */
	private void printTrigraphCounts(SortedMap<String,Integer> trigraphMap) {
		for (String trigraph : trigraphMap.keySet()) {
			println(trigraph + " = " + trigraphMap.get(trigraph));
		}
	}

/**
 * Asks the user for the name of an input file and returns a
 * BufferedReader attached to its contents.  If the file does
 * not exist, the user is given another chance to try.
 */ 
	private BufferedReader openInputFile(String prompt) {
		BufferedReader rd = null;
		while (rd == null) {
			try {
				String name = readLine(prompt);
				rd = new BufferedReader(new FileReader(name));
			} catch (IOException ex) {
				println("Can't open that file.");
			}
		}
		return rd;
	}

/**
 * Reads all available lines from the specified reader and returns an array
 * containing those lines.  This method closes the reader at the end of the
 * file.
 */
	private String[] readLineArray(BufferedReader rd) {
		ArrayList<String> lineList = new ArrayList<String>();
		try {
			while (true) {
				String line = rd.readLine();
				if (line == null) break;
				lineList.add(line);
			}
			rd.close();
		} catch (IOException ex) {
			throw new ErrorException(ex);
		}
		String[] result = new String[lineList.size()];
		for (int i = 0; i < result.length; i++) {
			result[i] = lineList.get(i);
		}
		return result;
	}

}
