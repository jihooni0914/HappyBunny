package testest;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class SingleEasyUI {

	JFrame frame;

	
	/**
	 * Launch the application.
	 */
	 public static void main(String[] args) {
	        SwingUtilities.invokeLater(() -> {
	            try {
	                SingleEasyUI window = new SingleEasyUI();
	                window.frame.setVisible(true);
	            } catch (Exception e) {
	                e.printStackTrace();
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
	 * @wbp.parser.entryPoint
	 */
	private void initialize() {
		int score = 1234567890;
		myButton but[][] = new myButton[20][15];
		frame = new JFrame();
		frame.setBounds(100, 100, 867, 559);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel backgroundLabel = new JLabel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Image image = new ImageIcon("C:\\\\Users\\\\User\\\\eclipse-workspace\\\\testest\\\\Image\\\\farm.jpg").getImage();
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };
		backgroundLabel.setBounds(0, 0, frame.getWidth(), frame.getHeight());
		frame.getContentPane().add(backgroundLabel);

		
		JPanel logoPanel = new JPanel();
		logoPanel.setBackground(Color.YELLOW);
		logoPanel.setBounds(621, 10, 167, 62);
		backgroundLabel.add(logoPanel);
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
		backgroundLabel.add(minePanel);
		minePanel.setLayout(new GridLayout(10,10));
		
		JLabel scoreLabel = new JLabel(String.valueOf(score));
		scoreLabel.setBounds(621, 112, 179, 66);
		backgroundLabel.add(scoreLabel);
		scoreLabel.setBackground(Color.WHITE);
		scoreLabel.setFont(new Font("Maiandra GD", Font.PLAIN, 31));
		
		JPanel normalpanel = new JPanel();
		normalpanel.setLayout(null);
		normalpanel.setBackground(Color.YELLOW);
		normalpanel.setBounds(621, 346, 167, 69);
		backgroundLabel.add(normalpanel);
		
		JButton btnNormal = new JButton("Normal");
		btnNormal.setFont(new Font("Maiandra GD", Font.PLAIN, 30));
		btnNormal.setBounds(0, 0, 167, 69);
		normalpanel.add(btnNormal);
		
		JPanel EasyPanel = new JPanel();
		EasyPanel.setLayout(null);
		EasyPanel.setBackground(Color.YELLOW);
		EasyPanel.setBounds(621, 267, 167, 69);
		backgroundLabel.add(EasyPanel);
		
		JButton btnNewButton = new JButton("Easy");
		btnNewButton.setFont(new Font("Maiandra GD", Font.PLAIN, 30));
		btnNewButton.setBounds(0, 0, 167, 69);
		EasyPanel.add(btnNewButton);
		
		JPanel hardPanel = new JPanel();
		hardPanel.setLayout(null);
		hardPanel.setBackground(Color.YELLOW);
		hardPanel.setBounds(621, 425, 167, 62);
		backgroundLabel.add(hardPanel);
		
		JButton btnHard = new JButton("Hard");
		btnHard.setBounds(0, 0, 167, 62);
		hardPanel.add(btnHard);
		btnHard.setFont(new Font("Maiandra GD", Font.PLAIN, 30));
		btnHard.addActionListener(new EventHandler());
		btnHard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false); // 창 안보이게 하기 
            }
        });
		
		JLabel timerLabel = new JLabel("Start!");
		timerLabel.setFont(new Font("Maiandra GD", Font.PLAIN, 31));
		timerLabel.setBounds(621, 188, 167, 69);
		backgroundLabel.add(timerLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(194, 34, 59, 62);
		backgroundLabel.add(panel);
		panel.setLayout(null);
		
		JButton rabbitBtn = new JButton(new ImageIcon("C:\\Users\\User\\eclipse-workspace\\testest\\Image\\rabbit.png"));
		rabbitBtn.setBounds(0, 0, 59, 62);
		panel.add(rabbitBtn);
		rabbitBtn.setHorizontalAlignment(SwingConstants.CENTER);
	    rabbitBtn.setVerticalAlignment(SwingConstants.CENTER);
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
        rabbitBtn.addActionListener(new EventHandler());
        rabbitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false); // 창 안보이게 하기 
            }
        });
		
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


