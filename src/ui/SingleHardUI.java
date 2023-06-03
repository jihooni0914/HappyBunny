package ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
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
		
		JPanel rabbitPanel = new JPanel();
		rabbitPanel.setBackground(new Color(255, 255, 255));
		rabbitPanel.setBounds(260, 39, 62, 60);
		frame.getContentPane().add(rabbitPanel);
		rabbitPanel.setLayout(null);
		
		JButton reset = new JButton(new ImageIcon("C:\\Users\\User\\eclipse-workspace\\testest\\Image\\rabbit.png"));
		reset.setText("Hardreset");
		reset.setBounds(0, 0, 58, 60);
		rabbitPanel.add(reset);
		reset.setIcon(new ImageIcon("C:\\Users\\User\\eclipse-workspace\\testest\\Image\\rabbit.png"));
		
		JPanel logoPanel = new JPanel();
		logoPanel.setBackground(Color.YELLOW);
		logoPanel.setBounds(621, 10, 167, 62);
		frame.getContentPane().add(logoPanel);
		logoPanel.setLayout(null);
		
		JLabel logoLabel = new JLabel("Happy Banny");
		logoLabel.setFont(new Font("Maiandra GD", Font.PLAIN, 19));
		logoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		logoLabel.setBounds(0, 0, 167, 62);
		logoPanel.add(logoLabel);
		
		JPanel minePanel = new JPanel();
		minePanel.setBackground(Color.PINK);
		minePanel.setBounds(12, 112, 600, 400);
		frame.getContentPane().add(minePanel);
		minePanel.setLayout(new GridLayout(20,30));
		
		JLabel scoreLabel = new JLabel(String.valueOf(score));
		scoreLabel.setBounds(641, 112, 177, 60);
		frame.getContentPane().add(scoreLabel);
		scoreLabel.setBackground(Color.WHITE);
		scoreLabel.setFont(new Font("굴림", Font.PLAIN, 31));
		
		JPanel normalPanel = new JPanel();
		normalPanel.setLayout(null);
		normalPanel.setBackground(Color.YELLOW);
		normalPanel.setBounds(641, 355, 177, 60);
		frame.getContentPane().add(normalPanel);
		
		JButton normalBtn = new JButton("Normal");
		normalBtn.setFont(new Font("굴림", Font.PLAIN, 19));
		normalBtn.setBounds(0, 0, 177, 60);
		normalPanel.add(normalBtn);
		
		JPanel hardPanel = new JPanel();
		hardPanel.setLayout(null);
		hardPanel.setBackground(Color.YELLOW);
		hardPanel.setBounds(641, 452, 177, 60);
		frame.getContentPane().add(hardPanel);
		
		JButton hardBtn = new JButton("Hard");
		hardBtn.setFont(new Font("굴림", Font.PLAIN, 19));
		hardBtn.setBounds(0, 0, 177, 60);
		hardPanel.add(hardBtn);
		
		JLabel timerLabel = new JLabel("Start!");
		timerLabel.setFont(new Font("굴림", Font.PLAIN, 30));
		timerLabel.setBounds(641, 182, 177, 60);
		frame.getContentPane().add(timerLabel);
		
		JPanel easyPanel = new JPanel();
		easyPanel.setBounds(641, 261, 177, 60);
		frame.getContentPane().add(easyPanel);
		easyPanel.setLayout(null);
		
		JButton easyBtn = new JButton("Easy");
		easyBtn.setBounds(0, 0, 177, 60);
		easyPanel.add(easyBtn);
		easyBtn.setFont(new Font("굴림", Font.PLAIN, 19));
		
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
		reset.addActionListener(new EventHandler());
		reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false); // 창 안보이게 하기 
            }
        });
	}

}
