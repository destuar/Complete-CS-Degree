/*
 * File: SignMaker.java
 * --------------------
 * This program allows the user to compose an advertising
 * sign consisting of multiple lines of centered text.  The
 * user can set the font of each line independently.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.event.*;
import javax.swing.*;

public class SignMaker extends GraphicsProgram {
	
	public void init() {
		lineInputField = new JTextField(CHARS_IN_LINE_FIELD);
		lineInputField.addActionListener(this);
		fontField = new JTextField(CHARS_IN_FONT_FIELD);
		fontField.setText("Times-Bold-24");
		currentBaseline = 0;
		add(new JLabel("Line: "), SOUTH);
		add(lineInputField, SOUTH);
		add(new JLabel("  Font: "), SOUTH);
		add(fontField, SOUTH);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == lineInputField) {
			GLabel label = new GLabel(lineInputField.getText());
			label.setFont(fontField.getText());
			currentBaseline += label.getHeight();
			double x = (getWidth() - label.getWidth()) / 2;
			add(label, x, currentBaseline);
			lineInputField.setText("");
		}
	}
	
	public static void main(String[] args) {
		new SignMaker().start(args);
	}

/* Instance variables */
	private int currentBaseline;
	private JTextField lineInputField;
	private JTextField fontField;

/* Constants */
	private static final int CHARS_IN_LINE_FIELD = 30;
	private static final int CHARS_IN_FONT_FIELD = 15;

}
