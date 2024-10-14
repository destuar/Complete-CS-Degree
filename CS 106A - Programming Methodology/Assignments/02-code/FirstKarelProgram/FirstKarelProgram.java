/*
 * File: FirstKarelProgram.java
 * ----------------------------
 * This program solves the problem of moving a beeper to a ledge.
 */

import stanford.karel.*;

public class FirstKarelProgram extends Karel {
	public void run() {
		move();
		pickBeeper();
		move();
		turnLeft();
		move();
		turnLeft();
		turnLeft();
		turnLeft();
		move();
		putBeeper();
		move();
	}	
}
