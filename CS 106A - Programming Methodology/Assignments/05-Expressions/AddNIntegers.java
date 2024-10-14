/*
 * File: AddNIntegers.java
 * -----------------------
 * This program adds N integers, where N is specified as a
 * named constant.
 */

import acm.program.*;

public class AddNIntegers extends ConsoleProgram {
	public void run() {
		println("This program adds " + N + " numbers.");
		int total = 0;
		for (int i = 0; i < N; i++) {
			int value = readInt(" ? ");
			total += value;
		}
		println("The total is " + total + ".");
	}

	private static final int N = 100;
}
