/*
 * File: PutBeeperLine.java
 * ------------------------
 * This program tests the putBeeperLine method, which creates a
 * line of beepers moving forward from Karel’s position.
 */

import stanford.karel.*;

public class PutBeeperLine extends SuperKarel {

	public void run() {
		putBeeperLine();
		turnLeft();
		putBeeperLine();
	}

/*
 * Creates a line of beepers by putting a beeper down on every
 * intersection between Karel's current position and the next wall.
 */
	private void putBeeperLine() {
		while (frontIsClear()) {
			putBeeper();
			move();
		}
		putBeeper();
	}

}
