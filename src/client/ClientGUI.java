/*
 * ClientGUI.java
 * Author: Jeremiah Hanson
 * ---------------------------------------------------
 * This is a simple gui to be used on a computer for 
 * testing the back-end data structure
 */

package client;

import javax.swing.JFrame;

public class ClientGUI extends JFrame{

	private static final long serialVersionUID = -8877474517268367965L;

	public ClientGUI() {
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1000, 600);
		this.setLocation(100, 100);
		this.setTitle("CRUSH Scouting");
		this.setLayout(null);
	}
	
}
