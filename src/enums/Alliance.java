/*
 * Alliance.java
 * Author: Jeremiah Hanson
 * --------------------------------------------------------
 * This class is an enum used to better identify alliances
 * in matches.
 */

package enums;

public enum Alliance {

	RED_ALLIANCE("Red Alliance"), BLUE_ALLIANCE("Blue Alliance");
	
	private String str;
	
	Alliance(String str) {
		this.str = str;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Enum#toString()
	 */
	public String toString() {
		return str;
	}
}
