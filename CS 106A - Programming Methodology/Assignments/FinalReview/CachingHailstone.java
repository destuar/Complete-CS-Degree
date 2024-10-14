/*
 * File: CachingHailstone.java
 * ---------------------------
 * This program prints the number of steps required to compute
 * the hailstone sequence for each value from 1 to 100, but does
 * so in a way so that each value is computed only once.
 */

import acm.program.*;
import java.util.*;

public class CachingHailstone extends ConsoleProgram {

	public void run() {
		HashMap<Integer,Integer> cache = new HashMap<Integer,Integer>();
		for (int i = 1; i <= 100; i++) {
			int nSteps = countSteps(i, cache);
			println("Hailstone(" + i + ") requires " + nSteps + " steps");
		}
	}

/**
 * Returns the number of steps in the hailstone sequence beginning
 * at <code>n</code>.  The <code>cache</code> parameter keeps track
 * of all previously calculated chain lengths to speed up the
 * computation.
 * 
 * @param n The starting value
 * @param cache A map of previously calculated step counts
 * @return The number of steps in the hailstone sequence
 */
	private int countSteps(int n, HashMap<Integer,Integer> cache) {
		if (trace) println("Computing Hailstone(" + n + ")");
		ArrayList<Integer> numbersSoFar = new ArrayList<Integer>();
		while (n != 1 && !cache.containsKey(n)) {
			numbersSoFar.add(n);
			if (n % 2 == 0) {
				n = n / 2;
			} else {
				n = 3 * n + 1;
			}
		}
		if (trace && n > 1) println("Using cache for " + n);
		int nSteps = (n == 1) ? 0 : cache.get(n);
		for (int i = numbersSoFar.size() - 1; i >= 0; i--) {
			nSteps++;
			cache.put(numbersSoFar.get(i), nSteps);
		}
		return nSteps;
	}

	public static void main(String[] args) {
		new CachingHailstone().start(args);
	}

/* Instance variables */
	private boolean trace = true;

}
