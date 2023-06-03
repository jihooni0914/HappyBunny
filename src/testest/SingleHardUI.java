package testest;

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
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(260, 39, 62, 60);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton reset = new JButton(new ImageIcon("C:\\Users\\User\\eclipse-workspace\\testest\\Image\\rabbit.png"));
		reset.setText("Hardreset");
		reset.setBounds(0, 0, 58, 60);
		panel_1.add(reset);
		reset.setIcon(new ImageIcon("C:\\Users\\User\\eclipse-workspace\\testest\\Image\\rabbit.png"));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.YELLOW);
		panel_2.setBounds(621, 10, 167, 62);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Happy Banny");
		lblNewLabel_1.setFont(new Font("Maiandra GD", Font.PLAIN, 19));
		lblNewLabel_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 0, 167, 62);
		panel_2.add(lblNewLabel_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.PINK);
		panel_3.setBounds(12, 112, 600, 400);
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(new GridLayout(20,30));
		
		JLabel lblNewLabel = new JLabel(String.valueOf(score));
		lblNewLabel.setBounds(641, 112, 177, 60);
		frame.getContentPane().add(lblNewLabel);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 31));
		
		JPanel panel_2_2 = new JPanel();
		panel_2_2.setLayout(null);
		panel_2_2.setBackground(Color.YELLOW);
		panel_2_2.setBounds(641, 355, 177, 60);
		frame.getContentPane().add(panel_2_2);
		
		JButton btnNormal = new JButton("Normal");
		btnNormal.setFont(new Font("굴림", Font.PLAIN, 19));
		btnNormal.setBounds(0, 0, 177, 60);
		panel_2_2.add(btnNormal);
		
		JPanel panel_2_2_2 = new JPanel();
		panel_2_2_2.setLayout(null);
		panel_2_2_2.setBackground(Color.YELLOW);
		panel_2_2_2.setBounds(641, 452, 177, 60);
		frame.getContentPane().add(panel_2_2_2);
		
		JButton btnHard = new JButton("Hard");
		btnHard.setFont(new Font("굴림", Font.PLAIN, 19));
		btnHard.setBounds(0, 0, 177, 60);
		panel_2_2_2.add(btnHard);
		
		JLabel lblNewLabel_2 = new JLabel("Start!");
		lblNewLabel_2.setFont(new Font("굴림", Font.PLAIN, 30));
		lblNewLabel_2.setBounds(641, 182, 177, 60);
		frame.getContentPane().add(lblNewLabel_2);
		
		JPanel panel = new JPanel();
		panel.setBounds(641, 261, 177, 60);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Easy");
		btnNewButton.setBounds(0, 0, 177, 60);
		panel.add(btnNewButton);
		btnNewButton.setFont(new Font("굴림", Font.PLAIN, 19));
		
		btnNewButton.addActionListener(new EventHandler());
		btnNewButton.addActionListener(new ActionListener() {
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
