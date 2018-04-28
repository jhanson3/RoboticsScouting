package server;

import java.io.Serializable;
import java.net.Socket;

public class ClientConfig implements Serializable{
	
	private static final long serialVersionUID = 4849278127267013495L;
	public Socket sock;
	public int clientNum;
	
	public ClientConfig(Socket sock, int num) {
		this.sock = sock;
		this.clientNum = num;
	}
}