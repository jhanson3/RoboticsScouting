package serverDataBase;

/**
 * OpSwitch.java<p>
 * This class extends score and is used to keep track of
 * scores in an opponents switch
 * @author Jeremiah Hanson
 */
public class OpSwitch extends Score{

	/**
	 * @serial -3996761719813465893L
	 */
	private static final long serialVersionUID = -3996761719813465893L;

	public OpSwitch(int num) {
		super(num);
	}

	/**
	 * scorePoints<p>
	 * does nothing for this type of score
	 */
	@Override
	public void scorePoints() {
		// Cannot gain points from opponents switch
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
