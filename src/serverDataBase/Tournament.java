/*
 * Tournament.java
 * Author: Jeremiah Hanson
 * -----------------------------------------------------------------------
 * This Class stores a MatchList and a TeamSheet for a specific tournament.
 * This class is a singleton
 */
package serverDataBase;

import java.io.Serializable;

public class Tournament implements Serializable{

	private static final long serialVersionUID = -7962296448262915652L;
	
	private MatchList matchList;
	private TeamSheet teamSheet;
	private Tournament tournament;
	private String name;
	
	/*
	 * Constructor
	 * Author: Jeremiah Hanson
	 * -----------------------------------
	 * Purpose: Constructor
	 */
	private Tournament() {
		
		tournament = this;
		name = "New Tournament";
		matchList = matchList.getInstanceOf();
		teamSheet = teamSheet.getInstanceOf();
	}
	
	/*
	 * getInstanceOf
	 * Author: Jeremiah Hanson
	 * ------------------------------------
	 * Purpose: gets the instance of tournament
	 * 		or creates it if null then sends
	 */
	public Tournament getInstanceOf() {
		if (tournament == null) {
			tournament = new Tournament();
		}
		return tournament;
	}
	
	/*
	 * setName
	 * Author: Jeremiah Hanson
	 * --------------------------------------
	 * Purpose: Sets the name of the Tournament
	 * Parameter:
	 * 	name: The String name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/*
	 * generateMatchList
	 * Author: Jeremiah Hanson
	 * -------------------------------------
	 * Purpose: generates a MatchList with
	 * 		a given number of matches. Does 
	 * 		nothing if MatchList is not empty
	 * Parameters:
	 * 	num: The number of matches to generate
	 * 		with
	 */
	public void generateMatchList(int num) {
		
		// Do not generate a matchlist if one exists
		if (!matchList.isEmpty()) return;
		
		matchList.generateMatchList(num);
		
	}
	
	/*
	 * addMatch
	 * Author: Jeremiah Hanson
	 * ------------------------------------------
	 * Purpose: Adds a match to matchlist
	 */
	public void addMatch() {
		matchList.addMatch();
	}

}
