package server;

import java.io.Serializable;
import java.net.InetAddress;

public class ClientConfig implements Serializable{
	
	private static final long serialVersionUID = 4849278127267013495L;
	public InetAddress addr;
	public int clientNum;
	
	public ClientConfig(InetAddress sock, int num) {
		this.addr = sock;
		this.clientNum = num;
	}
}