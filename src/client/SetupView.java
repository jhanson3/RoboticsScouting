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
import javax.swing.JPanel;
import javax.swing.JTextField;

import serverDataBase.Tournament;

public class SetupView extends JPanel{

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
	 * 	none
	 */
	public SetupView() {
		
		event = Tournament.getInstanceOf();

		this.setSize(400, 400);
		this.setLayout(new GridLayout(3, 1));
		
		nameText = new JTextField();
		this.add(nameText);
		
		numMatchesText = new JTextField();
		this.add(numMatchesText);
		
		enterButton = new JButton("Enter");
		enterButton.addActionListener(new ButtonListener());
		this.add(enterButton);
		
	}
	
	/*
	 * closeWindow
	 * Author: Jeremiah Hanson
	 * -----------------------------------------------
	 * Purpose: sets the setup view window's visibility 
	 * 		to false.
	 */
	private void closeWindow() {
		this.setVisible(false);
	}
	
	/*
	 * ButtonListener
	 * Author: Jeremiah Hanson
	 * ----------------------------------------------------------------------------
	 * This is a private class that is used to determine what to do when the button
	 * in this view has been pressed.
	 */
	private class ButtonListener implements ActionListener{

		// Required by ActionListener
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			// if either field is empty do nothing
			if (nameText.getText().compareTo("") != 0 || numMatchesText.getText().compareTo("") != 0) {
				closeWindow();
			}
			
			
		}
		
	}
}
