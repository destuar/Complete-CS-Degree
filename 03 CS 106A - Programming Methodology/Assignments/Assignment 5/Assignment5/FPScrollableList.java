/*
 * File: FPScrollableList.java
 * ---------------------------
 * This file implements a scrolling list interactor.
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * This class implements a scrolling list interactor.
 * You can use this list in the FacePamphlet assignment for the
 * lists of friends and friend requests.  You can select individual
 * names from the list by clicking on them.  Double-clicking on a
 * name notifies any action listeners that have been registered for
 * this list.
 */

public class FPScrollableList extends JPanel {

/**
 * Creates a new FPFriendList object.  The list is initially empty.
 */
	public FPScrollableList() {
		list = new JList();
		model = new DefaultListModel();
		list.setModel(model);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.addMouseListener(new FPScrollableListListener(this));
		scrollPane = new JScrollPane(list);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		setLayout(new BorderLayout());
		add(scrollPane, BorderLayout.CENTER);
		setPreferredSize(new Dimension(PREFERRED_WIDTH, PREFERRED_HEIGHT));
	}

/**
 * Removes all names from the list.  You need to call <code>clear</code>
 * before refreshing the list.
 */
	public void clear() {
		model.clear();
		list.repaint();
	}

/**
 * Adds a new name to the bottom of the list.
 *
 * @param name The name to be added
 */
	public void add(String name) {
		model.addElement(name);
		list.repaint();
	}

/**
 * Gets the selected name from the list.  If no name is selected,
 * the <code>getSelectedName</code> method returns <code>null</code>.
 *
 * @return The currently selected name (or <code>null</code> if no name is selected)
 */
	public String getSelectedName() {
		int index = list.getSelectedIndex();
		if (index == -1) return null;
		return (String) model.get(index);
	}

/**
 * Sets the action command sent if this list is double-clicked.
 *
 * @param command The action command sent if this list is double-clicked
 */
	public void setActionCommand(String command) {
		actionCommand = command;
	}

/**
 * Returns the action command sent if this list is double-clicked.
 *
 * @return The action command sent if this list is double-clicked
 */
	public String getActionCommand() {
		return actionCommand;
	}

/**
 * Adds an action listener to this list.
 *
 * @param listener Any object that implements the <code>ActionListener</code> interface
 */
	public void addActionListener(ActionListener listener) {
		actionListener = AWTEventMulticaster.add(actionListener, listener);
	}

/**
 * Removes an action listener from this list.
 *
 * @param listener The listener to remove
 */
	public void removeActionListener(ActionListener listener) {
		actionListener = AWTEventMulticaster.remove(actionListener, listener);
	}

/**
 * Fires the action listeners for this list.  This method is ordinarily called
 * automatically on a mouse click but can be triggered explicitly to simulate
 * a user action.
 */
	public void fireActionListeners() {
		ActionEvent event = new ActionEvent(this, ActionEvent.ACTION_PERFORMED, actionCommand);
		if (actionListener != null) {
			actionListener.actionPerformed(event);
		}
	}

/* Private constants */
	private static final int PREFERRED_WIDTH = 175;
	private static final int PREFERRED_HEIGHT = 90;

/* Instance variables */

	private JList list;
	private JScrollPane scrollPane;
	private DefaultListModel model;
	private ActionListener actionListener;
	private String actionCommand;

}

/**
 * This package-private class acts as a mouse listener for the FPScrollableList class.
 */

class FPScrollableListListener extends MouseAdapter {

/**
 * Creates a new listener for the list.
 */
	public FPScrollableListListener(FPScrollableList list) {
		target = list;
	}

/**
 * Responds to a mouse click by triggering action events in the target.
 */
	public void mouseClicked(MouseEvent e) {
		if (e.getClickCount() >= 2) {
			target.fireActionListeners();
		}
	}

/* Instance variables */

	private FPScrollableList target;

}
