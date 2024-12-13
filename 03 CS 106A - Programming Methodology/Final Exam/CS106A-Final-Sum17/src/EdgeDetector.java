/* FILE: EdgeDetector.java
 * -----------------------
 * This program loads an image and displays a modified
 * version of the image after running it through an
 * edge detection algorithm.
 */

import acm.program.*;
import acm.graphics.*;
import java.awt.event.*;
import javax.swing.*;

public class EdgeDetector extends GraphicsProgram {

	/* START: PROVIDED CODE ********/
	private int computeLuminosity(int r, int g, int b) {
		return GMath.round((0.299 * r) + (0.587 * g) + (0.114 * b));
	}

	private static final int THRESHOLD = 6;
	/* END: PROVIDED CODE **********/

	JTextField textField;

	// The loaded-in image
	GImage image;

	// Implemented in Part 1
	private GImage detectEdges(GImage image) {
		int[][] pixels = image.getPixelArray();
		int[][] newPixels = new int[pixels.length][pixels[0].length];

		// Fill in each pixel of our edge detection image
		for (int r = 0; r < newPixels.length; r++) {
			for (int c = 0; c < newPixels[0].length; c++) {
				int ownLuminosity = computeLuminosity(GImage.getRed(pixels[r][c]),
						GImage.getGreen(pixels[r][c]),
						GImage.getBlue(pixels[r][c]));

				// Compute the average luminosity of our neighbors
				int totalLuminosity = 0;
				int numNeighbors = 0;
				for (int neighborRow = r-1; neighborRow <= r+1; neighborRow++) {
					for (int neighborCol = c-1; neighborCol <= c+1; neighborCol++) {

						// If this neighbor index is in bounds...
						if (neighborRow >= 0 && neighborRow < pixels.length 
								&& neighborCol >= 0 && neighborCol < pixels[0].length) {

							// If this neighbor index is not the original pixel...
							if(neighborRow != r || neighborCol != c) {

								// Add its luminosity to our calculations
								totalLuminosity += computeLuminosity(
										GImage.getRed(pixels[neighborRow][neighborCol]),
										GImage.getGreen(pixels[neighborRow][neighborCol]),
										GImage.getBlue(pixels[neighborRow][neighborCol])
										);
								numNeighbors++;
							}
						}
					}
				}

				int neighborAvgLuminosity = totalLuminosity/numNeighbors;

				// If our difference is > THRESHOLD, (r,c) is white.  Else, it is black.
				int luminosityDifference = Math.abs(ownLuminosity - neighborAvgLuminosity);
				if (luminosityDifference > THRESHOLD) {
					newPixels[r][c] = GImage.createRGBPixel(255, 255, 255);
				} else {
					newPixels[r][c] = GImage.createRGBPixel(0, 0, 0);
				}
			}
		}

		return new GImage(newPixels);
	}

	// Add interactors
	public void init() {
		add(new JLabel("Filename: "), SOUTH);
		textField = new JTextField(16);
		textField.addActionListener(this);
		textField.setActionCommand("Load Image");
		add(textField, SOUTH);
		add(new JButton("Load Image"), SOUTH);
		add(new JButton("Detect Edges"), SOUTH);
		addActionListeners();
	}

	public void actionPerformed(ActionEvent event) {
		// Load a new image and put it at (0, 0)
		if (event.getActionCommand().equals("Load Image")) {
			image = new GImage(textField.getText());
			add(image, 0, 0);
		} else if (event.getActionCommand().equals("Detect Edges")) {
			// Run edge detection on the already-loaded-in image.
			GImage newImage = detectEdges(image);
			add(newImage, image.getWidth(), 0);
		}
	}


}
