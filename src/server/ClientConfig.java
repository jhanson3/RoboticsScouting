package server;

import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;

public class ClientConfig implements Serializable{
	
	private static final long serialVersionUID = 4849278127267013495L;
	public Socket sock;
	public ObjectOutputStream out;
	public int clientNum;
	
	public ClientConfig(Socket sock, ObjectOutputStream out, int num) {
		this.sock = sock;
		this.out = out;
		this.clientNum = num;
	}
}