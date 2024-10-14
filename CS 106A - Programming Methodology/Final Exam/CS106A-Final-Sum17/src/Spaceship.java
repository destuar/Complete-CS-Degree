/* FILE: Spaceship.java
 * --------------------
 * This class models a spaceship, which keeps track of
 * the planets it has visited, how much food is stored
 * on-board, and a collection of all the passengers on
 * board and how much food they consume each day.
 * 
 * You create a new spaceship by specifying the initial
 * food on board.  Then, you can add or remove passengers.
 * You can also fly to planets; you provide the planet
 * and number of days required to get there.  If the
 * spaceship doesn't have enough food, it will return false.
 * Otherwise, it will fly there, lose food, and return true.
 */

import java.util.*;

public class Spaceship {
	
	// The number of pounds of food on board
	private int foodOnBoard;
	
	// A map from crew member names to the pounds of food they eat per day
	private HashMap<String, Integer> crewMemberMap;
	
	// A list of visited planet names, in order of visit
	private ArrayList<String> planetsVisited;
	
	// Create a spaceship with an initial amount of food
	public Spaceship(int initialFood) {
		foodOnBoard = initialFood;
		crewMemberMap = new HashMap<>();
		planetsVisited = new ArrayList<>();
	}
	
	/* Boards a crew member with the given food intake.  This
	 * crew member will now consume food during trips.
	 */
	public void board(String crewMemberName, int foodPerDay) {
		crewMemberMap.put(crewMemberName, foodPerDay);
	}
	
	/* Unboards a crew member with the given name from the ship.  This
	 * crew member is no longer on the ship and no longer consumes food.
	 */
	public void unboard(String crewMemberName) {
		crewMemberMap.remove(crewMemberName);
	}
	
	/* Returns a String of visited planets, in order of visit.  The string
	 * should be formatted like "[Earth, Mars, Venus]" 
	 */
	public String getPlanetsVisited() {
		return planetsVisited.toString();
	}
	
	/* Attempts to fly to a planet, which takes the given number of days.
	 * Returns true if we had enough food, and false otherwise.
	 */
	public boolean flyTo(String planetName, int daysRequired) {
		// See if we have enough food for this trip
		int foodRemaining = foodOnBoard;
		for(String person : crewMemberMap.keySet()){
			foodRemaining -= crewMemberMap.get(person)*daysRequired;
		}
		
		if(foodRemaining < 0) {
			return false;
		}
		planetsVisited.add(planetName);
		foodOnBoard = foodRemaining;
		return true;
	}	
}