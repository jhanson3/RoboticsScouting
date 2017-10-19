/*
 * Match
 * Author: Jeremiah Hanson
 * ---------------------------------------------------------------------
 * This class is responsible for keeping track of an individual match.
 * This includes what teams are in which alliances and how they all scored.
 */

package serverDataBase;

import enums.Alliance;

public class Match {

	private int matchNum, redScore, blueScore, redCur, blueCur;
	private Team[] redAlliance, blueAlliance;
	
	/*
	 * Constructor
	 * Author: Jeremiah Hanson
	 * -------------------------------------
	 * Purpose: constructor
	 * Parameters:
	 * 	num: int representing the match number
	 */
	public Match(int num) {
		matchNum = num;
		redAlliance = new Team[3];
		blueAlliance = new Team[3];
		redScore = blueScore = redCur = blueCur = 0;
	}
	
	/*
	 * addTeam
	 * Author: Jeremiah Hanson
	 * ------------------------------------
	 * Purpose: add a team to one of the 
	 * alliances
	 * Parameters:
	 * 	team: An object of class Team to add
	 * 	num: An int representing the alliance
	 * 		number
	 * 	alliance: An Alliance enum to represent
	 * 		the alliance the team is on
	 */
	public int addTeam(Team team, int num, Alliance alliance) {
		
		// ensure number is within range first
		if (num < 0 || num >= 3) {
			// return code 1, not a valid alliance number
			return 1;
		} else if (alliance == Alliance.RED_ALLIANCE) {
			if (redAlliance[num] == null) {
				redAlliance[num] = team;
				redCur++;
				return 1; // No errors
			} else {
				// return code 2, team num already taken
				return 2;
			}
		} else if (alliance == Alliance.BLUE_ALLIANCE) {
			if (blueAlliance[num] == null) {
				blueAlliance[num] = team;
				blueCur++;
				return 1; // No errors
			} else {
				// return code 2, team num already taken
				return 2;
			}
		}
		
		return -1; // should not be reachable
	}
	
	/*
	 * removeTeam
	 * Author: Jeremiah Hanson
	 * ---------------------------------------
	 * Purpose: This removes a team from a 
	 * 		match
	 * Parameters:
	 * 	num: the Alliance number to remove (int).
	 * 	alliance: An Alliance to remove from
	 */
	public void removeTeam(int num, Alliance alliance) {
		
		if (num < 0 || num >= 3) {
			// return without doing anything
			return;
		} else if (alliance == Alliance.RED_ALLIANCE) {
			redAlliance[num] = null;
		} else if (alliance == Alliance.BLUE_ALLIANCE) {
			blueAlliance[num] = null;
		}
	}
	
	/*
	 * addScore
	 * Author: Jeremiah Hanson
	 * ------------------------------------------------
	 * Purpose: Give points based on number of points scored
	 * Parameters: 
	 * 	alliance: the Alliance that scored
	 * 	num: the number of points scored
	 */
	public void addScore(Alliance alliance, int score) {
		
		if (alliance == Alliance.RED_ALLIANCE) {
			redScore += score;
		} else if (alliance == Alliance.BLUE_ALLIANCE) {
			blueScore += score;
		}
	}
	
	/*
	 * getMatchNum
	 * Author: Jeremiah Hanson
	 * -------------------------------------------
	 * Purpose: gets the match number
	 */
	public int getMatchNum() {
		return matchNum;
	}
	
	/*
	 * getScore
	 * Author: Jeremiah Hanson
	 * --------------------------------------
	 * Purpose: gets an alliances score
	 * Parameters:
	 * 	alliance: the alliance to get score from
	 */
	public int getScore(Alliance alliance) {
		
		if (alliance == Alliance.RED_ALLIANCE) {
			return redScore;
		} else if (alliance == Alliance.BLUE_ALLIANCE) {
			return blueScore;
		}
		return -1; // not given a valid alliance
	}
	
	/*
	 * getNumTeams
	 * Author: Jeremiah Hanson
	 * ----------------------------------------
	 * Purpose: gets the number of robots of the 
	 * 		alliance asked for, or all robots
	 * Parameters: 
	 * 	alliance: the alliance to get number 
	 * 		of teams for. (null for both alliances)
	 */
	public int getNumTeams(Alliance alliance) {
		
		if (alliance == Alliance.RED_ALLIANCE) {
			return redCur;
		} else if (alliance == Alliance.BLUE_ALLIANCE) {
			return blueCur;
		} else {
			return redCur + blueCur;
		}
	}
}
