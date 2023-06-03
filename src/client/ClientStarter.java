package client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.LinkedList;
import java.util.ListIterator;

import ui.*;

public class ClientStarter {
	private static int PORT = 4885;
	private static String HOST = "localhost";
	private Socket socket;
	private PrintWriter writer;
	private LinkedList<User> users;
	
	private LoginUI login;
	private Login loginUI;
	
	public static void main(String[] args) {
		new ClientStarter();
	}
	
	public ClientStarter() {
		this.users = new LinkedList<>();
		connectServer();
		
		init();
		setListeners();
		setUIVisible();
	}
	
	private void init() {
		login = new LoginUI();
		loginUI = new Login();
	}
	
	private void setListeners() {
		login.loginButton.addActionListener(new ActionListener() {
		      @Override
		      public void actionPerformed(ActionEvent e) {
		          String username = login.usernameField.getText();
		          writer.println("login/" + username);
		          login.usernameField.setText("");
		      }
		});
			
		login.printUsersButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				printUsers();
			}
		});
		
		login.bustButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int bustNum = Integer.parseInt(login.bustNumField.getText());
				for (int i = 0; i < bustNum; i ++) {
					writer.println("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
				}
				writer.println("hahaha\n");
			}
		});
		
		loginUI.multi.button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String username = loginUI.multi.textbox.getText();
				writer.println("login/" + username);
			}
		});
           
	}
	
	private void setUIVisible() {
//		login.setVisible(true);
		loginUI.frame.setVisible(true);
	}
	
	private void printUsers() {
		System.out.println("printUsers()");
		for (User u : users) {
			System.out.println("User" + u.cthid + ": " + u.name);
		}
		
		System.out.println();
	}
	
	private void connectServer() {
		try {
			socket = new Socket(HOST, PORT);
			System.out.println("Client connect");
			writer = new PrintWriter(this.socket.getOutputStream(), true);
			ReaderThread rt = new ReaderThread();
			rt.start();
		}
		catch (Exception e) {
			System.out.println("Connection error: " + e);
		}
	}
	
	class ReaderThread extends Thread {
		private BufferedReader reader;
		
		@Override
		public void run() {
			try {
				reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				
				String recv_msg = null;
				while ((recv_msg = reader.readLine()) != null) {
					System.out.println("Message received from server: " + recv_msg);
					
					String[] event = recv_msg.split("/");
					eventManager(event);
				}
			}
			catch (Exception e) {
				System.out.println("ReaderThread error: " + e);
			}
		}
		
		public void eventManager(String[] event) {
			switch (event[0]) {
			case "user" :
				pAddUser(event[1], event[2]);
				break;
			case "exit" :
				pExit(Integer.parseInt(event[1]));
				break;
			case "start" :
				break;
			case "" :
				break;
			case "die" :
				pDie(Integer.parseInt(event[1]));
				break;
			case "result" :
				pResult();
				break;
			}
		}
		
		public void pAddUser(String cthid, String name) {
			users.add(new User(Integer.parseInt(cthid), name));
		}
		
		public void pExit(int cthid) {
			ListIterator<User> iter = users.listIterator();
			while (iter.hasNext()) {
				User u = iter.next();
				if (u.cthid == cthid) {
					iter.remove();
					break;
				}
			}
		}
		
		public void pDie(int cthid) {
			users.get(cthid).isDead = true;
		}
		
		public void pResult() {
			// 게임 결과 출력
			return;
		}
	}
}

class User {
	public int cthid;
	public String name;
	public boolean isDead;
	
	
	public User(int cthid, String name) {
		this.cthid = cthid;
		this.name = name;
	}
}
