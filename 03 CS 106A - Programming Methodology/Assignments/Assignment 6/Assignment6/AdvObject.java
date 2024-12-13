/*
 * File: AdvObject.java
 * --------------------
 * This file defines a class that models an object in the
 * Adventure game.
 */

import acm.util.*;
import java.io.*;

/**
 * This class defines an object in the Adventure game.  An object is
 * characterized by the following properties:
 *
 * <ul>
 * <li>Its name, which is the noun used to refer to the object
 * <li>Its description, which is a string giving a short description
 * <li>The room number in which the object initially lives
 * </ul>
 *
 * The external format of the objects file is described in the
 * assignment handout.
 */

public class AdvObject extends AdvObjectMagicSuperclass {

/**
 * Returns the object name, which is the word used to refer to it.
 *
 * @return The name of the object
 */
   public String getName() {
      return super.getName(); // Replace with your code
   }

/**
 * Returns the one-line description of the object.  This description
 * should start with an article, as in "a set of keys" or "an emerald
 * the size of a plover's egg."
 *
 * @return The description of the object
 */
   public String getDescription() {
      return super.getDescription(); // Replace with your code
   }

/**
 * Returns the initial location of the object.
 *
 * @return The room number in which the object initially resides
 */
   public int getInitialLocation() {
      return super.getInitialLocation(); // Replace with your code
   }

/**
 * Creates a new object by reading its data from the specified
 * reader.  If no data is left in the reader, this method returns
 * <code>null</code> instead of an <code>AdvObject</code> value.
 * Note that this is a static method, which means that you need
 * to call
 *
 *<pre><code>
 *     AdvObject.readObject(rd)
 *</code></pre>
 *
 * @param rd The reader from which the object data is read 
 */
   public static AdvObject readObject(BufferedReader rd) {
      return AdvObjectMagicSuperclass.readObject(rd); // Replace
   }

/* Private instance variables */
   // Add your own instance variables here

}
