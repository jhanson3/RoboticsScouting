/*
 * MatchList
 * Author: Jeremiah Hanson
 * -----------------------------------------------------------------------
 * This class holds a list of all the matches in an FRC Regional or 
 * championship. It uses an ArrayList to store the Matches. It is a Singleton
 */
package serverDataBase;

import java.io.Serializable;
import java.util.ArrayList;

public class MatchList implements Serializable{

	private static final long serialVersionUID = -2479177965817464578L;
	
	private MatchList matchList;
	private ArrayList<Match> matches;
	
	/*
	 * Constructor
	 * Author: Jeremiah Hanson
	 * -------------------------------------------
	 * Purpose: Constructor
	 */
	private MatchList() {
		matchList = this;
		matches = new ArrayList<Match>();
	}
	
	/*
	 * getInstanceOf
	 * Author: Jeremiah Hanson
	 * --------------------------------------------
	 * Purpose: Gets the instance of MatchList, or 
	 * 		creates it if none exists.
	 */
	public MatchList getInstanceOf() {
		
		if (matchList == null) {
			matchList = new MatchList();
		}
		
		return matchList;
	}
	
	/*
	 * generateMatchList
	 * Author: Jeremiah Hanson
	 * ----------------------------------------------
	 * Purpose: Creates a given number of Matches and
	 * 		adds them to the ArrayList matches.
	 * Parameters:
	 * 	num: the number of matches to add
	 */
	public void generateMatchList(int num) {
		
		for (int i=0; i < num; i++) {
			Match temp = new Match(i);
			matches.add(temp);
		}
	}
	
	/*
	 * addMatch
	 * Author: Jeremiah Hanson
	 * -----------------------------------------------
	 * Purpose: Adds a single match to the end of the 
	 * 		MatchList.
	 */
	public void addMatch() {
		
		matches.add(new Match(matches.size()));
	}
	
	/*
	 * getMatch
	 * Author: Jeremiah Hanson
	 * ------------------------------------------------
	 * Purpose: gets a specific match number
	 * Parameters: 
	 * 	num: the match number to get
	 */
	public Match getMatch(int num) {
		return matches.get(num);
	}
	
	/*
	 * isEmpty
	 * Author: Jeremiah Hanson
	 * -----------------------------------------------
	 * Purpose: tells if the matchList is empty
	 */
	public boolean isEmpty() {
		return matches.isEmpty();
	}

}
