/*
 * Client.java
 * Author: Jeremiah Hanson
 * -----------------------------------------------------
 * This contains the main class for the client-side 
 * program.
 */

package client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import serverDataBase.Team;
import serverDataBase.TeamSheet;
import server.ClientConfig;

public class Client {

	private static ClientGUI window;
	private static ClientCommandLine comLine;
	private static boolean lead; // Can only have one lead
	private static int scouter;
	private static final int BASE_PORT = 10111;
	private static TeamSheet event;
	private static Thread comLineThread;
	private Socket server, nextClient, prevClient;
	private static String serverName;
	private ObjectInputStream serverInput;
	private static ObjectInputStream fromPrevClient;
	private static ObjectOutputStream toNextClient;
	private ClientConfig nextConfig;
	private ServerSocket mySock;
	private static Client mySelf;
	
	/*
	 * isLead
	 * ----------------------------------
	 * returns if this client is the leader
	 */
	public boolean isLead() {
		return lead; // TODO: initialize
	}
	
	/* Main */
	public static void main(String[] args) {
		boolean gui = false;
		
		if (args.length >= 1)
			serverName = args[0];
		if (args.length >= 2) 
			gui = ((args[1].equals("true")) ? true : false);
		
		mySelf = new Client();
		
		if (gui) beginWindow(); // start gui scout
		else beginCommandLine(); // start commandline scout
		
		try {
			comLineThread.wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public Client() {
		try {
			server = new Socket(serverName, 10110);
			serverInput = new ObjectInputStream(server.getInputStream());
			System.out.println("Found server '" + serverName + "'");
			scouter = (int) serverInput.readObject();
			nextConfig = (ClientConfig) serverInput.readObject();
			
			lead = (scouter == 0 ? true : false);
			int myPort = BASE_PORT + scouter;
			mySock = new ServerSocket(myPort);
			
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		// Connect the ring starting with the lead
		if (lead) {
			try {
				nextClient = new Socket(nextConfig.sock.getInetAddress(), BASE_PORT + nextConfig.clientNum);
				mySock.accept();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			try {
				prevClient = mySock.accept();
				nextClient = new Socket(nextConfig.sock.getInetAddress(), BASE_PORT + nextConfig.clientNum);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("Connected to other clients ready to start");
		
		// establish the input/output streams
		try {
			fromPrevClient = new ObjectInputStream(prevClient.getInputStream());
			toNextClient = new ObjectOutputStream(nextClient.getOutputStream());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/* 
	 * beginWindow
	 * ---------------------------------
	 * Starts the Gui
	 */
	public static void beginWindow() {
		window = new ClientGUI();
		window.setVisible(true);
	}
	
	/*
	 * beginCommandLine
	 * ---------------------------------
	 * starts the commandline scout
	 */
	public static void beginCommandLine() {
		if (lead) createEvent();
		comLine = new ClientCommandLine(lead, scouter, event, mySelf);
		comLineThread = new Thread(comLine);
		comLineThread.start();
		Thread t = new Thread(scoutReader());
		t.start();
	}
	
	private static Runnable scoutReader() {
		while(true) {
			ScouterMessage message = null;
			try {
				message = (ScouterMessage)fromPrevClient.readObject();
			} catch (ClassNotFoundException | IOException e) {
				e.printStackTrace();
			}
			
			// message has returned to the sender do nothing
			if (message.getScouter() == scouter)
				continue;
			
			// Deal with getting just a team
			if (message.isSingleTeam()) {
				event.addTeam(message.getTeam());
				System.out.println("Data recieved for team " + message.getTeam().getTeamNum());
			} else { // Deal with getting a match 
				Team teams[] = message.getTeams();
				for (int i=0; i < teams.length; i++) {
					event.addTeam(teams[i].getTeamNum(), false, null);
				}
				comLine.curTeam = teams[scouter];
				comLine.curMatch = message.getMatch();
				comLine.inMatch = true;
				
				System.out.println("New Match schedule recieved! You are scouting team " + teams[scouter].getTeamNum() + ".");
			}
			
			try {
				toNextClient.writeObject(message);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	

	/*
	 * createEvent
	 * -------------------------
	 * create a new event
	 */
	public static void createEvent() {
		event = TeamSheet.getInstanceOf();
	}
	
	/*
	 * sendMatch
	 * -----------------------------------
	 * Sends the current Match to other clients
	 * Parameters:
	 * 	teams: a list of Team to send out
	 */
	public void sendMatch(Team[] teams, int match) {
		ScouterMessage message = new ScouterMessage(teams, match, scouter);
		try {
			toNextClient.writeObject(message);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void sendTeam(Team team) {
		ScouterMessage message = new ScouterMessage(team, scouter);
		try {
			toNextClient.writeObject(message);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
