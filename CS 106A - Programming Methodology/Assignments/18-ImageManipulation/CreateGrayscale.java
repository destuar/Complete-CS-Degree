/*
 * File: CreateGrayscale.java
 * --------------------------
 * This program converts a color image to grayscale.
 */

import acm.graphics.*;
import acm.program.*;

public class CreateGrayscale extends GraphicsProgram {

	public void run() {
		GImage colorImage = new GImage("ColorWheel.gif");
		GImage grayscaleImage = createGrayscaleImage(colorImage);
		double xLeft = (getWidth() - 2 * colorImage.getWidth()) / 3;
		double xRight = getWidth() - colorImage.getWidth() - xLeft;
		double y = (getHeight() - colorImage.getHeight()) / 2;
		add(colorImage, xLeft, y);
		add(grayscaleImage, xRight, y);
	}

	private GImage createGrayscaleImage(GImage image) {
		int[][] array = image.getPixelArray();
		int height = array.length;
		int width = array[0].length;
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				int pixel = array[i][j];
				int red = (pixel >> 16) & 0xFF;
				int green = (pixel >> 8) & 0xFF;
				int blue = pixel & 0xFF;
				int xx = computeLuminosity(red, green, blue);
				pixel = (0xFF << 24) | (xx << 16) | (xx << 8) | xx;
				array[i][j] = pixel;
			}
		}
		return new GImage(array);
	}

	private int computeLuminosity(int r, int g, int b) {
		return GMath.round(0.299 * r + 0.587 * g + 0.114 * b);
	}

/* Standard Java entry point */
/* This method can be eliminated in most Java environments */
	public static void main(String[] args) {
		new CreateGrayscale().start(args);
	}

/* Set the dimensions of the window */
	public static final int APPLICATION_WIDTH = 800;
	public static final int APPLICATION_HEIGHT = 475;

}
