/*
 * File: GermanFlag.java
 * ---------------------
 * This program tests the FilledRect class by using it to
 * draw the German national flag.
 */

import acm.program.*;
import java.awt.*;

public class GermanFlag extends GraphicsProgram {

	public void run() {
		double width = getWidth();
		double height = getHeight();
		double dy = height / 3;
		add(new FilledRect(0, 0, width, dy, Color.BLACK));
		add(new FilledRect(0, dy, width, dy, Color.RED));
		add(new FilledRect(0, 2 * dy, width, dy, Color.YELLOW));
	}

}
