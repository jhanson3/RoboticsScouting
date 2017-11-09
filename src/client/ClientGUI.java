/*
 * ClientGUI.java
 * Author: Jeremiah Hanson
 * ---------------------------------------------------
 * This is a simple gui to be used on a computer for 
 * testing the back-end data structure
 */

package client;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ClientGUI extends JFrame{

	private static final long serialVersionUID = -8877474517268367965L;
	private JPanel left, right;
	private SetupView setup;
	
	public ClientGUI() {
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(2000, 1000);
		this.setLocation(100, 100);
		this.setTitle("CRUSH Scouting");
		this.setLayout(null);
		
		setup = new SetupView();
		this.add(setup);
		
	}
	
}
