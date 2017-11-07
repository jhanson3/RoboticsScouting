/*
 * MatchScore.java
 * Author: Jeremiah Hanson
 * -----------------------------------------------------------------
 * This keeps track of the match score for a team
 */

package serverDataBase;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import enums.ScoreType;

public class MatchScore implements Serializable{

	private static final long serialVersionUID = 2243015341974941625L;
	private HashMap<ScoreType, Score> scores;
	private int totalPoints;
	
	/*
	 * Constructor
	 * Author: Jeremiah Hanson
	 * -------------------------------------------
	 * Purpose: constructor
	 */
	public MatchScore() {
		
		scores = new HashMap<ScoreType, Score>();
		totalPoints = 0;
		
	}
	
	/*
	 * addScore
	 * Author: Jeremiah Hanson
	 * ---------------------------------------------
	 * Purpose: Adds a score to the scores HashMap
	 * Parameters:
	 * 	score: the Score to add
	 */
	public void addScore(Score score) {
		
		if (scores.containsKey(score.getScoreType())) {
			scores.get(score.getScoreType()).addScore(score.getTimesScored());;
		} else {
			scores.put(score.getScoreType(), score);
		}
		
		
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
	 * pointsByScore
	 * Author: Jeremiah Hanson
	 * ---------------------------------------------
	 * Purpose: This gets the number of points scored
	 * 		by a given ScoreType
	 * Parameters: 
	 * 	type: the ScoreType of the scores to add up
	 */
	public int pointsByScore(int num) {
		
		//TODO: update method
		return -1;
	}
	
	

}
