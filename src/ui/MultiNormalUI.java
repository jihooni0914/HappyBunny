package ui;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MultiNormalUI extends JFrame {
	public UserPanel[] users;
	public int cthid = -1;
	public JButton rabbitBtn;
	public Timer timer;
	
	public MultiNormalUI() {
		initialize();
	}
	
	class myButton extends JButton {
		private int flagint =0;
	}
	
	private void initialize() {
		int score = 0;
		myButton but[][] = new myButton[20][15];
		setBounds(100, 100, 844, 559);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel backgroundLabel = new JLabel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Image image = new ImageIcon("images/main.jpg").getImage();
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };
		backgroundLabel.setBounds(0, 0, getWidth(), getHeight());
		getContentPane().add(backgroundLabel);
		
		ImageIcon imageIcon = new ImageIcon("images/rabbit.png");
		Image image = imageIcon.getImage().getScaledInstance(62, 62, Image.SCALE_SMOOTH);
		imageIcon = new ImageIcon(image);

		rabbitBtn = new JButton(imageIcon);
		rabbitBtn.setBounds(224, 35, 62, 62);
		backgroundLabel.add(rabbitBtn);
		rabbitBtn.setVerticalAlignment(SwingConstants.CENTER);
		rabbitBtn.setHorizontalAlignment(SwingConstants.CENTER);
		rabbitBtn.setHorizontalTextPosition(SwingConstants.CENTER);
		rabbitBtn.setVerticalTextPosition(SwingConstants.CENTER);
		
		JPanel minepanel = new JPanel();
		minepanel.setBackground(Color.PINK);
		minepanel.setBounds(12, 112, 500, 375);
		backgroundLabel.add(minepanel);
		minepanel.setLayout(new GridLayout(15,20));
		
		ImageIcon logo = new ImageIcon("images/test.png");
		Image logoimage = logo.getImage().getScaledInstance(185, 69, Image.SCALE_SMOOTH);
		logo = new ImageIcon(logoimage);

		JLabel logoLabel = new JLabel(logo);
		logoLabel.setFont(new Font("Maiandra GD", Font.PLAIN, 28));
		logoLabel.setBounds(626, 32, 185, 69);
		backgroundLabel.add(logoLabel);
		
		JLabel scoreLabel = new JLabel(String.valueOf(score));
		backgroundLabel.add(scoreLabel);
		scoreLabel.setBounds(623, 117, 167, 62);
		scoreLabel.setBackground(Color.WHITE);
		scoreLabel.setFont(new Font("Maiandra GD", Font.PLAIN, 31));
		
		JLabel timerLabel = new JLabel("Waitng...");
		backgroundLabel.add(timerLabel);
		timerLabel.setFont(new Font("Maiandra GD", Font.PLAIN, 31));
		timerLabel.setBounds(623, 189, 167, 60);
		
		
		
		JPanel usersPanel = new JPanel();
		usersPanel.setBackground(new Color(0xf8, 0xb8, 0xd7, 192));
		usersPanel.setLayout(new GridLayout(3, 1, 0, 10));
		usersPanel.setBounds(623, 260, 165, 230);
		usersPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		backgroundLabel.add(usersPanel);
		
		users = new UserPanel[3];
		for (int i = 0; i < 3; i ++) {
			users[i] = new UserPanel(55, 70, i + 1);
			usersPanel.add(users[i]);
		}
		
		
		for(int i=0;i<20;i++)
		{
			for(int j=0;j<15;j++)
			{
				but[i][j] = new myButton();
				minepanel.add(but[i][j]);
			}
		}
		
		ActionListener timerAction = new ActionListener() {
            int counter = 5;
            boolean isStart = false;
            
            @Override
            public void actionPerformed(ActionEvent e) {
            	if (counter == 0) {
            		timerLabel.setText("Start!");
            		isStart = true;
            		counter ++;
            	}
            	else {
            		timerLabel.setText("" + counter);
            		
            		if (!isStart) {
            			counter--;
            		}
            		else {
            			counter++;
            		}
            	}
                timerLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            }
        };
        
        timer = new Timer(1000, timerAction); // 1초마다 실행
//        timer.start();
		
	}
}


