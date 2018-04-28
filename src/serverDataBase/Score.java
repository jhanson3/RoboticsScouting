package serverDataBase;

import java.io.Serializable;

import enums.ScoreType;

/**
 * Score.java<p>
 * This is a generic super class for scoring points for a team
 * during a match.
 * @author Jeremiah Hanson
 */
public abstract class Score implements Serializable{

	private static final long serialVersionUID = -6924965503272209646L;
	private int points, timesScored;
	private ScoreType type;
	
	/**
	 * basic constructor
	 * @param num This is an int for the number of
	 * 		times a team scored this type of score
	 */
	public Score(int num) {
		
		timesScored = num;
		points = 0;
		
	}
	
	/**
	 * scorePoints
	 * calculatets the points gained by this score
	 */
	public abstract void scorePoints();
	
	/**
	 * addToPoints<p>
	 * add the given number of points to the points variable
	 * @param num
	 */
	protected void addToPoints(int num) {
		points += num;
	}
	
	/**
	 * addToTimesScored<p>
	 * adds to the number of times Scored
	 * @param num
	 */
	protected void addToTimesScored(int num) {
		timesScored += num;
	}
	
	/**
	 * gets the ScoreType
	 * @return (ScoreType) the type of this score
	 */
	public ScoreType getScoreType() {
		return type;
	}
	
	public void setScoreType(ScoreType type) {
		this.type = type;
	}
	
	/**
	 * resets the score and recalculates, then returns the new points
	 * @return (int) total points scored by this score type
	 */
	public int resetAndGetScore() {
		points = 0;
		this.scorePoints();
		return points;
	}
	
	/**
	 * adds to the times scored
	 * @param num int for number of times to add
	 * @author Jeremiah Hanson
	 */
	public abstract void addScore(int num);
	
	/**
	 * gets the number of points scored 
	 * 		this way.
	 * @return (int) number of points scored by this score type
	 */
	public int getPoints() {
		return points;
	}
	
	/**
	 * gets the number of times a team scored 
	 * 		in this way
	 * @return (int) number of times scored this way
	 */
	public int getTimesScored() {
		return timesScored;
	}
	
}
