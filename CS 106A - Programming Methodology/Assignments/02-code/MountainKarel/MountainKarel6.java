/*
 * File: MountainKarel6.java
 * -------------------------
 * The MountainKarel6 subclass gets Karel to climb a simple
 * mountain, plant a flag, and descend to the ground.  This
 * version attempts to generalize the program to solve a
 * stair-step mountain of any size, but fails to implement
 * the descent correctly.
 */

import stanford.karel.*;

public class MountainKarel6 extends SuperKarel {

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
 * any size, but the code is buggy.
 */
	private void climbMountain() {
		while (frontIsBlocked()) {
			stepUp();
		}
		putBeeper();
		while (frontIsClear()) {
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

