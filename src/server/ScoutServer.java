package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ScoutServer {
	
	public static final int PORT_NUMBER = 10111011;
	private static int numClients;
	private static ClientConfig[] clients;

	public static void main(String[] args) throws IOException{
		
		if (args.length >= 1)
			numClients = Integer.parseInt(args[0]);
		else 
			numClients = 6;
		
		clients = new ClientConfig[numClients];
		
		// Create Socket
        try {
            ServerSocket serverSocket = new ServerSocket(PORT_NUMBER, numClients);
            while (true) {
	            Socket clientSocket = serverSocket.accept();
	            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
	            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            }
        } catch (IOException e) {
            System.err.println("Could not listen on port: 1011.");
            System.exit(1);
        }
        
        
        
	}
	
	private class ClientConfig {
		
		Socket sock;
		PrintWriter out;
		BufferedReader in;
		
		public ClientConfig(Socket sock, PrintWriter out, BufferedReader in) {
			this.sock = sock;
			this.out = out;
			this.in = in;
		}
	}
}
