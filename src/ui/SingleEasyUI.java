package ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.Icon;

public class SingleEasyUI {

	JFrame frame;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SingleEasyUI window = new SingleEasyUI();
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
	public SingleEasyUI() {
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
		int score = 1234567890;
		myButton but[][] = new myButton[20][15];
		frame = new JFrame();
		frame.setBounds(100, 100, 867, 559);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
	
		
		JPanel logoPanel = new JPanel();
		logoPanel.setBackground(Color.YELLOW);
		logoPanel.setBounds(621, 10, 167, 62);
		frame.getContentPane().add(logoPanel);
		logoPanel.setLayout(null);
		
		JLabel logoLabel = new JLabel("Happy Banny");
		logoLabel.setBackground(new Color(255, 255, 255));
		logoLabel.setFont(new Font("Maiandra GD", Font.PLAIN, 19));
		logoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		logoLabel.setBounds(0, 0, 167, 62);
		logoPanel.add(logoLabel);
		
		JPanel minePanel = new JPanel();
		minePanel.setBackground(new Color(255, 255, 255));
		minePanel.setBounds(12, 112, 500, 375);
		frame.getContentPane().add(minePanel);
		minePanel.setLayout(new GridLayout(10,10));
		
		JLabel scoreLabel = new JLabel(String.valueOf(score));
		scoreLabel.setBounds(621, 112, 179, 66);
		frame.getContentPane().add(scoreLabel);
		scoreLabel.setBackground(Color.WHITE);
		scoreLabel.setFont(new Font("Maiandra GD", Font.PLAIN, 31));
		
		JPanel normalpanel = new JPanel();
		normalpanel.setLayout(null);
		normalpanel.setBackground(Color.YELLOW);
		normalpanel.setBounds(621, 346, 167, 69);
		frame.getContentPane().add(normalpanel);
		
		JButton btnNormal = new JButton("Normal");
		btnNormal.setFont(new Font("굴림", Font.PLAIN, 19));
		btnNormal.setBounds(0, 0, 167, 69);
		normalpanel.add(btnNormal);
		
		JPanel EasyPanel = new JPanel();
		EasyPanel.setLayout(null);
		EasyPanel.setBackground(Color.YELLOW);
		EasyPanel.setBounds(621, 267, 167, 69);
		frame.getContentPane().add(EasyPanel);
		
		JButton btnNewButton = new JButton("Easy");
		btnNewButton.setFont(new Font("굴림", Font.PLAIN, 19));
		btnNewButton.setBounds(0, 0, 167, 69);
		EasyPanel.add(btnNewButton);
		
		JPanel hardPanel = new JPanel();
		hardPanel.setLayout(null);
		hardPanel.setBackground(Color.YELLOW);
		hardPanel.setBounds(621, 425, 167, 62);
		frame.getContentPane().add(hardPanel);
		
		JButton btnHard = new JButton("Hard");
		btnHard.setBounds(0, 0, 167, 62);
		hardPanel.add(btnHard);
		btnHard.setFont(new Font("굴림", Font.PLAIN, 19));
		btnHard.addActionListener(new EventHandler());
		btnHard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false); // 창 안보이게 하기 
            }
        });
		
		JLabel timerLabel = new JLabel("Start!");
		timerLabel.setFont(new Font("Maiandra GD", Font.PLAIN, 24));
		timerLabel.setBounds(621, 188, 167, 69);
		frame.getContentPane().add(timerLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(194, 34, 65, 60);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton rabbitBtn = new JButton(new ImageIcon("C:\\Users\\User\\eclipse-workspace\\testest\\Image\\rabbit.png"));
		rabbitBtn.setBounds(0, 0, 55, 60);
		panel.add(rabbitBtn);
		rabbitBtn.setText("Easyreset");
		
		
		
		for(int i=0;i<10;i++)
		{
			for(int j=0;j<10;j++)
			{
				but[i][j] = new myButton();
				minePanel.add(but[i][j]);
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
		
		btnNewButton.addActionListener(new EventHandler());
		btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false); // 창 안보이게 하기 
            }
        });
		btnNormal.addActionListener(new EventHandler());
		btnNormal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false); // 창 안보이게 하기 
            }
        });
	}
}
