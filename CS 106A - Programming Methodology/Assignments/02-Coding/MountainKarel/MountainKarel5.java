/*
 * File: MountainKarel5.java
 * -------------------------
 * The MountainKarel5 subclass gets Karel to climb a simple
 * mountain, plant a flag, and descend to the ground.  This
 * version extends the previous version by having Karel
 * approach the mountain, climb it, and then move away to the
 * east end of the world.  This implementation remains limited
 * to a mountain of a fixed size.
 */

import stanford.karel.*;

public class MountainKarel5 extends SuperKarel {

/**
 * Runs the program.
 */
	public void run() {
		moveToWall();
		climbMountain();
		moveToWall();
	}

/**
 * Climbs up and down a stair-step mountain whose size
 * matches the specification in the for statement.
 */
	private void climbMountain() {
		for (int i = 0; i < 3; i++) {
			stepUp();
		}
		putBeeper();
		for (int i = 0; i < 3; i++) {
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

/**
 * Moves Karel forward until it is blocked by a wall.
 */
	private void moveToWall() {
		while (frontIsClear()) {
			move();
		}
	}
}
