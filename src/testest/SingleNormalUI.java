package testest;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JToggleButton;
import javax.swing.Timer;

import java.awt.GridLayout;
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
		
		JPanel rabbitbtn = new JPanel();
		rabbitbtn.setBackground(Color.CYAN);
		rabbitbtn.setBounds(216, 25, 58, 60);
		frame.getContentPane().add(rabbitbtn);
		rabbitbtn.setLayout(null);
		
		JButton reset = new JButton(new ImageIcon("C:\\Users\\User\\eclipse-workspace\\testest\\Image\\rabbit.png"));
		reset.setText("Normalreset");
		reset.setBounds(0, 0, 62, 60);
		rabbitbtn.add(reset);
		
		JPanel minepanel = new JPanel();
		minepanel.setBackground(Color.PINK);
		minepanel.setBounds(12, 112, 500, 375);
		frame.getContentPane().add(minepanel);
		minepanel.setLayout(new GridLayout(15,20));
		
		JLabel scoreLabel = new JLabel(String.valueOf(score));
		scoreLabel.setBounds(621, 145, 167, 62);
		frame.getContentPane().add(scoreLabel);
		scoreLabel.setBackground(Color.WHITE);
		scoreLabel.setFont(new Font("굴림", Font.PLAIN, 31));
		
		JPanel noralPanel = new JPanel();
		noralPanel.setLayout(null);
		noralPanel.setBackground(Color.YELLOW);
		noralPanel.setBounds(621, 357, 167, 60);
		frame.getContentPane().add(noralPanel);
		
		JButton notmalBtn = new JButton("Normal");
		notmalBtn.setFont(new Font("굴림", Font.PLAIN, 19));
		notmalBtn.setBounds(0, 0, 167, 60);
		noralPanel.add(notmalBtn);
		
		JPanel EasyPanel = new JPanel();
		EasyPanel.setLayout(null);
		EasyPanel.setBackground(Color.YELLOW);
		EasyPanel.setBounds(621, 287, 167, 60);
		frame.getContentPane().add(EasyPanel);
		
		JButton EastBtn = new JButton("Easy");
		EastBtn.setFont(new Font("굴림", Font.PLAIN, 19));
		EastBtn.setBounds(0, 0, 167, 60);
		EasyPanel.add(EastBtn);
		
		JPanel hardPanel = new JPanel();
		hardPanel.setLayout(null);
		hardPanel.setBackground(Color.YELLOW);
		hardPanel.setBounds(621, 427, 167, 60);
		frame.getContentPane().add(hardPanel);
		
		JButton hardBtn = new JButton("Hard");
		hardBtn.setFont(new Font("굴림", Font.PLAIN, 19));
		hardBtn.setBounds(0, 0, 167, 60);
		hardPanel.add(hardBtn);
		
		JLabel timerLabel = new JLabel("Start!");
		timerLabel.setFont(new Font("굴림", Font.PLAIN, 30));
		timerLabel.setBounds(621, 217, 167, 60);
		frame.getContentPane().add(timerLabel);
		
		JPanel logoPanel = new JPanel();
		logoPanel.setBounds(631, 25, 167, 62);
		frame.getContentPane().add(logoPanel);
		logoPanel.setLayout(null);
		
		JLabel logoLabel = new JLabel("Happy Banny");
		logoLabel.setBounds(0, 0, 167, 62);
		logoPanel.add(logoLabel);
		logoLabel.setFont(new Font("Maiandra GD", Font.PLAIN, 19));
		logoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		
		
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
		
		EastBtn.addActionListener(new EventHandler());
		EastBtn.addActionListener(new ActionListener() {
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
