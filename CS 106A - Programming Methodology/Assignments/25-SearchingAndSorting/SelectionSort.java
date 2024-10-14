/*
 * File: SelectionSort.java
 * ------------------------
 * This program implements the selection sort algorithm for
 * integer arrays, along with a test program that reads in
 * a list of integers, sorts it, and then displays the result.
 */

import acm.program.*;
import java.util.*;

public class SelectionSort extends ConsoleProgram {

	public void run() {
		println("This program sorts an integer array.");
		int[] array = readIntArray();
		sort(array);
		println("That array in sorted order is:");
		printArray(array);
	}

/* Reads an integer array using a blank line as a sentinel */
	private int[] readIntArray() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		println("Enter the elements in the array, one per line.");
		println("Use a blank line to signal the end of the array.");
		while (true) {
			String line = readLine();
			if (line.length() == 0) break;
			try {
				list.add(Integer.parseInt(line));
			} catch (NumberFormatException ex) {
				println("Illegal integer format -- retry");
			}
		}
		int nElements = list.size();
		int[] array = new int[nElements];
		for (int i = 0; i < nElements; i++) {
			array[i] = list.get(i);
		}
		return array;
	}

/* Prints out the data from the list, one per line */
	private void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			println(array[i]);
		}
	}

/*
 * Sorts an integer array into increasing order.  The implementation uses
 * an algorithm called selection sort, which can be described informally
 * in English as follows:
 *
 *   With your left hand, point at each element in the array in turn, starting
 *   at index 0.  At each step in the cycle:
 *
 *     1. Find the smallest element in the range between your left hand and the
 *        end of the array, and point at that element with your right hand.
 *
 *     2. Move that element into its correct index position by switching the
 *        elements indicated by your left and right hands.
 */
	private void sort(int[] array) {
		for (int lh = 0; lh < array.length; lh++) {
			int rh = findSmallest(array, lh, array.length);
			swapElements(array, lh, rh);
		}
	}

/* Returns the index of the smallest array element between p1 and p2 - 1 */
	private int findSmallest(int[] array, int p1, int p2) {
		int smallestIndex = p1;
		for (int i = p1 + 1; i < p2; i++) {
			if (array[i] < array[smallestIndex]) smallestIndex = i;
		}
		return smallestIndex;
	}

/* Exchanges the elements in an array at index positions p1 and p2. */
	private void swapElements(int[] array, int p1, int p2) {
		int temp = array[p1];
		array[p1] = array[p2];
		array[p2] = temp;
	}

}
