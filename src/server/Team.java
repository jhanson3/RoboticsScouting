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
	private String teamName;
	
	/*
	 * Constructor
	 * Author: Jeremiah Hanson
	 * ----------------------------------------------
	 * Purpose: Constructor
	 * Parameters:
	 * 	num: an int that represents the teams number
	 * 	name: A String that holds the teams name
	 */
	public Team(int num, String name) {
		teamNum = num;
		teamName = name;
	}
	
	/*
	 * Constructor
	 * Author: Jeremiah Hanson
	 * ----------------------------------------------
	 * Purpose: Constructor
	 * Parameters:
	 * 	num: an int that represents the teams number
	 */
	public Team(int num) {
		teamNum = num;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public int getTeamNum() {
		return teamNum;
	}

}
