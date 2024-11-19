/*
 * File: FPScrollableTextArea.java
 * -------------------------------
 * This file implements a scrollable text area.
 */

import acm.gui.*;
import acm.util.*;
import java.awt.*;
import javax.swing.*;

/**
 * This class implements a scrollable text area. Two of these
 * are used in the FacePamphlet assignment:
 * 
 * <p><ol>
 *   <li>The <b>display area</b>, which is used to display the
 *       complete contents of the wall, which grows as users write
 *       on it.
 *   <li>The <b>message area</b>, which is used to enter text that
 *       gets sent to the repository for inclusion in the display.
 * </ol>
 */

public class FPScrollableTextArea extends JPanel {

/**
 * Creates a new scrollable text area, which is initially empty.
 * By default, the text cannot be edited.  To change this property
 * for the message area, you need to call <code>setEditable(true)</code>.
 */
	public FPScrollableTextArea() {
		textPane = new JTextPane();
		textPane.setEditable(false);
		scroller = new JScrollPane(textPane);
		scroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		setLayout(new BorderLayout());
		add(scroller, BorderLayout.CENTER);
	}

/**
 * Clears the text area.
 */
	public void clear() {
		textPane.setText("");
	}

/**
 * Sets the text for this text area to the specified string.
 *
 * @param str The new text
 */
	public void setText(String str) {
		textPane.setText(str);
		textPane.repaint();
	}

/**
 * Gets the text currently shown in this text area.
 *
 * @return The text currently shown in this text area
 */
	public String getText() {
		return textPane.getText();
	}

/**
 * Controls whether this text area is editable by the user.  For
 * a text area (such as the display area of the wall) where the
 * application controls the contents, this property should be set
 * to <code>false</code>.  For a text area (such as the message
 * area) where the user types in data, this property should be set
 * to <code>true</code>.
 *
 * @param flag The constant <code>true</code> to make this editable,
 *             or <code>false</code> otherwise
 */
	public void setEditable(boolean flag) {
		textPane.setEditable(flag);
	}

/**
 * Returns <code>true</code> if this text area is editable, and
 * <code>false</code> if it is not.
 *
 * @return <code>true</code> if this text area is editable, and
 *         <code>false</code> otherwise
 */
	public boolean isEditable() {
		return textPane.isEditable();
	}

/**
 * Sets the font for this text area.  The font is specified as
 * a string in the form
 *
 * <p>&nbsp;&nbsp;&nbsp;<i>family</i>-<i>style</i>-<i>size</i>
 *
 * <p>where both <i>style</i> and <i>size</i> are optional.
 *
 * @param font The string representation of the font
 */
	public void setFont(String font) {
		Font javaFont = JTFTools.decodeFont(font);
		setFont(javaFont);
		textPane.setFont(javaFont);
	}

/**
 * Returns the preferred dimensions of this text area.
 * This code is particularized to the structure of the FacePamphlet
 * application.  Each <code>FPScrollableTextArea</code> in its
 * container is given a height so that the total vertical space
 * is filled and that the first text area gets twice as much space
 * as the others.
 *
 * @return The desired dimensions for the panel
 */
	public Dimension getPreferredSize() {
		int width = PREFERRED_WIDTH;
		int height = PREFERRED_HEIGHT;
		Container parent = getParent();
		if (parent != null) {
			Dimension parentSize = parent.getSize();
			if (parentSize != null && parentSize.height > 0) {
				int vgap = 0;
				LayoutManager layout = parent.getLayout();
				if (layout instanceof TableLayout) {
					vgap = ((TableLayout) layout).getVgap();
				}
				int availableHeight = parentSize.height - vgap - EXTRA_MARGIN;
				int nTextAreas = 0;
				int myIndex = -1;
				for (Component component : parent.getComponents()) {
					if (component instanceof FPScrollableTextArea) {
						if (component == this) myIndex = nTextAreas;
						nTextAreas++;
					} else {
						availableHeight -= component.getPreferredSize().height + vgap;
					}
				}
				height = ((myIndex == 0) ? 2 : 1) * (availableHeight / (nTextAreas + 1));
			}
		}
		return new Dimension(width, height);
	}
		
/* Private constants */

	private static final int PREFERRED_WIDTH = 300;
	private static final int PREFERRED_HEIGHT = 100;
	private static final int EXTRA_MARGIN = 4;

/* Instance variables */

	private JTextPane textPane;
	private JScrollPane scroller;

}
