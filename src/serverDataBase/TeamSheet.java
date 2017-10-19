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
	
	HashMap<Integer, Team> teams;
	
	/*
	 * Constructor
	 * Author: Jeremiah Hanson
	 * ------------------------------------------
	 * Purpose: Constructor
	 * Parameters: None
	 */
	private TeamSheet() {
		teams = new HashMap<Integer, Team>();
	}
	
}
