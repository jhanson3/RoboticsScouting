package server;

import java.io.IOException;
import java.net.ServerSocket;

public class ScoutServer {

	public static void main(String[] args) throws IOException{
		
		// Create Socket
		ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(1011);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 4444.");
            System.exit(1);
        }
        
        
        
	}
}
