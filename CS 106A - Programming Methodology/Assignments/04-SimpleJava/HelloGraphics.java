/*
 * File: HelloGraphics.java
 * ------------------------
 * This program displays "hello, world" on the screen.
 * It is inspired by the first program in Brian
 * Kernighan and Dennis Ritchie's classic book,
 * The C Programming Language.
 */

import acm.graphics.*;
import acm.program.*;

public class HelloGraphics extends GraphicsProgram {
 	public void run() {
		add( new GLabel("hello, world", 100, 100) );
	}	
}

