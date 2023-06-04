package client;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.LinkedList;
import java.util.ListIterator;
import javax.swing.Timer;

import ui.*;

public class ClientStarter {
	private static int PORT = 4885;
	private static String HOST = "localhost";
	private Socket socket;
	public PrintWriter writer;
	private LinkedList<User> users;
	
	private Login loginUI;
	private MultiNormalUI multiNormalUI;
	
	
	public static void main(String[] args) {
		new ClientStarter();
	}
	
	public ClientStarter() {
		this.users = new LinkedList<>();
		
		init();
		setListeners();
		setUIVisible();
	}
	
	private void init() {
		loginUI = new Login();
		multiNormalUI = new MultiNormalUI(this);
	}
	
	private void setListeners() {
		loginUI.multi.button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				connectServer();
				String username = loginUI.multi.textbox.getText();
				writer.println("login/" + username);
				multiNormalUI.setVisible(true);
			}
		});
		
		multiNormalUI.rabbitBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				writer.println("boom");
				multiNormalUI.timer.stop();
			}
		});
	}
	
	private void setUIVisible() {
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
		
		private void eventManager(String[] event) {
			switch (event[0]) {
			case "connect" :
//				pConnect(Integer.parseInt(event[1]));
				break;
			case "user" :
				pAddUser(event[1], event[2]);
				break;
			case "exit" :
				pExit(Integer.parseInt(event[1]));
				break;
			case "start" :
				pStart();
				break;
			case "die" :
				pDie(Integer.parseInt(event[1]));
				break;
			case "result" :
				pEnd();
				break;
			}
		}
		
//		private void pConnect(int cthid) {
//			System.out.println("Client ID: " + cthid);
//			multiNormalUI.cthid = cthid;
//			multiNormalUI.rabbitBtn.addActionListener(new ActionListener() {
//				@Override
//				public void actionPerformed(ActionEvent e) {
//					writer.println("boom");
//					multiNormalUI.timer.stop();
//				}
//			});
//		}
		
		private void pAddUser(String cthid, String name) {
			users.add(new User(Integer.parseInt(cthid), name));
			
			for (int i = 0; i < 3; i ++) {
				UserPanel up = multiNormalUI.users[i];
				if (!up.isAlive) {
					up.userIdLabel.setText(name);
					up.cthid = Integer.parseInt(cthid);
					up.setBackground(Color.green);
					up.isAlive = true;
					return;
				}
			}
		}
		
		private void pExit(int cthid) {
			ListIterator<User> iter = users.listIterator();
			while (iter.hasNext()) {
				User u = iter.next();
				if (u.cthid == cthid) {
					iter.remove();
					break;
				}
			}
			
			for (int i = 0; i < 3; i ++) {
				UserPanel up = multiNormalUI.users[i];
				if (up.cthid == cthid) {
					up.userIdLabel.setText("No User");
					up.cthid = -1;
					up.setBackground(null);
					up.isAlive = false;
					return;				
				}
			}
		}
		
		private void pStart() {
			multiNormalUI.timer.start();
		}
		
		private void pDie(int cthid) {
			for (int i = 0; i < 3; i ++) {
				UserPanel up = multiNormalUI.users[i];
				if (up.cthid == cthid) {
					up.setBackground(Color.red);
					return;
				}
			}
			
		}
		
		private void pEnd() {
			// 게임 결과 출력
			
            Timer timer = new Timer(5000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    multiNormalUI.dispose(); // 프레임을 닫고 자원을 해제합니다.
                    multiNormalUI.setVisible(false);
                    System.exit(0); // JVM을 종료합니다.
                }
            });
            timer.setRepeats(false); // 한 번만 실행되도록 설정
            timer.start();
			return;
		}
	}
}

class User {
	public int cthid;
	public String name;
	public int score;
	public int time;
	
	
	public User(int cthid, String name) {
		this.cthid = cthid;
		this.name = name;
		this.score = 0;
	}
}
