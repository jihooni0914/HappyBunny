package testest;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.ImageIcon;

public class SingleHardUI {

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
	 * @wbp.parser.entryPoint
	 */
	public SingleHardUI() {
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
		myButton but[][] = new myButton[30][20];
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
		

		
		ImageIcon logo = new ImageIcon("C:\\Users\\User\\eclipse-workspace\\testest\\Image\\test.png");
		Image logoimage = logo.getImage().getScaledInstance(185, 69, Image.SCALE_SMOOTH);
		logo = new ImageIcon(logoimage);

		JLabel logoLabel = new JLabel(logo);
		logoLabel.setFont(new Font("Maiandra GD", Font.PLAIN, 28));
		logoLabel.setBounds(626, 32, 185, 69);
		backgroundLabel.add(logoLabel);
		
		JPanel minePanel = new JPanel();
		minePanel.setBackground(Color.PINK);
		minePanel.setBounds(12, 112, 600, 400);
		backgroundLabel.add(minePanel);
		minePanel.setLayout(new GridLayout(20,30));
		
		JLabel scoreLabel = new JLabel(String.valueOf(score));
		scoreLabel.setBounds(641, 112, 177, 60);
		backgroundLabel.add(scoreLabel);
		scoreLabel.setBackground(Color.WHITE);
		scoreLabel.setFont(new Font("Maiandra GD", Font.PLAIN, 31));
		
		JPanel normalPanel = new JPanel();
		normalPanel.setLayout(null);
		normalPanel.setBackground(Color.YELLOW);
		normalPanel.setBounds(641, 355, 177, 60);
		backgroundLabel.add(normalPanel);
		
		JButton normalBtn = new JButton("Normal");
		normalBtn.setFont(new Font("Maiandra GD", Font.PLAIN, 30));
		normalBtn.setBounds(0, 0, 177, 60);
		normalPanel.add(normalBtn);
		
		JPanel hardPanel = new JPanel();
		hardPanel.setLayout(null);
		hardPanel.setBackground(Color.YELLOW);
		hardPanel.setBounds(641, 452, 177, 60);
		backgroundLabel.add(hardPanel);
		
		JButton hardBtn = new JButton("Hard");
		hardBtn.setFont(new Font("Maiandra GD", Font.PLAIN, 30));
		hardBtn.setBounds(0, 0, 177, 60);
		hardPanel.add(hardBtn);
		
		JLabel timerLabel = new JLabel("Start!");
		timerLabel.setFont(new Font("Maiandra GD", Font.PLAIN, 31));
		timerLabel.setBounds(641, 182, 177, 60);
		backgroundLabel.add(timerLabel);
		
		JPanel easyPanel = new JPanel();
		easyPanel.setBounds(641, 261, 177, 60);
		backgroundLabel.add(easyPanel);
		easyPanel.setLayout(null);
		
		JButton easyBtn = new JButton("Easy");
		easyBtn.setBounds(0, 0, 177, 60);
		easyPanel.add(easyBtn);
		easyBtn.setFont(new Font("Maiandra GD", Font.PLAIN, 30));
		
		ImageIcon imageIcon = new ImageIcon("C:\\Users\\User\\eclipse-workspace\\testest\\Image\\rabbit.png");
		Image image = imageIcon.getImage().getScaledInstance(62, 62, Image.SCALE_SMOOTH);
		imageIcon = new ImageIcon(image);
		
				JButton rabbitBtn = new JButton(imageIcon);
				backgroundLabel.add(rabbitBtn);
				rabbitBtn.setBounds(274, 34, 62, 62);
				rabbitBtn.setVerticalAlignment(SwingConstants.CENTER);
				rabbitBtn.setHorizontalAlignment(SwingConstants.CENTER);
				rabbitBtn.setHorizontalTextPosition(SwingConstants.CENTER);
				rabbitBtn.setVerticalTextPosition(SwingConstants.CENTER);
				rabbitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	   frame.setVisible(false); // 창 안보이게 하기 
            }
        });
				rabbitBtn.addActionListener(new ActionListener() {
				    @Override
				    public void actionPerformed(ActionEvent e) {
				    	SingleHardUI window = new SingleHardUI();
    			window.frame.setVisible(true);
				    }
				});
		
		easyBtn.addActionListener(new EventHandler());
		easyBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false); // 창 안보이게 하기 
            }
        });
		
		
		for(int i=0;i<30;i++)
		{
			for(int j=0;j<20;j++)
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
		normalBtn.addActionListener(new EventHandler());
		normalBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false); // 창 안보이게 하기 
            }
        });
		hardBtn.addActionListener(new EventHandler());
		hardBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false); // 창 안보이게 하기 
            }
        });
	}

}
