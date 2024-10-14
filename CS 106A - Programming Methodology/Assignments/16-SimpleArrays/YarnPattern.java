/*
 * File: YarnPattern.java
 * ----------------------
 * This program illustrates the use of the GLine class to simulate
 * winding a piece of colored yarn around a set of pegs equally
 * spaced along the edges of the canvas.  At each step, the yarn is
 * stretched from its current peg to the one DELTA pegs further on.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

/**
 * This program creates a pattern that simulates the process of winding a piece
 * of colored yarn around an array of pegs along the edges of the canvas.
 */
public class YarnPattern extends GraphicsProgram {

	public void run() {
		initPegArray();
		int thisPeg = 0;
		int nextPeg = -1;
		while (thisPeg != 0 || nextPeg == -1) {
			nextPeg = (thisPeg + DELTA) % N_PEGS;
			GPoint p0 = pegs[thisPeg];
			GPoint p1 = pegs[nextPeg];
			GLine line = new GLine(p0.getX(), p0.getY(), p1.getX(), p1.getY());
			line.setColor(Color.MAGENTA);
			add(line);
			thisPeg = nextPeg;
		}
	}

/* Initialize the array of pegs */
	private void initPegArray() {
		int currentPeg = 0;
		for (int i = 0; i < N_ACROSS; i++) {
			pegs[currentPeg++] = new GPoint(i * PEG_SEP, 0);
		}
		for (int i = 0; i < N_DOWN; i++) {
			pegs[currentPeg++] = new GPoint(N_ACROSS * PEG_SEP, i * PEG_SEP);
		}
		for (int i = N_ACROSS; i > 0; i--) {
			pegs[currentPeg++] = new GPoint(i * PEG_SEP, N_DOWN * PEG_SEP);
		}
		for (int i = N_DOWN; i > 0; i--) {
			pegs[currentPeg++] = new GPoint(0, i * PEG_SEP);
		}
	}

/* Private constants */
	private static final int DELTA = 72;      /* How many pegs to advance       */
	private static final int PEG_SEP = 10;    /* Pixels separating each peg     */
	private static final int N_ACROSS = 50;   /* Pegs across (minus one corner) */
	private static final int N_DOWN = 30;     /* Pegs down (minus one corner)   */
	private static final int N_PEGS = 2 * N_ACROSS + 2 * N_DOWN;

/* Private instance variables */
	private GPoint[] pegs = new GPoint[N_PEGS];

/* Make sure that the application has the right dimensions */
	public static final int APPLICATION_WIDTH = N_ACROSS * PEG_SEP;
	public static final int APPLICATION_HEIGHT = N_DOWN * PEG_SEP;

}
