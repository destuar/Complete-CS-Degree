/*
 * File: FacePamphlet.java
 * -----------------------
 * This is the starter file for Assignment #5, in which you get to
 * implement FacePamphlet -- a simplified version of Facebook.
 */

import acm.program.*;
import stanford.facepamphlet.*;

public class FacePamphlet extends ConsoleProgram implements FPConstants {

/* Initializes the application */

	public void init() {
		repository = new FPRepositoryStub("eroberts", "Eric Roberts");
		// You fill in the rest
	}

/* Instance variables */
	private FPRepository repository;

}
