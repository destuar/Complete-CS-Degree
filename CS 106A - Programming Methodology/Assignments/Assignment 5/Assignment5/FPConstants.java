/*
 * File: FPConstants.java
 * ----------------------
 * This file declares several constants that are shared by the
 * different modules in the FacePamphlet application.  Any class
 * that implements this interface can use these constants.
 */

import stanford.facepamphlet.*;

/**
 * This interface declares various constants that are used in
 * the FacePamphlet application.  To use the constants in this
 * interface, all you need to do is add <code>FPConstants</code>
 * to the <code>implements</code> clause for your class.
 */
public interface FPConstants {

/**
 * The width of the application window.
 */
	public static final int APPLICATION_WIDTH = 1000;

/**
 * The height of the application window.
 */
	public static final int APPLICATION_HEIGHT = 680;

/**
 *  Name of font used to display the application message at the
 *  bottom of the display canvas.
 */
	public static final String MESSAGE_FONT = "Dialog-18";

/**
 * Name of font used to display the name in a user's profile.
 */
	public static final String PROFILE_NAME_FONT = "Dialog-24";

/**
 * Name of font used to display the text "No Image" in user
 * profiles that do not contain an actual image.
 */
	public static final String PROFILE_IMAGE_FONT = "Dialog-24";

/**
 * Name of font used to display the status in a user's profile.
 */
	public static final String PROFILE_STATUS_FONT = "Dialog-bold-16";

/**
 * The maximum height (in pixels) that profile images should be displayed.
 * The maximum width is the width of the graphics window minus the margins. 
 */
	public static final double IMAGE_HEIGHT = 200;	

/**
 * The number of pixels in the horizontal margin between the 
 * left side of the canvas display area and the Name, Image, 
 * Status, and Message components that are displayed in the profile.
 */	
	public static final double LEFT_MARGIN = 20;	

/**
 * The number of pixels in the horizontal margin between the 
 * right side of the canvas display area and the Name, Image, and 
 * Status components that are displayed in the profile.
 */	
	public static final double RIGHT_MARGIN = LEFT_MARGIN;	

/**
 * The number of pixels in the vertical margin between the top 
 * of the canvas display area and the top (NOT the baseline) of 
 * the Name component that is displayed in the profile.
 */	
	public static final double TOP_MARGIN = 20;	

/**
 * The number of pixels in the vertical margin between the 
 * baseline of the Name component and the top of the Image 
 * displayed in the profile.
 */	
	public static final double NAME_IMAGE_SEP = 20;

/**
 * The number of vertical pixels in the vertical margin between 
 * the bottom of the Image and the top of the Status component 
 * in the profile.
 */		
	public static final double IMAGE_STATUS_SEP = 20;

/**
 * The number of pixels in the vertical margin between the bottom 
 * of the canvas display area and the baseline of the Message
 * display in the profile.
 */	
	public static final double BOTTOM_MARGIN = 20;	

/**
 * The standardized constant for the key that represents the
 * full name of a user.  The name field is public and can be read
 * even by callers who are not friends with the owner.
 */
	public static final String NAME_KEY = FPServer.NAME_KEY;

/**
 * The standardized constant for the key that represents the user's
 * password.  The password field is private, which means that it
 * can be read and written only by the user who owns that id.
 */
	public static final String PASSWORD_KEY = FPServer.PASSWORD_KEY;

/**
 * The standardized constant for the key that represents the user's
 * image.  The image field is protected, which means that it
 * can be read only by friends of the owner.
 */
	public static final String IMAGE_KEY = FPServer.IMAGE_KEY;

/**
 * The standardized constant for the key that represents the user's
 * status.  The status field is protected, which means that it
 * can be read only by friends of the owner.
 */
	public static final String STATUS_KEY = FPServer.STATUS_KEY;

/**
 * The standardized constant for the key that represents the user's
 * wall.  The text of the wall field is treated specially by the
 * server: only friends can read the text, but any user can append
 * a message to it using the <code>addMessageToWall</code> method in
 * the <code>FPRepository</code> class.
 */
	public static final String WALL_KEY = FPServer.WALL_KEY;

/**
 * The standardized constant for the key that represents the user's
 * interests.  The text of the interests field is public, which
 * makes it possible to find people by looking for matching
 * interests.
 */
	public static final String INTERESTS_KEY = FPServer.INTERESTS_KEY;

}
