/*
 * File: MountainKarel3.java
 * -------------------------
 * The MountainKarel3 subclass gets Karel to climb a simple
 * mountain, plant a flag, and descend to the ground.  This
 * version works only for the specific world shown in the
 * handout, but defines stepUp and StepDown as tools.
 */

import stanford.karel.*;

public class MountainKarel3 extends SuperKarel {

/**
 * Runs the program.
 */
	public void run() {
		stepUp();
		stepUp();
		putBeeper();
		stepDown();
		stepDown();
	}

/**
 * Send Karel up the step ahead of it.
 */
	private void stepUp() {
		turnLeft();
		move();
		turnRight();
		move();
	}

/**
 * Send Karel down the step ahead of it.
 */
	private void stepDown() {
		move();
		turnRight();
		move();
		turnLeft();
	}
}
