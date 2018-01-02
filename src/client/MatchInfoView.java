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

import serverDataBase.Tournament;

public class MatchInfoView extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6502627067768345101L;
	
	private static Tournament event;
	private JTextArea matchArea, red1Area, red2Area, red3Area, blue1Area, blue2Area, blue3Area;
	private JSpinner matchSpin, redSpin1, redSpin2, redSpin3, blueSpin1, blueSpin2, blueSpin3;
	private JButton enterButton;
	private SpinnerNumberModel matchSpinMod;
	private SpinnerListModel teamSpinMod;
	private Font myFont;
	private ArrayList<Integer> teamList;
	
	public MatchInfoView() {
		
		event = Tournament.getInstanceOf();
		event.generateMatchList(30);
		
		myFont = new Font("Times New Roman", Font.PLAIN, 40);
		
		this.setSize(973,1000);
		this.setLayout(new GridLayout(15,1));
		
		matchArea = new JTextArea("Match:");
		this.add(matchArea);
		matchArea.setFont(myFont);
		
		matchSpinMod = new SpinnerNumberModel(0,0,event.getMatchCount(),1);
		matchSpin = new JSpinner(matchSpinMod);
		this.add(matchSpin);
		matchSpin.setFont(myFont);
		
		red1Area = new JTextArea("Red 1:");
		this.add(red1Area);
		red1Area.setFont(myFont);
		
		teamList = new ArrayList<>();
		teamList.add(0);
		teamList.add(2662);
		teamList.add(1011);
		
		teamSpinMod = new SpinnerListModel(teamList);
		redSpin1 = new JSpinner(teamSpinMod);
		this.add(redSpin1);
		redSpin1.setFont(myFont);
		
		red2Area = new JTextArea("Red 2:");
		this.add(red2Area);
		red2Area.setFont(myFont);
		
		teamSpinMod = new SpinnerListModel(teamList);
		redSpin2 = new JSpinner(teamSpinMod);
		this.add(redSpin2);
		redSpin2.setFont(myFont);
		
		red3Area = new JTextArea("Red 3:");
		this.add(red3Area);
		red3Area.setFont(myFont);
		
		teamSpinMod = new SpinnerListModel(teamList);
		redSpin3 = new JSpinner(teamSpinMod);
		this.add(redSpin3);
		redSpin3.setFont(myFont);
		
		blue1Area = new JTextArea("Blue 1:");
		this.add(blue1Area);
		blue1Area.setFont(myFont);
		
		teamSpinMod = new SpinnerListModel(teamList);
		blueSpin1 = new JSpinner(teamSpinMod);
		this.add(blueSpin1);
		blueSpin1.setFont(myFont);
		
		blue2Area = new JTextArea("Blue 2:");
		this.add(blue2Area);
		blue2Area.setFont(myFont);
		
		teamSpinMod = new SpinnerListModel(teamList);
		blueSpin2 = new JSpinner(teamSpinMod);
		this.add(blueSpin2);
		blueSpin2.setFont(myFont);
		
		blue3Area = new JTextArea("Blue 3:");
		this.add(blue3Area);
		blue3Area.setFont(myFont);
		
		teamSpinMod = new SpinnerListModel(teamList);
		blueSpin3 = new JSpinner(teamSpinMod);
		this.add(blueSpin3);
		blueSpin3.setFont(myFont);
		
		enterButton = new JButton("Enter");
		enterButton.setFont(myFont);
		this.add(enterButton);
		enterButton.addActionListener(new ButtonListener());
	}
	private class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}

	}	
	
}

