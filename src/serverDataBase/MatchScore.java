/*
 * MatchScore.java
 * Author: Jeremiah Hanson
 * -----------------------------------------------------------------
 * This keeps track of the match score and who scored the points
 */

package serverDataBase;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class MatchScore implements Serializable{

	private static final long serialVersionUID = 2243015341974941625L;
	private HashMap<Integer, ArrayList<Score>> scores;
	private int totalPoints, team1, team2, team3;
	
	/*
	 * Constructor
	 * Author: Jeremiah Hanson
	 * -------------------------------------------
	 * Purpose: constructor
	 * Parameters: 
	 * 	team1: number for team one
	 * 	team2: number for team 2
	 * 	team3: number for team 3
	 */
	public MatchScore(int num1, int num2, int num3) {
		
		scores = new HashMap<Integer, ArrayList<Score>>();
		totalPoints = 0;
		team1 = num1;
		team2 = num2;
		team3 = num3;
		setupHashMap();
		
	}
	
	/*
	 * setupHashMap
	 * Author: Jeremiah Hanson
	 * ----------------------------------------------
	 * Purpose: sets up the hashmap
	 */
	private void setupHashMap() {
		
		scores.put(team1, new ArrayList<Score>());
		scores.put(team2, new ArrayList<Score>());
		scores.put(team3, new ArrayList<Score>());
	}
	
	/*
	 * addScore
	 * Author: Jeremiah Hanson
	 * ---------------------------------------------
	 * Purpose: Adds a score to the scores HashMap
	 * Parameters:
	 * 	num: the team number to use as the key
	 * 	score: the Score to add
	 */
	public void addScore(int num, Score score) {
		
		scores.get(num).add(score);
		
		totalPoints += score.getPoints();
	}
	
	/*
	 * getTotalPoints
	 * Author: Jeremiah Hanson
	 * ---------------------------------------------
	 * Purpose: Gives the total number of points scored 
	 * 		by an alliance
	 */
	public int getTotalPoints() {
		
		return totalPoints;
	}
	
	/*
	 * pointsByTeam
	 * Author: Jeremiah Hanson
	 * ---------------------------------------------
	 * Purpose: This gets the number of points scored
	 * 		by a single team.
	 * Parameters: 
	 * 	num: The team number to get the points of
	 */
	public int pointsByTeam(int num) {
		
		int points = 0;
		ArrayList<Score> temp = scores.get(num);
		for (int i=0; i<temp.size(); i++) {
			points += temp.get(i).getPoints();
		}
		
		return points;
	}
	
	

}
