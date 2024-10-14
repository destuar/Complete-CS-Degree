/*
 * File: Add3Rational.java
 * -----------------------
 * Simple test of the Rational class.
 */

import acm.program.*;

public class Add3Rational extends ConsoleProgram {

	public void run() {
		Rational a = new Rational(1, 2);
		Rational b = new Rational(1, 3);
		Rational c = new Rational(1, 6);
		Rational sum = a.add(b).add(c);
		println(a + " + " + b + " + " + c + " = " + sum);
	}

}
