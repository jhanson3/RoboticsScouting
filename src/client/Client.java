/*
 * Client.java
 * Author: Jeremiah Hanson
 * -----------------------------------------------------
 * This contains the main class for the client-side 
 * program.
 */

package client;

import serverDataBase.Tournament;

public class Client {

	private static Tournament tourn;
	private static static SetupView setup;
	
	public static void main(String[] agrs) {
		
		tourn = Tournament.getInstanceOf();
		
		setup = new SetupView(tourn);
		setup.setVisible(true);

	}
}
