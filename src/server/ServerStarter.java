package server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerStarter {
	private ClientThread[] clients;
	private ServerSocket serverSocket;
	private static int PORT = 4885;
	private static int MAX_CLIENTS = 4;
	private int c_cnt;
	private int alive;
	private boolean isStart = false;
	
	public ServerStarter() {
		try {
			serverSocket = new ServerSocket(PORT);
			clients = new ClientThread[4];
			c_cnt = 0;
			
			while (true) {
				Socket s = serverSocket.accept();
				System.out.println("Server connect");
				
				if (c_cnt >= MAX_CLIENTS) {
					System.out.println("Maximum number of clients reached. Connection refused.");
					s.close();
					continue;
				}
				
				for (int i = 0; i < MAX_CLIENTS; i ++) {
					if (clients[i] == null) {
						ClientThread c = new ClientThread(s, i);
						clients[i] = c;
						c_cnt ++;
						c.start();
						break;
					}
				}
			}
		} 
		catch (Exception e) {
			System.err.println(e);
		}
	}
	
	public static void main(String[] args) {
		new ServerStarter();
	}
	
	
	class ClientThread extends Thread {
		public Socket socket;
		public PrintWriter writer;
		public BufferedReader reader;
		public String clientIP;
		public int cthid; // client thread num
		public String name; // user input id
		private boolean isExited = false;
		private boolean isBoom = false;
		private int score = 0;
		
		public ClientThread(Socket s, int cthid) {
			this.socket = s;
			this.cthid = cthid;
		}
		
		@Override
		public void run() {
			try {
				reader = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
				writer = new PrintWriter(this.socket.getOutputStream(), true);
				writer.println("connect/" + cthid);
				
				String recv_msg = null;
				InetAddress clientAddress = this.socket.getInetAddress();
				this.clientIP = clientAddress.getHostAddress();
				
				while (((recv_msg = reader.readLine()) != null)) {
					System.out.println("Message received: " + recv_msg);
					
					String[] event = recv_msg.split("/");
					eventManager(event);
				}
				
//				if (!isExited) {
//					System.out.println("Client" + this.cthid + "disconnected");
//					pExit();					
//				}
				System.out.println("reachable?");
				socket.close();
			}
			catch (Exception e) {
				System.err.println(e);
				System.out.println("Client[" + this.cthid + "] disconnected");
				pExit(1);
			}
		}
		
		public void eventManager(String[] event) {
			switch (event[0]) {
			case "login" :
				pLogin(event[1]);
				break;
			case "boom" :
				pBoom(Integer.parseInt(event[1]));
				break;
			case "exit" :
				pExit(Integer.parseInt(event[1]));
				break;
			}
		}
		
		public void sendId(int cthid) {
			writer.println("connect/" + cthid);
		}
		
		public void pLogin(String name) {
			this.name = name;
			// 새로운 유저 login 시 기존에 접속해 있던 유저 정보 전달
			for (int i = 0; i < MAX_CLIENTS; i ++) {
				if (clients[i] == null || i == this.cthid) {
					continue;
				}
				System.out.println(i);
				this.writer.println("user/" + clients[i].cthid + "/" + clients[i].name); // 새로운 유저 login 시 기존에 접속해 있던 유저 정보 전달
				clients[i].writer.println("user/" + this.cthid + "/" + name); // 기존 유저에게 새로운 유저에 대한 정보 전달
			}
			
			printClients();
			
			if (c_cnt == MAX_CLIENTS) {
				for (ClientThread c : clients) {
					c.writer.println("start");
					alive = 4;
					isStart = true;
				}
			}
		}
		
		private void pBoom(int score) {
			for (int i = 0; i < MAX_CLIENTS; i ++) {
				if (i != cthid && clients[i] != null) {
					clients[i].writer.println("die/" + cthid + "/" + score);
				}
			}
			
			alive--;
			isBoom = true;
			// all users boom
			if (isStart == true && alive == 0) {
				gameEnd();
			}
		}
		
		public void pExit(int score) {
			// exit 시 다른 client에게 알리기
			for (int i = 0; i < MAX_CLIENTS; i ++ ) {
				if (i != this.cthid && clients[i] != null) {
					
					if (!isStart) {
						clients[i].writer.println("exit/" + this.cthid);						
					}
					else {
						clients[i].writer.println("die/" + cthid + "/" + score);
					}
				}
			}
			
			
			if (isStart && !isBoom) {
				alive--;
			}
			clients[this.cthid] = null;
			c_cnt--;
			this.isExited = true;
			
			if (alive == 0) {
				gameEnd();
			}
		}
		
		private void gameEnd() {
			for (int i = 0; i < MAX_CLIENTS; i ++) {
				if (clients[i] != null) {
					clients[i].writer.println("result");
				}
			}
		}
	}
	
	public void printClients() {
		for (int i = 0; i < c_cnt; i ++) {
			if (clients[i] == null) {
				continue;
			}
			System.out.println("Client[" + i + "]: ");
			System.out.println("IP: " + clients[i].clientIP);
			System.out.println("Thread ID: " + clients[i].cthid);
			System.out.println("Name: " + clients[i].name);
			System.out.println();
		}
	}
}

