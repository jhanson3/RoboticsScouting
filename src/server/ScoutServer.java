package server;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ScoutServer {
	
	public static final int PORT_NUMBER = 10110;
	private static int numClients;
	private static ArrayList<ClientConfig> clients;
	private static int count;
	private static ArrayList<Thread> threads;

	public static void main(String[] args) throws IOException{
		if (args.length >= 1)
			numClients = Integer.parseInt(args[0]);
		else 
			numClients = 6;
		
		new ScoutServer();
	}
	
	public ScoutServer() {
		clients = new ArrayList<ClientConfig>();
		count = 0;
		threads = new ArrayList<Thread>();
		
		// Create Socket
        try {
            ServerSocket serverSocket = new ServerSocket(PORT_NUMBER);
            while (count < numClients) {
	            Socket clientSocket = serverSocket.accept();
	            ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
	            clients.add(new ClientConfig(clientSocket.getInetAddress(), count));
	            
	            threads.add(new Thread(new SetupRing(clients.get(count), out)));
	            System.out.println("Connection established with client #" + count);
	            count++;
            }
            
            while(!threads.isEmpty()) {
            	Thread t = threads.remove(0);
            	t.start();
            }
            
            serverSocket.close();
        } catch (IOException e) {
            System.err.println("Could not listen on port: 1011.");
            System.exit(1);
        }
        
	}
	
	private class SetupRing implements Runnable{
		
		ClientConfig client;
		ObjectOutputStream out;
		
		public SetupRing(ClientConfig client, ObjectOutputStream out) {
			this.client = client;
			this.out = out;
		}

		@Override
		public void run() {
			
			int next;
			if (client.clientNum == (numClients - 1)) {
				next = 0;
			} else {
				next = client.clientNum + 1;
			}
			
			System.out.println("sending data for " + next + " to " + client.clientNum);
			
			try {
				out.writeObject(client.clientNum);
				out.writeObject(clients.get(next));
				out.flush();
			} catch (IOException e) {
				System.out.println("Failed to send data to client #" + client.clientNum);
				e.printStackTrace();
			}
		}
		
	}
}
