/*
 * File: MountainKarel7.java
 * -------------------------
 * The MountainKarel7 subclass gets Karel to climb a simple
 * mountain, plant a flag, and descend to the ground.  This
 * version generalizes the program so that it can climb a
 * stair-step mountain of any size.
 */

import stanford.karel.*;

/* Main program */

public class MountainKarel7 extends SuperKarel {

/**
 * Runs the program.
 */
	public void run() {
		moveToWall();
		climbMountain();
		moveToWall();
	}

/**
 * Purports to climb up and down a stair-step mountain of
 * any size.  This code is considerably better than the
 * last attempt, but still has a small bug.
 */
	private void climbMountain() {
		while (frontIsBlocked()) {
			stepUp();
		}
		putBeeper();
		move();
		while (rightIsClear()) {
			dropDown();
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
 * Drops down from the midair position just past a
 * descending step.
 */
	private void dropDown() {
		turnRight();
		move();
		turnLeft();
		if (frontIsClear()) {
			move();
		}
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

