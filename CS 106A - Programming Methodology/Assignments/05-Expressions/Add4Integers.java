/*
 * File: Add4Integers.java
 * -----------------------
 * This program adds four integers and prints their sum.
 */

import acm.program.*;

public class Add4Integers extends ConsoleProgram {
	public void run() {
		println("This program adds four numbers.");
		int n1 = readInt("Enter n1: ");
		int n2 = readInt("Enter n2: ");
		int n3 = readInt("Enter n3: ");
		int n4 = readInt("Enter n4: ");
		int total = n1 + n2 + n3 + n4;
		println("The total is " + total + ".");
	}
}
