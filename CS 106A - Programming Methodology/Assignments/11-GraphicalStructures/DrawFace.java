/*
 * File: DrawFace.java
 * -------------------
 * This program draws a face by defining a Face class that
 * extends GCompound.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.event.*;

public class DrawFace extends GraphicsProgram {

	public void run() {
		GFace face = new GFace(FACE_WIDTH, FACE_HEIGHT);
		double x = (getWidth() - FACE_WIDTH) / 2;
		double y = (getHeight() - FACE_HEIGHT) / 2;
		add(face, x, y);
		addMouseListeners();
	}

/* Called on mouse press to record the coordinates of the click */
	public void mousePressed(MouseEvent e) {
		lastX = e.getX();
		lastY = e.getY();
		gobj = getElementAt(lastX, lastY);
	}

/* Called on mouse drag to reposition the object */
	public void mouseDragged(MouseEvent e) {
		if (gobj != null) {
			gobj.move(e.getX() - lastX, e.getY() - lastY);
			lastX = e.getX();
			lastY = e.getY();
		}
	}

/* Called on mouse click to move this object to the front */
	public void mouseClicked(MouseEvent e) {
		if (gobj != null) gobj.sendToFront();
	}

/* Private constants */
	private static final double FACE_WIDTH = 200;   /* Width of the face  */
	private static final double FACE_HEIGHT = 300;  /* Height of the face */

/* Private instance variables */
	private GObject gobj;       /* The object being dragged  */
	private double lastX;       /* The last mouse X position */
	private double lastY;       /* The last mouse Y position */

}
