/*
 * File: MountainKarel2.java
 * -------------------------
 * The MountainKarel2 subclass gets Karel to climb a simple
 * mountain, plant a flag, and descend to the ground.  This
 * version works only for the specific world shown in the
 * handout, but does define turnRight to simplify the code.
 */

import stanford.karel.*;

public class MountainKarel2 extends Karel {

/**
 * Runs the program.
 */
	public void run() {
		turnLeft();
		move();
		turnRight();
		move();
		turnLeft();
		move();
		turnRight();
		move();
		putBeeper();
		move();
		turnRight();
		move();
		turnLeft();
		move();
		turnRight();
		move();
		turnLeft();
	}

/**
 * Turns Karel 90 degrees to the right.
 */
	private void turnRight() {
		turnLeft();
		turnLeft();
		turnLeft();
	}
}
