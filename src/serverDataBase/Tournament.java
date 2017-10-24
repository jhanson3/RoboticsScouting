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

}
