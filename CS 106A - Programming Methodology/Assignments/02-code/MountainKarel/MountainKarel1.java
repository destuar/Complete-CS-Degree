/*
 * File: MountainKarel1.java
 * -------------------------
 * The MountainKarel1 subclass gets Karel to climb a simple
 * mountain, plant a flag, and descend to the ground.  This
 * version works only for the specific world shown in the
 * handout.
 */

import stanford.karel.*;

public class MountainKarel1 extends Karel {
	public void run() {
		turnLeft();
		move();
		turnLeft();
		turnLeft();
		turnLeft();
		move();
		turnLeft();
		move();
		turnLeft();
		turnLeft();
		turnLeft();
		move();
		putBeeper();
		move();
		turnLeft();
		turnLeft();
		turnLeft();
		move();
		turnLeft();
		move();
		turnLeft();
		turnLeft();
		turnLeft();
		move();
		turnLeft();
	}
}
