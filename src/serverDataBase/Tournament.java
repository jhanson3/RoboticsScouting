/*
 * Tournament.java
 * Author: Jeremiah Hanson
 * -----------------------------------------------------------------------
 * This Class stores a MatchList and a TeamSheet for a specific tournament.
 * This class is a singleton
 */
package serverDataBase;

import java.io.Serializable;
import java.util.ArrayList;

import enums.Alliance;

public class Tournament implements Serializable{

	private static final long serialVersionUID = -7962296448262915652L;
	
	private MatchList matchList;
	private TeamSheet teamSheet;
	private static Tournament tournament;
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
		matchList = MatchList.getInstanceOf();
		teamSheet = TeamSheet.getInstanceOf();
	}
	
	/*
	 * getInstanceOf
	 * Author: Jeremiah Hanson
	 * ------------------------------------
	 * Purpose: gets the instance of tournament
	 * 		or creates it if null then sends
	 */
	public static Tournament getInstanceOf() {
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
	 * getName
	 * Author: Jeremiah Hanson
	 * ----------------------------------------
	 * Purpose: Gets the name of the Tournament
	 */
	public String getName() {
		return name;
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
	
	/*
	 * addTeam
	 * Author: Jeremiah Hanson
	 * ------------------------------------------
	 * Purpose: Adds a team to TeamSheet
	 * 	num: the team number
	 * 	hasName: boolean value tells if the name was \
	 * 		entered when creating
	 * 	name: the name of the team as a String
	 */
	public void addTeam(int num, boolean hasName, String name) {
		teamSheet.addTeam(num, hasName, name);
	}
	
	/*
	 * getTeamSheet
	 * Author: Jeremiah Hanson
	 * -------------------------------------------
	 * Purpose: Gets teamSheet
	 */
	public TeamSheet getTeamSheet() {
		return teamSheet;
	}
	
	/*
	 * addTeamToMatch
	 * Author: Jeremiah Hanson
	 * --------------------------------------------
	 * Purpose: Add a team to a match
	 * Parameters:
	 * 	teamNum: team to add (int)
	 * 	allNum: number on the alliance (int)
	 * 	matchNum: the match number (int)
	 * 	alliance: Alliance to add to (Alliance)
	 */
	public void addTeamToMatch(int teamNum, int allNum, int matchNum, Alliance alliance) {
		
		if (teamSheet.teamExists(teamNum)) {
			MatchList.addTeamToMatch(teamSheet.getTeam(teamNum), allNum, matchNum, alliance);
		}
	}
	
	/*
	 * getMatchList
	 * Author: Jeremiah Hanson
	 * ------------------------------------
	 * Purpose: gets the Matchlist
	 */
	public MatchList getMatchList() {
		return matchList;
	}
	
	public int getMatchCount() {
		return matchList.getMatchCount();
	}
	
	public ArrayList<Integer> listOfTeams(int matchNum){
		return matchList.listOfTeams(matchNum);
	}
}
