/*
 * SetupView.java
 * Author: Jeremiah Hanson
 * -------------------------------------------------------
 * This class is a gui element that is used to setup a new 
 * tournament. It is a separate window that will close after
 * the necessary info is entered.
 */

package client;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import serverDataBase.Tournament;

public class SetupView extends JFrame{

	private static final long serialVersionUID = 8258005025289483246L;

	private static Tournament event;
	private JTextField nameText, numMatchesText;
	private JButton enterButton;
	
	/*
	 * Constructor
	 * Author: Jeremiah Hanson
	 * ----------------------------------
	 * Purpose: constructor
	 * Parameters:
	 * 	event: The tournament event
	 */
	public SetupView(Tournament event) {
		
		this.event = event;
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400, 400);
		this.setLocation(100, 100);
		this.setTitle("CRUSH Scouting - Event Setup");
		this.setLayout(new GridLayout(3, 1));
		
		nameText = new JTextField("Enter event name here.");
		this.add(nameText);
		
		numMatchesText = new JTextField("Enter number of Matches");
		this.add(numMatchesText);
		
		enterButton = new JButton("Enter");
		enterButton.addActionListener(new ButtonListener());
		this.add(enterButton);
		
	}
	
	private void closeWindow() {
		this.setVisible(false);
	}
	
	private class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			closeWindow();
			
		}
		
	}
}
