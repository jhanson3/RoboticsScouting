/*
 * Team.java
 * Author: Jeremiah Hanson
 * ------------------------------------------------------------------------------------
 * This class represents a single team. It is responsible for all of the data stored
 * about that team.
 */

package serverDataBase;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import enums.ScoreType;

public class Team implements Serializable {

	private static final long serialVersionUID = -7657353333658149655L;
	
	private int teamNum;
	private String teamName;
	private ArrayList<String> notes;
	private ArrayList<Match> matches;
	private ArrayList<Integer> matchNum;
	private HashMap<Integer, MatchScore> scores;
	
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
		notes = new ArrayList<String>();
		matches = new ArrayList<Match>();
		matchNum = new ArrayList<Integer>();
		scores = new HashMap<Integer, MatchScore>();
		
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

	/*
	 * getTeamName
	 * Author: Jeremiah Hanson
	 * ----------------------------------------------
	 * Purpose: Returns the teamName String
	 * Parameters:
	 * 	None
	 */
	public String getTeamName() {
		return teamName;
	}

	/*
	 * setTeamName
	 * Author: Jeremiah Hanson
	 * ----------------------------------------------
	 * Purpose: used to assign or change the teamName 
	 * Parameters:
	 * 	teamName: String containing the new name
	 */
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	/*
	 * getTeamNum
	 * Author: Jeremiah Hanson
	 * ----------------------------------------------
	 * Purpose: returns the int teamNum 
	 * Parameters:
	 *	None
	 */
	public int getTeamNum() {
		return teamNum;
	}
	
	/*
	 * addNote
	 * Author: Jeremiah Hanson
	 * ----------------------------------------------
	 * Purpose: adds a note to the notes arraylist
	 * Parameters:
	 * 	note: a string containing a note
	 */
	public void addNote(String note) {
		notes.add(note);
	}
	
	/*
	 * getNote
	 * Author: Jeremiah Hanson
	 * ----------------------------------------------
	 * Purpose: used to get a note at an index 
	 * Parameters:
	 * 	index: int containing an index
	 * Returns a note String or null if index not found
	 */
	public String getNote(int index) {
		if (index >= notes.size() || index < 0) 
			return null;
		else
			return notes.get(index);
	}
	
	/*
	 * getNotesSize
	 * Author: Jeremiah Hanson
	 * ----------------------------------------------
	 * Purpose: gets the size of notes arrayList 
	 * Parameters:
	 * 	None
	 */
	public int getNotesSize() {
		return notes.size();
	}
	
	/*
	 * deleteNoteAt
	 * Author: Jeremiah Hanson
	 * ----------------------------------------------
	 * Purpose: delete a note from the notes arrayList 
	 * Parameters:
	 * 	index: index of the note to be deleted
	 */
	public void deleteNoteAt(int index) {
		notes.remove(index);
	}
	
	/*
	 * addMatch
	 * Author: Jeremiah Hanson
	 * -----------------------------------------
	 * Purpose: add a match to the matches arrayList
	 * Parameters:
	 * 	match: the Match to add
	 */
	public void addMatch(Match match) {
		matches.add(match);
	}
	
	/*
	 * getMatchScores
	 * -----------------------------------------
	 * Purpose: gets the whole hasmap of match scores
	 */
	public HashMap<Integer, MatchScore> getMatchscores() {
		return scores;
		
	}
	
	/**
	 * addScore<p>
	 * Adds a score to this teams score table<p>
	 * @param match (int) the match number to add the score to
	 * @param score (ScoreType) the type of score to add
	 */
	public void addScore(int match, ScoreType score) {
		
		if (!matchNum.contains(match)) {
			matchNum.add(match);
			scores.put(match, new MatchScore());
		}
		
		if (score == ScoreType.OP_SWITCH) {
			scores.get(match).addScore(new OpSwitch(1));;
		} else if (score == ScoreType.SWITCH) {
			scores.get(match).addScore(new Switch(1));;
		} else if (score == ScoreType.SCALE) {
			scores.get(match).addScore(new Scale(1));;
		} else if (score == ScoreType.VAULT) {
			scores.get(match).addScore(new Vault(1));;
		}
		
	}
	
	/**
	 * prints all the matches the team was in with there
	 * score for the corresponding match
	 */
	public void printMatches() {
		System.out.println("Team " + teamNum + " has played " + matchNum.size() + " matches.");
		
		for (int i = 0; i < matchNum.size(); i++) {
			System.out.println("   Match #" + matchNum.get(i) + ":");
			scores.get(matchNum.get(i)).printMatch();
		}
	}

}
