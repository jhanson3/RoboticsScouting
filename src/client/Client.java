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
	private ObjectInputStream serverInput, fromPrevClient;
	private ObjectOutputStream toNextClient;
	private ClientConfig nextConfig;
	private ServerSocket mySock;
	private static Client mySelf;
	private Boolean sent;
	
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
	}
	
	public Client() {
		sent = false;
		
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
	public void sendMatch(Team[] teams) {
		// TODO: write this
	}

	/*
	 * getMatch
	 * -----------------------------------
	 * waits for the next match to be recieved
	 */
	public void getMatch() {
		// TODO Auto-generated method stub
		
	}
}
