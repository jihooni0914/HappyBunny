package server;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ServerStart {
	private ArrayList<ClientThread> clients;
	private ServerSocket serverSocket;
	private static int PORT = 4885;
	private static int MAX_CLIENTS = 4;
	
	public ServerStart() {
		try {
			serverSocket = new ServerSocket(PORT);
			clients = new ArrayList<>();
			
			while (true) {
				Socket s = serverSocket.accept();
				System.out.println("connect");
				
				ClientThread c = new ClientThread(s);
				c.start();
				
				
			}
		} 
		catch (Exception e) {
			System.err.println(e);
		}
	}
	
	public static void main(String[] args) {
		new ServerStart();
	}
}

