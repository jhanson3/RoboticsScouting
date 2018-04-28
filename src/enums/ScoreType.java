/*
 * ScoreType.java
 * Author: Jeremiah Hanson
 * --------------------------------------------------------------
 * This enum lists all the possible ways of getting points
 */

package enums;

public enum ScoreType {

	SAMPLE_10(10, "sample 10"), SWITCH(0, "switch"), SCALE(0, "scale"), OP_SWITCH(0, "opponent switch"), VAULT(5, "vault");
	
	private int score;
	private String name;
	
	ScoreType(int num, String name) {
		score = num;
		this.name = name;
	}
	
	public int getScore() {
		return score;
	}
	
	public String getName() {
		return name;
	}
}
