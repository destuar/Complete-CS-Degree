/*
 * File: AdvMotionTableEntry.java
 * ------------------------------
 * This class keeps track of an entry in the motion table.
 */

/**
 * This class is used to store a single entry in the motion table.
 */

public class AdvMotionTableEntry {

/**
 * Creates a new motion table entry.
 *
 * @param dir The string specifying the direction of motion
 * @param room The number of the destination room
 * @param key The name of the key object, or <code>null</code> if none
 */
   public AdvMotionTableEntry(String dir, int room, String key) {
      direction = dir.toUpperCase();
      destinationRoom = room;
      keyName = (key == null) ? null : key.toUpperCase();
   }

/**
 * Returns the direction name from a motion table entry.
 *
 * @return The string specifying the direction of motion
 */
   public String getDirection() {
      return direction;
   }

/**
 * Returns the room number to which a particular direction leads.
 *
 * @return The number of the destination room
 */
   public int getDestinationRoom() {
      return destinationRoom;
   }

/**
 * Returns the name of the object required to travel along a locked
 * passage, or <code>null</code> if the passage is open.
 *
 * @return The name of the key object, or <code>null</code> for none
 */
   public String getKeyName() {
      return keyName;
   }

/* Private instance variables */
   private String direction;
   private int destinationRoom;
   private String keyName;
}
