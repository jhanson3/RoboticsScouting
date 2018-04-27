package server;

import java.io.BufferedReader;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientConfig {
	
	public Socket sock;
	public ObjectOutputStream out;
	public BufferedReader in;
	public int clientNum;
	
	public ClientConfig(Socket sock, ObjectOutputStream out, BufferedReader in, int num) {
		this.sock = sock;
		this.out = out;
		this.in = in;
		this.clientNum = num;
	}
}