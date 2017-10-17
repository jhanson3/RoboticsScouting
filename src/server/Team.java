/*
 * Team.java
 * Author: Jeremiah Hanson
 * ------------------------------------------------------------------------------------
 * This class represents a single team. It is responsible for all of the data stored
 * about that team.
 */

package server;

import java.io.Serializable;

public class Team implements Serializable {

	private static final long serialVersionUID = -7657353333658149655L;
	
	private int teamNum;
	
	/*
	 * Constructor
	 * Author: Jeremiah Hanson
	 * ----------------------------------------------
	 * Purpose: Constructor
	 * Parameters:
	 * 	Num: an int that represents the teams number
	 */
	public Team(int num) {
		teamNum = num;
	}

}
