package serverDataBase;

import java.io.Serializable;
import java.util.HashMap;

import enums.ScoreType;

/**
 * MatchScore.java
 * This keeps track of the match score for a team
 * @author Jeremiah Hanson
 */
public class MatchScore implements Serializable{

	private static final long serialVersionUID = 2243015341974941625L;
	private HashMap<ScoreType, Score> scores;
	private int totalPoints;
	
	public MatchScore() {
		
		scores = new HashMap<ScoreType, Score>();
		totalPoints = 0;
		
	}
	
	/**
	 * Adds a score to the scores HashMap
	 * 	@param score the Score to add
	 */
	public void addScore(Score score) {
		
		if (scores.containsKey(score.getScoreType())) {
			scores.get(score.getScoreType()).addScore(score.getTimesScored());;
		} else {
			scores.put(score.getScoreType(), score);
		}
		
		
		totalPoints += score.getPoints();
	}
	
	/**
	 * Gives the total number of points scored 
	 * 		by an alliance
	 * @return the total number of points scored by an alliance
	 */
	public int getTotalPoints() {
		
		return totalPoints;
	}
	
	/**
	 * This gets the number of points scored
	 * 		by a given ScoreType
	 * @param type the ScoreType of the scores to add up
	 * @author Jeremiah Hanson
	 */
	public int pointsByScore(ScoreType type) {
		return scores.get(type).resetAndGetScore();
	}
	
	/**
	 * prints all the scores 
	 */
	public void printMatch() {
		if (scores.containsKey(ScoreType.SWITCH)) {
			System.out.println("      Switch: " + scores.get(ScoreType.SWITCH).getTimesScored());
		}
		if (scores.containsKey(ScoreType.OP_SWITCH)) {
			System.out.println("      Opponent's Switch: " + scores.get(ScoreType.OP_SWITCH).getTimesScored());
		}
		if (scores.containsKey(ScoreType.SCALE)) {
			System.out.println("      Scale: " + scores.get(ScoreType.SCALE).getTimesScored());
		}
		if (scores.containsKey(ScoreType.VAULT)) {
			System.out.println("      Vault: " + scores.get(ScoreType.VAULT).getTimesScored());
		}
	}
	
	

}
