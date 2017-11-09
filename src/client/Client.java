/*
 * Client.java
 * Author: Jeremiah Hanson
 * -----------------------------------------------------
 * This contains the main class for the client-side 
 * program.
 */

package client;

public class Client {

	private static ClientGUI window;
	
	public static void main(String[] agrs) {
		
		window = new ClientGUI();
		window.setVisible(true);

	}
}
