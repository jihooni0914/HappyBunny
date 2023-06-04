package ui;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MultiNormalUI extends JFrame {
	
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

		JButton rabbitBtn = new JButton(imageIcon);
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
		
		JLabel timerLabel = new JLabel("Start!");
		backgroundLabel.add(timerLabel);
		timerLabel.setFont(new Font("Maiandra GD", Font.PLAIN, 31));
		timerLabel.setBounds(623, 189, 167, 60);
		
		
		JPanel usersPanel = new JPanel();
		usersPanel.setBackground(new Color(0xf8, 0xb8, 0xd7, 192));
		usersPanel.setLayout(new GridLayout(3, 1, 0, 10));
		usersPanel.setBounds(623, 260, 165, 230);
		usersPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		backgroundLabel.add(usersPanel);
		
		UserPanel userPanel1 = new UserPanel(55, 70, 1);
		UserPanel userPanel2 = new UserPanel(55, 70, 2);
		UserPanel userPanel3 = new UserPanel(55, 70, 3);
		
		usersPanel.add(userPanel1);
		usersPanel.add(userPanel2);
		usersPanel.add(userPanel3);
		
		for(int i=0;i<20;i++)
		{
			for(int j=0;j<15;j++)
			{
				but[i][j] = new myButton();
				minepanel.add(but[i][j]);
			}
		}
		
		ActionListener timerAction = new ActionListener() {
            int counter = 0;
            
            @Override
            public void actionPerformed(ActionEvent e) {
                counter++;
                timerLabel.setText("" + counter);
                timerLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            }
        };
        
        Timer timer = new Timer(1000, timerAction); // 1초마다 실행
        timer.start();
		
	}
}

class UserPanel extends JPanel {
	public UserPanel(int x, int y, int usernum) {
		setLayout(null);
//		setBackground(Color.green);
		
		ImageIcon userIcon = new ImageIcon("images/user" + usernum + ".png");
		userIcon = new ImageIcon(userIcon.getImage().getScaledInstance(x, y, Image.SCALE_SMOOTH));
		JLabel userIconLabel = new JLabel(userIcon);
		userIconLabel.setBounds(0, 0, x, y);
		userIconLabel.setVerticalAlignment(JLabel.CENTER);
		
//		JLabel userIdLabel = new JLabel("User" + usernum);
		JLabel userIdLabel = new JLabel("No User");
		userIdLabel.setBounds(x + 10, 0, 2 * x, y - 10);
		userIdLabel.setVerticalAlignment(JLabel.CENTER);
		userIdLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		add(userIconLabel);
		add(userIdLabel);
	}
}
