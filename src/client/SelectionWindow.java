package client;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import enums.Alliance;
import serverDataBase.Match;
import serverDataBase.Team;
import serverDataBase.Tournament;

public class SelectionWindow extends JPanel{

	private static final long serialVersionUID = 1L;
		
	private static Tournament event;
	private JTextArea matchArea, teamArea;
	private JSpinner teamNumberSpin, matchNumberSpin;
	private SpinnerNumberModel numSpinMod;
	private SpinnerListModel listSpinMod;
	private JButton enterButton;
	private Font myFont;
	private ArrayList<Integer> teamList;
	
	
	public SelectionWindow() {
		
		event = Tournament.getInstanceOf();
		event.generateMatchList(30);
		event.getMatchList().getMatch(1).addTeam(new Team(1011), 1011, Alliance.RED_ALLIANCE);
		
		myFont = new Font("Times New Roman", Font.PLAIN, 40);
		
		this.setSize(800,400);
		this.setLayout(new GridLayout(5,1));
		
		matchArea = new JTextArea("Choose Your Match:");
		this.add(matchArea);
		matchArea.setFont(myFont);
		
		numSpinMod = new SpinnerNumberModel(0,0,event.getMatchCount(),1);
		matchNumberSpin = new JSpinner(numSpinMod);
		this.add(matchNumberSpin);
		matchNumberSpin.setFont(myFont);
		matchNumberSpin.addChangeListener(new SpinnerListener());
		
		teamArea = new JTextArea("Choose Your Team:");
		this.add(teamArea);
		teamArea.setFont(myFont);
		
		teamList = new ArrayList<>();
		teamList.add(0);
		listSpinMod = new SpinnerListModel(teamList);
		teamNumberSpin = new JSpinner(listSpinMod);
		this.add(teamNumberSpin);
		teamNumberSpin.setFont(myFont);
		
		enterButton = new JButton("Enter");
		enterButton.setFont(myFont);
		enterButton.addActionListener(new ButtonListener());
		this.add(enterButton);

	}
	
	private class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}

	}
	
	private class SpinnerListener implements ChangeListener{

		@Override
		public void stateChanged(ChangeEvent arg0) {
			int match = (int)matchNumberSpin.getValue();
			teamList = event.listOfTeams(match);
		}

	}
}
