/*
 * ScoreType.java
 * Author: Jeremiah Hanson
 * --------------------------------------------------------------
 * This enum lists all the possible ways of getting points
 */

package enums;

public enum ScoreType {

	SAMPLE_10(10);
	
	private int score;
	
	ScoreType(int num) {
		score = num;
	}
	
	public int getScore() {
		return score;
	}
}
