/*
 * TeamSheet.java
 * Author: Jeremiah Hanson
 * ------------------------------------------------------------------------------------
 * This class is responsible for the list of teams and getting, setting, and adding 
 * teams to the list.
 */

package server;

import java.io.Serializable;
import java.util.HashMap;

public class TeamSheet implements Serializable {

	private static final long serialVersionUID = -215213122891539175L;
	
	HashMap teams;
	
	private TeamSheet() {
		teams = new HashMap();
	}
	
}
