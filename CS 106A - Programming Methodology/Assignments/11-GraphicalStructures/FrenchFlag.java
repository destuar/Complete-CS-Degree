/*
 * File: FrenchFlag.java
 * ---------------------
 * This program tests the FilledRect class by using it to
 * draw the French national flag.
 */

import acm.program.*;
import java.awt.*;

public class FrenchFlag extends GraphicsProgram {

	public void run() {
		double width = getWidth();
		double height = getHeight();
		double dx = width / 3;
		add(new FilledRect(0, 0, dx, height, Color.BLUE));
		add(new FilledRect(dx, 0, dx, height, Color.WHITE));
		add(new FilledRect(2 * dx, 0, dx, height, Color.RED));
	}

}
