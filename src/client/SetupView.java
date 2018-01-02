/*
 * SetupView.java
 * Author: Jeremiah Hanson
 * -------------------------------------------------------
 * This class is a gui element that is used to setup a new 
 * tournament. It is a separate window that will close after
 * the necessary info is entered.
 */

package client;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import serverDataBase.Tournament;

public class SetupView extends JPanel{

	private static final long serialVersionUID = 8258005025289483246L;

	private static Tournament event;
	private JTextField nameText, numMatchesText;
	private JTextArea nameArea, matchesArea;
	private JButton enterButton;
	private Font myFont;
	private SpinnerNumberModel spinMod;
	private JSpinner numMatchesSpin;
	
	/*
	 * Constructor
	 * Author: Jeremiah Hanson
	 * ----------------------------------
	 * Purpose: constructor
	 */
	public SetupView() {
		
		event = Tournament.getInstanceOf();
		
		myFont = new Font("Courier", Font.PLAIN, 40);

		this.setSize(800, 400);
		this.setLayout(new GridLayout(5, 1));
		
		nameArea = new JTextArea("Enter Event Name Here:");
		nameArea.setFont(myFont);
		this.add(nameArea);
		
		nameText = new JTextField();
		nameText.setFont(myFont);
		this.add(nameText);
		
		matchesArea = new JTextArea("Enter Number of Matches Here:");
		matchesArea.setFont(myFont);
		this.add(matchesArea);
		
		spinMod = new SpinnerNumberModel(0, 0, 100, 1);
		numMatchesSpin = new JSpinner(spinMod);
		numMatchesSpin.setFont(myFont);
		this.add(numMatchesSpin);
		
//		numMatchesText = new JTextField();
//		numMatchesText.setFont(myFont);
//		this.add(numMatchesText);
		
		enterButton = new JButton("Enter");
		enterButton.setFont(myFont);
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
			if (nameText.getText().compareTo("") != 0) {
				event.setName(nameText.getText());
				event.generateMatchList((int)numMatchesSpin.getValue());
				closeWindow();
			}
			
			
		}
		
	}
}
