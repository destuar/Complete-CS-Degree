/* FILE: Problem1Part2.java
 * ----------------------
 * This program contains and tests a method that returns
 * a list of all planets that can be visited until the
 * ship runs out of food.
 */

import java.util.*;
import acm.program.*;

public class Problem1Part2 extends ConsoleProgram {
	
	// For testing
	public void run() {
		HashMap<String, Integer> crewMap = createMap("Elon 0 Rishi 10 Nick 2 Dash 1 Nolan 5 Guy 3");
		HashMap<String, Integer> planetDistances = createMap("Supernova 1 Tatooine 2 Lusitania 4 Zebes 1 Alderaan 110");
		println(visitablePlanets(crewMap, planetDistances, 50));	
	}
	
	/*
	 * For testing - this method is a utility method that takes a string of the format 
	 * "KEY VALUE KEY VALUE" and returns a map with those key/value pairs.
	 */
	private HashMap<String, Integer> createMap(String mapString) {
		HashMap<String, Integer> map = new HashMap<>();
		
		Scanner s = new Scanner(mapString);
		while (s.hasNext()) {
			String key = s.next();
			String value = s.next();
			map.put(key, Integer.parseInt(value));
		}
		s.close();
		
		return map;
	}
	
	// Required to write this function
	private String visitablePlanets(HashMap<String, Integer> crewMemberMap, 
			HashMap<String, Integer> planetsToVisit, int startingFood) {
		
		Spaceship myShip = new Spaceship(startingFood);
		
		// Board all crew members and specify their daily food consumption
		for(String person: crewMemberMap.keySet()){
			myShip.board(person, crewMemberMap.get(person));
		}
		
		// Visit each planet until we run out of food
		for(String planet : planetsToVisit.keySet()){
			boolean success = myShip.flyTo(planet, planetsToVisit.get(planet));
			if (!success) {
				break;
			}
		}
		
		// Return the list of planets we had enough food to visit
		return myShip.getPlanetsVisited();
	}
}