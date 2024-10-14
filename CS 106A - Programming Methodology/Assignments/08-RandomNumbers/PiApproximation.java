/*
 * File: PiApproximation.java
 * --------------------------
 * This progam computes an approximation to pi by simulating
 * a dart board, as described in the handout.  The general technique
 * is called Monte Carlo integration.
 */

import acm.program.*;
import acm.util.*;

public class PiApproximation extends ConsoleProgram {

/** Number of darts to throw. */
	private static final int NDARTS = 10000;

/** Runs the program */
	public void run() {
	    int inside = 0;
	    for (int i = 0; i < NDARTS; i++) {
	        double x = rgen.nextDouble(-1.0, +1.0);
	        double y = rgen.nextDouble(-1.0, +1.0);
	        if (x * x + y * y < 1.0) inside++;
	    }
	    double pi = 4.0 * inside / NDARTS;
	    println("Pi is approximately " + pi);
	}

/* Instance variables */

	private RandomGenerator rgen = new RandomGenerator();
}
