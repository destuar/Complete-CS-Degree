/*
 * File: PieChart.java
 * -------------------
 * Solves the pie chart problem on the final.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class PieChart extends GraphicsProgram {

	public static void main(String[] args) {
		new PieChart().start(args);
	}

	public void run() {
		double[] data = { 45, 25, 15, 10, 5 };
		GCompound pieChart = createPieChart(50, data);
		add(pieChart, getWidth() / 2, getHeight() / 2);
	}
	
/**
 * Creates a <code>GCompound</code> object that represents a pie
 * chart composed of the data in the array.  The reference point
 * of the <code>GCompound</code> is the center of the circle.
 *
 * @param r The radius of the pie chart
 * @param data An array specifying the values to be plotted
 * @return A <code>GCompound</code> containing the pie chart
 */
	private GCompound createPieChart(double r, double[] data) {
		GCompound gc = new GCompound();
		double total = sumArray(data);
		double start = 0;
		for (int i = 0; i < data.length; i++) {
			double sweep = 360.0 * data[i] / total;
			GArc arc = new GArc(-r, -r, 2 * r, 2 * r, start, sweep);
			arc.setFilled(true);
			arc.setFillColor(WEDGE_COLORS[i % WEDGE_COLORS.length]);
			gc.add(arc);
			start += sweep;
		}
		return gc;
	}
	
/**
 * Returns the sum of the array.
 *
 * @param array An array of <code>double</code> values
 * @return The sum of those values
 */
	private double sumArray(double[] array) {
		double total = 0;
		for (int i = 0; i < array.length; i++) {
			total += array[i];
		}
		return total;
	}

/* Colors for the individual wedges */
	private static Color[] WEDGE_COLORS = {
		Color.RED, Color.YELLOW, Color.BLUE, Color.GREEN,
		Color.PINK, Color.CYAN, Color.MAGENTA, Color.ORANGE
	};

}
