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
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.CYAN);
		panel_1.setBounds(216, 25, 58, 60);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton reset = new JButton(new ImageIcon("C:\\Users\\User\\eclipse-workspace\\testest\\Image\\rabbit.png"));
		reset.setText("Normalreset");
		reset.setBounds(0, 0, 62, 60);
		panel_1.add(reset);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.YELLOW);
		panel_2.setBounds(631, 23, 167, 62);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.PINK);
		panel_3.setBounds(12, 112, 500, 375);
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(new GridLayout(15,20));
		
		JLabel lblNewLabel = new JLabel(String.valueOf(score));
		lblNewLabel.setBounds(621, 145, 167, 62);
		frame.getContentPane().add(lblNewLabel);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 31));
		
		JPanel panel_2_2 = new JPanel();
		panel_2_2.setLayout(null);
		panel_2_2.setBackground(Color.YELLOW);
		panel_2_2.setBounds(621, 357, 167, 60);
		frame.getContentPane().add(panel_2_2);
		
		JButton btnNormal = new JButton("Normal");
		btnNormal.setFont(new Font("굴림", Font.PLAIN, 19));
		btnNormal.setBounds(0, 0, 167, 60);
		panel_2_2.add(btnNormal);
		
		JPanel panel_2_2_1 = new JPanel();
		panel_2_2_1.setLayout(null);
		panel_2_2_1.setBackground(Color.YELLOW);
		panel_2_2_1.setBounds(621, 287, 167, 60);
		frame.getContentPane().add(panel_2_2_1);
		
		JButton btnNewButton = new JButton("Easy");
		btnNewButton.setFont(new Font("굴림", Font.PLAIN, 19));
		btnNewButton.setBounds(0, 0, 167, 60);
		panel_2_2_1.add(btnNewButton);
		
		JPanel panel_2_2_2 = new JPanel();
		panel_2_2_2.setLayout(null);
		panel_2_2_2.setBackground(Color.YELLOW);
		panel_2_2_2.setBounds(621, 427, 167, 60);
		frame.getContentPane().add(panel_2_2_2);
		
		JButton btnHard = new JButton("Hard");
		btnHard.setFont(new Font("굴림", Font.PLAIN, 19));
		btnHard.setBounds(0, 0, 167, 60);
		panel_2_2_2.add(btnHard);
		
		JLabel lblNewLabel_2 = new JLabel("Start!");
		lblNewLabel_2.setFont(new Font("굴림", Font.PLAIN, 30));
		lblNewLabel_2.setBounds(621, 217, 167, 60);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("Happy Banny");
		lblNewLabel_1.setBounds(631, 25, 167, 62);
		frame.getContentPane().add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Maiandra GD", Font.PLAIN, 19));
		lblNewLabel_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		
		
		for(int i=0;i<20;i++)
		{
			for(int j=0;j<15;j++)
			{
				but[i][j] = new myButton();
				panel_3.add(but[i][j]);
			}
		}
		
		ActionListener timerAction = new ActionListener() {
            int counter = 0;
            
            @Override
            public void actionPerformed(ActionEvent e) {
                counter++;
                lblNewLabel_2.setText("" + counter);
                lblNewLabel_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
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
		btnHard.addActionListener(new EventHandler());
		btnHard.addActionListener(new ActionListener() {
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
