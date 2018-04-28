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
	
	public boolean inMatch;
	private boolean lead, alive;
	private Scanner in;
	private String name;
	private TeamSheet event;
	public int curMatch, scouter;
	public Team curTeam;
	private Client client;
	
	public ClientCommandLine(Boolean lead, int numScouter, TeamSheet event, Client client) {
		this.lead = lead;
		this.scouter = numScouter;
		inMatch = false;
		this.event = event;
		curMatch = 1;
		this.client = client;
		alive = true;
	}
	
	/**
	 * sets inMatch to true so the match can start
	 */
	public void startMatch() {
		inMatch = true;
	}
	
	/**
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		in = new Scanner(System.in);
		
		System.out.println("Enter Name: ");
		name = in.nextLine();
		System.out.println("Welcome " + name);
		
		while (alive) {
			while (true) {
				
				if (lead && !inMatch) { // Only for the scout lead
					settupMatch(); // set up and send the first match
				}
				
				System.out.println("Waiting for a match");
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
						System.out.println("Team " + num + " does not exist in this event.");
					}
					
				} else if (buff.toLowerCase().equals("start")) {
					if (inMatch) {
						break;
					} else {
						System.out.println("Match data not yet recieved, cannot start yet.");
					}
				} else if (buff.toLowerCase().equals("exit")) {
					notify();
					return;
				}
				else {
					System.out.println("please enter a valid command. They are:");
					System.out.println("        list");
					System.out.println("        show");
					System.out.println("        start");
					System.out.println("        exit");
				}
			}
			
			if (inMatch) {
				playMatch();
				client.sendTeam(curTeam);
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
		client.sendMatch(curTeams, curMatch);
		curMatch++;
		inMatch = true;
	}

	/**
	 * starts a loop that is used to accept commands to 
	 * score points for a given robot in a match
	 */
	private void playMatch() {
		
		System.out.println("You have started the match, please track scores in:");
		System.out.println("     switch");
		System.out.println("     scale");
		System.out.println("     Vault");
		
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
				inMatch = false;
				return;
			} else {
				System.out.println("please enter a valid command. They are:");
				System.out.println("        switch");
				System.out.println("        scale");
				System.out.println("        vault");
				System.out.println("        done");
			}
			
			printTeam(curTeam.getTeamNum());
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
