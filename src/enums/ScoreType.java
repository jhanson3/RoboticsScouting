/*
 * ScoreType.java
 * Author: Jeremiah Hanson
 * --------------------------------------------------------------
 * This enum lists all the possible ways of getting points
 */

package enums;

public enum ScoreType {

	SAMPLE_10(10), SWITCH(0), SCALE(0), OP_SWITCH(0), VAULT(5);
	
	private int score;
	
	ScoreType(int num) {
		score = num;
	}
	
	public int getScore() {
		return score;
	}
}
