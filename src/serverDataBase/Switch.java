package serverDataBase;

import enums.ScoreType;

/**
 * Switch.java<p>
 * This class extends score and is used to keep track of
 * scores in a teams own switch
 * @author Jeremiah Hanson
 */
public class Switch extends Score{

	/**
	 * @serial 3245587384950447308L
	 */
	private static final long serialVersionUID = 3245587384950447308L;
	private int secondsControled;
	
	/**
	 * Switch<p>
	 * basic constructor
	 * @param num the number of times scored
	 */
	public Switch(int num) {
		super(num);
		secondsControled = 0;
		super.setScoreType(ScoreType.SWITCH);
	}

	/**
	 * scorePoints<p>
	 * add one cube score
	 */
	@Override
	public void scorePoints() {
		this.addToPoints(secondsControled);
	}
	
	/**
	 * setTimeControled<p>
	 * sets the total amount of time a team controlled a switch
	 * @param sec the time in seconds
	 */
	public void setTimeControled(int sec) {
		secondsControled += sec;
	}

	/**
	 * addScore<p>
	 * adds a number of scores to the timesScored
	 * @param num the number of times scored
	 * @see serverDataBase.Score#addScore(int)
	 */
	@Override
	public void addScore(int num) {
		addToTimesScored(num);
	}

}
