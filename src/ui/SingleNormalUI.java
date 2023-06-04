package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SingleNormalUI {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SingleNormalUI window = new SingleNormalUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SingleNormalUI() {
		initialize();
	}
	
	class myButton extends JButton
	{
		private int flagint =0;
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		int score = 10000;
		myButton but[][] = new myButton[20][15];
		frame = new JFrame();
		frame.setBounds(100, 100, 844, 559);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel backgroundLabel = new JLabel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Image image = new ImageIcon("images/farm.jpg").getImage();
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };
		backgroundLabel.setBounds(0, 0, frame.getWidth(), frame.getHeight());
		frame.getContentPane().add(backgroundLabel);
		
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
		
		Board minePanel = new Board();
		minePanel.setBackground(Color.PINK);
		minePanel.setBounds(12, 112, 500, 375);
		backgroundLabel.add(minePanel);
		minePanel.setLayout(new GridLayout(15,20));
		
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
		
		JPanel EasyPanel = new JPanel();
		backgroundLabel.add(EasyPanel);
		EasyPanel.setLayout(null);
		EasyPanel.setBackground(Color.YELLOW);
		EasyPanel.setBounds(623, 259, 167, 60);
		
		JButton EastBtn = new JButton("Easy");
		EastBtn.setFont(new Font("Maiandra GD", Font.PLAIN, 30));
		EastBtn.setBounds(0, 0, 167, 60);
		EasyPanel.add(EastBtn);
		
		JPanel noralPanel = new JPanel();
		backgroundLabel.add(noralPanel);
		noralPanel.setLayout(null);
		noralPanel.setBackground(Color.YELLOW);
		noralPanel.setBounds(623, 341, 167, 60);
		
		JButton notmalBtn = new JButton("Normal");
		notmalBtn.setFont(new Font("Maiandra GD", Font.PLAIN, 30));
		notmalBtn.setBounds(0, 0, 167, 60);
		noralPanel.add(notmalBtn);
		
		JPanel hardPanel = new JPanel();
		backgroundLabel.add(hardPanel);
		hardPanel.setLayout(null);
		hardPanel.setBackground(Color.YELLOW);
		hardPanel.setBounds(623, 424, 167, 60);
		
		JButton hardBtn = new JButton("Hard");
		hardBtn.setFont(new Font("Maiandra GD", Font.PLAIN, 30));
		hardBtn.setBounds(0, 0, 167, 60);
		hardPanel.add(hardBtn);
		hardBtn.addActionListener(new EventHandler());
		hardBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false); // 창 안보이게 하기 
            }
        });
		notmalBtn.addActionListener(new EventHandler());
		notmalBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false); // 창 안보이게 하기 
            }
        });
		
		EastBtn.addActionListener(new EventHandler());
		EastBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false); // 창 안보이게 하기 
            }
        });
		
		
//		for(int i=0;i<20;i++)
//		{
//			for(int j=0;j<15;j++)
//			{
//				but[i][j] = new myButton();
//				minepanel.add(but[i][j]);
//			}
//		}
//		
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
		
        rabbitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	   frame.setVisible(false); // 창 안보이게 하기 
            }
        });
        rabbitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	SingleNormalUI window = new SingleNormalUI();
    			window.frame.setVisible(true);
            }
        });
		
	}
}
