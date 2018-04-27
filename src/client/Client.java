/*
 * Client.java
 * Author: Jeremiah Hanson
 * -----------------------------------------------------
 * This contains the main class for the client-side 
 * program.
 */

package client;

import serverDataBase.Team;
import serverDataBase.TeamSheet;

public class Client {

	private static ClientGUI window;
	private static ClientCommandLine comLine;
	private static boolean lead; // Can only have one lead
	private static int scouter;
	private static TeamSheet event;
	private static Thread comLineThread;
	
	/*
	 * isLead
	 * ----------------------------------
	 * returns if this client is the leader
	 */
	public boolean isLead() {
		return lead; // TODO: initialize
	}
	
	/* Main */
	public static void main(String[] args) {
		boolean gui = false;
		
		if (args.length >= 1) 
			gui = ((args[0].equals("true")) ? true : false);
		
		//TODO: Server stuff
			// if first to server make it lead
			// get scouter number from server
		
		if (gui) beginWindow(); // start gui scout
		else beginCommandLine(); // start commandline scout
	}
	
	/* 
	 * beginWindow
	 * ---------------------------------
	 * Starts the Gui
	 */
	public static void beginWindow() {
		window = new ClientGUI();
		window.setVisible(true);
	}
	
	/*
	 * beginCommandLine
	 * ---------------------------------
	 * starts the commandline scout
	 */
	public static void beginCommandLine() {
		if (lead) createEvent();
		comLine = new ClientCommandLine(lead, scouter, event);
		comLineThread = new Thread(comLine);
	}
	
	/*
	 * createEvent
	 * -------------------------
	 * create a new event
	 */
	public static void createEvent() {
		event = TeamSheet.getInstanceOf();
	}
	
	/*
	 * sendEvent
	 * ------------------------------------
	 * Sends the TeamSheet event to other clients
	 */
	public static void sendEvent() {
		// TODO: write this
	}
	
	/*
	 * sendMatch
	 * -----------------------------------
	 * Sends the current Match to other clients
	 * Parameters:
	 * 	teams: a list of Team to send out
	 */
	public static void sendMatch(Team[] teams) {
		// TODO: write this
	}

	/*
	 * getMatch
	 * -----------------------------------
	 * waits for the next match to be recieved
	 */
	public static void getMatch() {
		// TODO Auto-generated method stub
		
	}
}
