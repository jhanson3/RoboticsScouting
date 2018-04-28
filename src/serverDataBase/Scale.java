package serverDataBase;

import enums.ScoreType;

/**
 * Scale.java<p>
 * This class extends score and is used to keep 
 * track of scores in the scale
 * @author Jeremiah Hanson
 */
public class Scale extends Score{

	/**
	 * @serial 5314900583719294416L
	 */
	private static final long serialVersionUID = 5314900583719294416L;
	private int secondsControled;

	/**
	 * Scale<p>
	 * basic constructor
	 * @param num number of times scored
	 */
	public Scale(int num) {
		super(num);
		super.setScoreType(ScoreType.SCALE);
	}

	/**
	 * scorePoints<p>
	 * calculates the total points earned by this score
	 * method
	 * @author Jeremiah Hanson
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
	 * add to the timesScored in super
	 * @param num (int) the number to add to times scored
	 * @author Jeremiah Hanson
	 */
	@Override
	public void addScore(int num) {
		addToTimesScored(num);
	}

}
