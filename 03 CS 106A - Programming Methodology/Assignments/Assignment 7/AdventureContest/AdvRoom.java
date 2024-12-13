/*
 * File: AdvRoom.java
 * ------------------
 * This file defines a class that models a single room in the
 * Adventure game.
 */

import acm.util.*;
import java.io.*;
import java.util.*;

/**
 * This class defines a single room in the Adventure game.  A room
 * is characterized by the following properties:
 *
 * <ul>
 * <li>A room number, which must be greater than zero
 * <li>Its name, which is a one-line string identifying the room
 * <li>Its description, which is a line array describing the room
 * <li>A list of objects contained in the room
 * <li>A flag indicating whether the room has been visited
 * <li>A motion table specifying the exits and where they lead
 * </ul>
 *
 * The external format of the room file is described in the
 * assignment handout.
 */

public class AdvRoom extends AdvRoomMagicSuperclass {

/**
 * Returns the room number.
 *
 * @return The room number
 */
	public int getRoomNumber() {
		return super.getRoomNumber(); // Replace with your code
	}

/**
 * Returns the room name, which is its one-line description.
 *
 * @return The room name
 */
	public String getName() {
		return super.getName(); // Replace with your code
	}


/**
 * Adds an object to the list of objects in the room.
 *
 * @param obj The <code>AdvObject</code> to be added
 */
	public void addObject(AdvObject obj) {
		super.addObject(obj); // Replace with your code
	}

/**
 * Removes an object from the list of objects in the room.
 *
 * @param obj The <code>AdvObject</code> to be removed
 */
	public void removeObject(AdvObject obj) {
		super.removeObject(obj); // Replace with your code
	}

/**
 * Checks whether the specified object is in the room.
 *
 * @param obj The <code>AdvObject</code> being tested
 * @return <code>true</code> if the object is in the room
 */
	public boolean containsObject(AdvObject obj) {
		return super.containsObject(obj); // Replace with your code
	}

/**
 * Returns the number of objects in the room.
 *
 * @return The number of objects in the room
 */
	public int getObjectCount() {
		return super.getObjectCount(); // Replace with your code
	}

/**
 * Returns the specified element from the list of objects in the room.
 *
 * @return The <code>AdvObject</code> at the specified index position
 */
	public AdvObject getObject(int index) {
		return super.getObject(index); // Replace with your code
	}

/**
 * Returns a string array giving the long description of the room.
 *
 * @return A string array giving the long description of the room
 */
	public String[] getDescription() {
		return super.getDescription(); // Replace with your code
	}

/**
 * Sets a flag indicating whether this room has been visited.
 * Calling <code>setVisited(true)</code> means that the room has
 * been visited; calling <code>setVisited(false)</code> restores
 * its initial unvisited state.
 *
 * @param flag The new state of the "visited" flag
 */
	public void setVisited(boolean flag) {
		super.setVisited(flag); // Replace with your code
	}

/**
 * Returns <code>true</code> if the room has previously been visited.
 *
 * @return <code>true</code> if the room has been visited
 */
	public boolean hasBeenVisited() {
		return super.hasBeenVisited(); // Replace with your code
	}

/**
 * Returns the motion table associated with this room, which is an
 * array of directions, room numbers, and key objects stored
 * in an <code>AdvMotionTableEntry</code>.
 *
 * @return The array of motion table entries associated with this room
 */
	public AdvMotionTableEntry[] getMotionTable() {
		return super.getMotionTable(); // Replace with your code
	}

/**
 * Creates a new room by reading its data from the specified
 * reader.  If no data is left in the reader, this method returns
 * <code>null</code> instead of an <code>AdvRoom</code> value.
 * Note that this is a static method, which means that you need
 * to call
 *
 *<pre><code>
 *     AdvRoom.readRoom(rd)
 *</code></pre>
 *
 * @param rd The reader from which the room data is read 
 */
	public static AdvRoom readRoom(BufferedReader rd) {
		return AdvRoomMagicSuperclass.readRoom(rd); // Replace
	}

/* Private instance variables */
	// Add your own instance variables here

}
