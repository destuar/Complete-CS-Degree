/*
 * File: ReverseFile.java
 * ----------------------
 * This program reverses the lines in a file by reading them into an
 * ArrayList, converting the ArrayList into a string array, and then
 * printing the lines of the array in reverse order.
 */

import acm.program.*;
import acm.util.*;
import java.io.*;
import java.util.*;

/** This program reverses the lines in a file */
public class ReverseFile extends ConsoleProgram {

	public void run() {
		println("This program reverses the lines in a file.");
		BufferedReader rd = openInputFile("Enter input file: ");
		String[] lines = readLineArray(rd);
		for (int i = lines.length - 1; i >= 0; i--) {
			println(lines[i]);
		}
	}

/**
 * Reads all available lines from the specified reader and returns an array
 * containing those lines.  This method closes the reader at the end of the file.
 *
 * Implementation note:
 *   This implementation uses an ArrayList internally to read the lines of the
 *   file because doing so allows the list to expand dynamically.  However,
 *   because the definition of the method indicates that the method returns an
 *   array rather than an ArrayList, the implementation copies the ArrayList
 *   to an array after all the lines have been read.
 *
 * @param rd A BufferedReader for the input file
 * @return A string array containing the lines read from the reader
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

/**
 * Requests the name of an input file from the user and then opens
 * that file to obtain a BufferedReader.  If the file does not exist,
 * the user is given a chance to reenter the file name.
 *
 * @param prompt The string to print as a prompt to the user
 * @return A BufferedReader open to the file specified by the user
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

}
