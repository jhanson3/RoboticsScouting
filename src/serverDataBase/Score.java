/*
 * Score.java
 * Author: Jeremiah Hanson
 * ------------------------------------------------------------
 * This is a generic super class for scoring points for a team
 * during a match.
 */

package serverDataBase;

import java.io.Serializable;

import enums.ScoreType;

public abstract class Score implements Serializable{

	private static final long serialVersionUID = -6924965503272209646L;
	private int points, timesScored;
	private ScoreType type;
	
	/*
	 * Constructor
	 * Author: Jeremiah Hanson
	 * -------------------------------------------
	 * Purpose: constructor
	 * Parameters:
	 * 	num: This is an int for the number of
	 * 		times a team scored this type of score
	 */
	public Score(int num) {
		
		timesScored = num;
		points = 0;
		
	}
	
	/*
	 * scorePoints
	 * Author: Jeremiah Hanson
	 * --------------------------------------------
	 * Purpose: abstract method to score points based
	 * 		on the subclass
	 */
	public abstract void scorePoints();
	
	/*
	 * getScoreType
	 * Author: Jeremiah Hanson
	 * --------------------------------------------
	 * Purpose: gets the ScoreType
	 */
	public ScoreType getScoreType() {
		return type;
	}
	
	/*
	 * addScore
	 * Author: Jeremiah Hanson
	 * --------------------------------------------
	 * Purpose: adds to the times scored
	 * Parameters:
	 * 	num: int for number of times to add
	 */
	public abstract void addScore(int num);
	
	/*
	 * getPoints
	 * Author: Jeremiah Hanson
	 * ---------------------------------------------
	 * Purpose: gets the number of points scored 
	 * 		this way.
	 */
	public int getPoints() {
		return points;
	}
	
	/*
	 * getTimesScored
	 * Author: Jeremiah Hanson
	 * -------------------------------------------------
	 * Purpose: gets the number of times a team scored 
	 * 		in this way
	 */
	public int getTimesScored() {
		return timesScored;
	}
	
}
