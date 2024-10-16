/*
 * File: MountainKarel4.java
 * -------------------------
 * The MountainKarel4 subclass gets Karel to climb a simple
 * mountain, plant a flag, and descend to the ground.  This
 * version can easily be tailored for a mountain of any height,
 * but still requires program changes to change the size of the
 * mountain.
 */

import stanford.karel.*;

public class MountainKarel4 extends SuperKarel {

/**
 * Runs the program.
 */
	public void run() {
		for (int i = 0; i < 4; i++) {
			stepUp();
		}
		putBeeper();
		for (int i = 0; i < 4; i++) {
			stepDown();
		}
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
