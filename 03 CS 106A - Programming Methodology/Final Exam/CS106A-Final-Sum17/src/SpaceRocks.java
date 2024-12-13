/*
 * FILE: SpaceRocks.java
 * ----------------------
 * This program displays and manages a
 * horizontal list of "space rocks" (GOvals).  They
 * are displayed from left to right, with random colors.
 * When the user clicks on two rocks, one after the other,
 * the rocks should swap.  When the user clicks on a rock
 * twice in a row, it should be removed, and all rocks
 * to its right should shift down to retain the correct padding
 * between rocks.
 */

import java.awt.Color;
import java.awt.event.*;
import java.util.*;
import acm.graphics.*;
import acm.program.*;
import acm.util.*;

public class SpaceRocks extends GraphicsProgram {

	// START PROVIDED CODE *********************
	private static final int NUM_ROCKS = 7;
	private static final int ROCK_DIAMETER = 80;
	private static final int ROCK_SPACING = 20;
	// END PROVIDED CODE *********************
	
	private GOval lastSelection;
	private ArrayList<GOval> rocks;

	public void run() {
		// Sizes the screen to just fit the rocks.  Not required to write this.
		setSize(NUM_ROCKS*ROCK_DIAMETER + (NUM_ROCKS-1)*ROCK_SPACING, ROCK_DIAMETER);
		addRocks();
		repositionRocks();
	}
	
	// This method adds NUM_ROCKS rocks to our ArrayList, and the screen at (0, 0)
	private void addRocks() {
		rocks = new ArrayList<>();
		for (int i = 0; i < NUM_ROCKS; i++) {
			GOval rock = new GOval(ROCK_DIAMETER, ROCK_DIAMETER);
			rock.setFilled(true);
			rock.setColor(RandomGenerator.getInstance().nextColor());
			add(rock);
			rocks.add(rock);
		}
	}
	
	// This method updates the locations of all rocks in our arraylist.
	private void repositionRocks() {
		double x = 0;
		for (GOval rock : rocks) {
			rock.setLocation(x, 0);
			x += ROCK_DIAMETER + ROCK_SPACING;
		}
	}
	
	public void mouseClicked(MouseEvent e) {
		GOval currentSelection = getElementAt(e.getX(), e.getY());
		
		// If this is the first of two clicks, record the selection
		if (lastSelection == null) {
			lastSelection = currentSelection;
		} else {
			// If this click is the same as the last, remove the rock
			if (lastSelection == currentSelection) {
				rocks.remove(currentSelection);
				remove(currentSelection);
				lastSelection = null;
			} else {
				// This click is different from the last, so swap rocks
				int lastSelectionIndex = rocks.indexOf(lastSelection);
				int currentSelectionIndex = rocks.indexOf(currentSelection);
				rocks.set(lastSelectionIndex, currentSelection);
				rocks.set(currentSelectionIndex, lastSelection);
				lastSelection = null;
			}
			
			// Since we have changed rock positions, recalculate positions
			repositionRocks();
		}
	}
}