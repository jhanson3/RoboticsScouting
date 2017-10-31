/*
 * TeamSheet.java
 * Author: Jeremiah Hanson
 * ------------------------------------------------------------------------------------
 * This class is responsible for the list of teams and getting, setting, and adding 
 * teams to the list.
 */

package serverDataBase;

import java.io.Serializable;
import java.util.HashMap;

public class TeamSheet implements Serializable {

	private static final long serialVersionUID = -215213122891539175L;
	
	private HashMap<Integer, Team> teams;
	private TeamSheet teamSheet;
	
	/*
	 * Constructor
	 * Author: Jeremiah Hanson
	 * ------------------------------------------
	 * Purpose: Constructor
	 * Parameters: None
	 */
	private TeamSheet() {
		teamSheet = this;
		teams = new HashMap<Integer, Team>();
	}
	
	/*
	 * getInstanceOf
	 * Author: Jeremiah Hanson
	 * ---------------------------------------------
	 * Purpose: this is how to retrieve the only 
	 * 		instance of this class. If its the first
	 * 		call it creates an instance using the 
	 * 		constructor.
	 * Parameters:
	 * 	None
	 */
	public TeamSheet getInstanceOf() {
		
		if (teamSheet == null) {
			teamSheet = new TeamSheet();
		}
		
		return teamSheet;
	}
	
	/*
	 * addTeam
	 * Author: Jeremiah Hanson
	 * --------------------------------------------
	 * Purpose: creates a new team and adds it to the
	 * 		hashmap with its team number as a key
	 * Parameters:
	 * 	num: the team number
	 * 	hasName: boolean value tells if the name was \
	 * 		entered when creating
	 * 	name: the name of the team as a String
	 */
	public void addTeam(int num, boolean hasName, String name) {
		
		Team team;
		
		if (hasName) {
			team = new Team(num, name);
		} else {
			team = new Team(num);
		}
		
		teams.put(team.getTeamNum(), team);
	}
	
	/*
	 * getTeam
	 * Author: Jeremiah Hanson
	 * -----------------------------------------------
	 * Purpose: This gets a team by its number
	 * Parameters:
	 * 	num: an int representing the team number
	 */
	public Team getTeam(int num) {
		
		if (teams.containsKey(num)) {
			return teams.get(num);
		} else {
			return null;
		}
		
	}
	
	/*
	 * teamExists
	 * Author: Jeremiah Hanson
	 * ------------------------------------------------
	 * Purpose: returns true if team number exists
	 * Parameters:
	 * 	num: int of team number to check for
	 */
	public boolean teamExists(int num) {
		
		if (teams.containsKey(num)) {
			return true;
		}
		return false;
	}
	
}
