package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class SingleNormalUI {

	JFrame frame;

	private boolean[][] visited = new boolean[20][15];
	JButton but[][] = new JButton[20][15];
	private char[][] board = new char[20][15];
	private int remainingCells;
	private static final int MINES = 15;

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

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 15; j++) {
                board[i][j] = '-';
                visited[i][j] = false;
            }
        }
		placeMines();
		remainingCells = 20 * 15 - MINES;
		
		

		int score = 10000;

		frame = new JFrame();
		frame.setBounds(100, 100, 844, 559);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel backgroundLabel = new JLabel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Image image = new ImageIcon("images/main.jpg")
						.getImage();
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

		JPanel minepanel = new JPanel();
		minepanel.setBackground(Color.PINK);
		minepanel.setBounds(12, 112, 500, 375);
		backgroundLabel.add(minepanel);
		minepanel.setLayout(new GridLayout(15, 20));

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

		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 15; j++) {
				JButton button = new JButton();
				button.setPreferredSize(new Dimension(50, 50));
				button.addActionListener(new ButtonListener(i, j));
				but[i][j] = button;
				minepanel.add(button);
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

	private class ButtonListener implements ActionListener {
		private int row;
		private int col;

		public ButtonListener(int row, int col) {
			this.row = row;
			this.col = col;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			revealCell(row, col);
		}
	}

	private void revealCell(int row, int col) {
		if (row < 0 || row >= 20 || col < 0 || col >= 15 || visited[row][col])
			return;

		visited[row][col] = true;
		but[row][col].setEnabled(false);
		but[row][col].setText(Character.toString(board[row][col]));
		remainingCells--;

		if (board[row][col] == '0') {
			revealNeighbors(row, col);
		}
		
		if (board[row][col] == '*') {
			gameOver(false);
		} else if (remainingCells == 0) {
			gameOver(true);
		}
	}

	private void revealNeighbors(int row, int col) {
		for (int i = row - 1; i <= row + 1; i++) {
		    for (int j = col - 1; j <= col + 1; j++) {
		        if (i >= 0 && i < 20 && j >= 0 && j < 15) {
		            revealCell(i, j);
		        }
		    }
		}
	}

	private void placeMines() {
		int count = 0;
		while (count < MINES) {
			int x = (int) (Math.random() * 20);
			int y = (int) (Math.random() * 15);
			if (board[x][y] != '*') {
				board[x][y] = '*';
				count++;
			}
		}
	}

	private void gameOver(boolean win) {
		if (win) {
            JOptionPane.showMessageDialog(frame, "Congratulations! You won the game.");
        } else {
            JOptionPane.showMessageDialog(frame, "Game over! You hit a mine.");
        }
	}
}
