/* FILE: Problem2Part1.java
 * ----------------
 * This program contains the trace method for problem 2, Part 1.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;
import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Problem2Part1 extends ConsoleProgram {
	
	// For testing only
	public void run(){
		String[] mapStrings = {
				"cow moo pig oink dog bark alien boop",
				"dog daisy woof daisy karel robot space robot",
				"cat meow sheep ba lamb ba kitten meow"
		};
		
		String[] listStrings = {
				"moo woof meow boop",
				"daisy robot explorer",
				"meow"
		};
		
		for (int i = 0; i < mapStrings.length; i++) {
			HashMap<String, String> map = createMap(mapStrings[i]);
			ArrayList<String> list = createList(listStrings[i]);
			print((char)('a' + i) + ") ");
			collectionMystery(map, list);
		}
	}
	
	/*
	 * For testing: this method is a utility method that takes a string of the format 
	 * "KEY VALUE KEY VALUE" and returns a map with those key/value pairs.
	 */
	private HashMap<String, String> createMap(String mapString) {
		HashMap<String, String> map = new LinkedHashMap<>();
		
		Scanner s = new Scanner(mapString);
		while (s.hasNext()) {
			String key = s.next();
			String value = s.next();
			map.put(key, value);
		}
		s.close();
		
		return map;
	}
	
	// For testing: this method converts a list of strings to an ArrayList
	private ArrayList<String> createList(String mapString) {
		ArrayList<String> list = new ArrayList<>();
		
		Scanner s = new Scanner(mapString);
		while (s.hasNext()) {
			String key = s.next();
			list.add(key);
		}
		s.close();
		
		return list;
	}
	
	// Trace method
	private void collectionMystery(HashMap<String, String> map, ArrayList<String> list) {
		HashMap<String, String> map2 = new HashMap<>();
		for (String key : map.keySet()){
			boolean b = false; 
			for (String str : list){
				if (map.get(key).equals(str)){
					b = true;
				}
			}
			if (b) {
				map2.put(map.get(key), key);
			}
		}
		println(map2);
	}
}