package serverDataBase;

import enums.ScoreType;

/**
 * Vault.java<p>
 * This class extends score and is used to keep track
 * of the number of times a robot scored in vault
 * @author Jeremiah Hanson
 */
public class Vault extends Score{

	/**
	 * @serial 7697521239533767105L
	 */
	private static final long serialVersionUID = 7697521239533767105L;
	private static final int POINTS_PER_SCORE = 5;

	/**
	 * Vault<p>
	 * basic constructor
	 * @param num number of times scored
	 */
	public Vault(int num) {
		super(num);
		super.setScoreType(ScoreType.VAULT);
	}

	/**
	 * scorePoints<p>
	 * calculates the points gained form this score type
	 * @see serverDataBase.Score#scorePoints()
	 */
	@Override
	public void scorePoints() {
		this.addToPoints(POINTS_PER_SCORE * this.getTimesScored());
	}

	/**
	 * @see serverDataBase.Score#addScore(int)
	 */
	@Override
	public void addScore(int num) {
		addToTimesScored(num);
	}

}
