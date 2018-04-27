package client;

import java.util.Scanner;

import enums.ScoreType;
import serverDataBase.Team;
import serverDataBase.TeamSheet;

/**
 * This is the class that is used if gui is not selected. It allows the client to run the program
 * via commandline commands instead of a visual gui.
 * @author Jeremiah Hanson
 * @see client.ClientGUI
 */
public class ClientCommandLine implements Runnable{
	
	private boolean lead, inMatch, alive;
	private Scanner in;
	private String name;
	private TeamSheet event;
	@SuppressWarnings("unused")
	private int curMatch, scouter;
	@SuppressWarnings("unused")
	private Team curTeam;
	
	public ClientCommandLine(Boolean lead, int numScouter, TeamSheet event) {
		this.lead = lead;
		this.scouter = numScouter;
		inMatch = false;
		this.event = event;
		curMatch = 1;
	}
	
	/**
	 * sets inMatch to true so the match can start
	 */
	public void startMatch() {
		inMatch = true;
		alive = true;
	}
	
	/**
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		in = new Scanner(System.in);
		
		System.out.println("Enter Name: ");
		name = in.nextLine();
		
		if (lead) { // Only for the scout lead
			Client.sendEvent(); // send the teamlist
			settupMatch(); // set up and send the first match
		}
		
		while (alive) {
			while (in.hasNext()) {
				String buff = in.nextLine();
				
				if (buff.toLowerCase().equals("list")) {
					printTeams();
				} else if (buff.toLowerCase().equals("show")) {
					System.out.println("Which team would you like to show?");
					buff = in.nextLine();
					int num = Integer.parseInt(buff);
					
					if (event.teamExists(num)) {
						printTeam(num);
					} else {
						System.out.println("Team " + num + "does not exist in this event.");
					}
					
				} else if (buff.toLowerCase().equals("start")) {
					if (inMatch) {
						break;
					} else {
						System.out.println("Match data not yet recieved, cannot start yet.");
					}
				} else {
					System.out.println("please enter a valid command. They are:");
					System.out.println("        list");
					System.out.println("        show");
					System.out.println("        match");
					System.out.println("        start");
				}
			}
			
			if (inMatch) {
				Client.getMatch(); // TODO: needs updating depending on network structure
				playMatch();
			
			}
		}
		
	}
	
	/**
	 * prints a given team to the console
	 * @param num the team to be printed
	 */
	private void printTeam(int num) {
		event.printTeam(num);
	}

	/**
	 * lets the leader set up the match and assign each other client 
	 * to a specific robot
	 * @author Jeremiah Hanson
	 */
	private void settupMatch() {
		System.out.println("Enter teams for match#" + curMatch + ": ");
		
		Team[] curTeams = new Team[6];
		for (int i = 0; i < 6; i++) {
			int number = in.nextInt();
			event.addTeam(number, false, null);
			curTeams[i] = event.getTeam(number);
		}
		Client.sendMatch(curTeams);
		
	}

	/**
	 * starts a loop that is used to accept commands to 
	 * score points for a given robot in a match
	 */
	private void playMatch() {
		
		while (in.hasNext()) {
			String buff = in.nextLine();
			
			if (buff.toLowerCase().equals("switch")) {
				System.out.println("Type 'o' for own and 'e' for opponents: ");
				buff = in.nextLine();
				if (buff.toLowerCase().equals("o")) {
					curTeam.addScore(curMatch, ScoreType.SWITCH);
				} else if (buff.toLowerCase().equals("e")) {
					curTeam.addScore(curMatch, ScoreType.OP_SWITCH);
				}
			} else if (buff.toLowerCase().equals("scale")) {
				curTeam.addScore(curMatch, ScoreType.SCALE);
			} else if (buff.toLowerCase().equals("vault")) {
				curTeam.addScore(curMatch, ScoreType.VAULT);
			} else if (buff.toLowerCase().equals("done")) {
				break;
			} else {
				System.out.println("please enter a valid command. They are:");
				System.out.println("        switch");
				System.out.println("        scale");
				System.out.println("        vault");
				System.out.println("        done");
			}
				
			
		}
		
	}
	
	/*
	 * getName
	 * -------------------------
	 * returns the name of the scouter
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * print all the teams to the console
	 */
	public void printTeams() {
		event.printTeams();
	}

}