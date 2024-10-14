/*
 * File: RedCross.java
 * -------------------
 * This file illustrates the use of the GCross class by drawing
 * a red cross at the center of the canvas.
 */

import acm.program.*;
import acm.graphics.*;
import java.awt.*;

public class RedCross extends GraphicsProgram {

	public void run() {
		GCross cross = new GCross(100);
		cross.setFilled(true);
		cross.setColor(Color.RED);
		add(cross, getWidth() / 2, getHeight() / 2);
	}

}

/**
 * This class implements a graphical object that has the form of
 * a cross.
 */
class GCross extends GPolygon {

/**
 * Constructs a new GCross object of the specified size.  The width of
 * each cross arm is one third of the total width.
 * 
 * @param size The size of the cross (used for both the width and height)
 */
	public GCross(double size) {
		double edge = size / 3;
		addVertex(-size / 2, -edge / 2);
		addEdge(edge, 0);
		addEdge(0, -edge);
		addEdge(edge, 0);
		addEdge(0, edge);
		addEdge(edge, 0);
		addEdge(0, edge);
		addEdge(-edge, 0);
		addEdge(0, edge);
		addEdge(-edge, 0);
		addEdge(0, -edge);
		addEdge(-edge, 0);
		addEdge(0, -edge);
	}
}
