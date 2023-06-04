package ui;

import javax.swing.*;

import client.ClientStarter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MultiNormalUI extends JFrame {
	public UserPanel[] users;
	public int cthid = -1;
	public JButton rabbitBtn;
	public Timer timer;
	public ClientStarter cs;
	
	private int ROWS = 15;
	private int COLS = 20;
	private boolean[][] visited = new boolean[ROWS][COLS];
	JButton but[][] = new JButton[ROWS][COLS];
	private char[][] board = new char[ROWS][COLS];
	private int remainingCells;
	private static final int MINES = 40;
	
	private int score;
	private JLabel scoreLabel;
	
	public MultiNormalUI(ClientStarter cs) {
		this.cs = cs;
		initialize();
	}
	
	private void initialize() {
		for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                board[i][j] = '-';
                visited[i][j] = false;
            }
        }
		placeMines();
		setCellText();
		printBoard();
		remainingCells = ROWS * COLS - MINES;
		
		score = 0;
		setBounds(100, 100, 1000, 700);
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

		rabbitBtn = new JButton(imageIcon);
		rabbitBtn.setBounds(265, 35, 62, 62);
		backgroundLabel.add(rabbitBtn);
		rabbitBtn.setVerticalAlignment(SwingConstants.CENTER);
		rabbitBtn.setHorizontalAlignment(SwingConstants.CENTER);
		rabbitBtn.setHorizontalTextPosition(SwingConstants.CENTER);
		rabbitBtn.setVerticalTextPosition(SwingConstants.CENTER);
		
		JPanel minePanel = new JPanel();
		minePanel.setBackground(Color.PINK);
		minePanel.setBounds(12, 130, 800, 500);
		backgroundLabel.add(minePanel);
		minePanel.setLayout(new GridLayout(ROWS, COLS));
		
		ImageIcon logo = new ImageIcon("images/test.png");
		Image logoimage = logo.getImage().getScaledInstance(185, 69, Image.SCALE_SMOOTH);
		logo = new ImageIcon(logoimage);

		JLabel logoLabel = new JLabel(logo);
		logoLabel.setFont(new Font("Maiandra GD", Font.PLAIN, 28));
		logoLabel.setBounds(770, 36, 185, 69);
		backgroundLabel.add(logoLabel);
		
		scoreLabel = new JLabel(String.valueOf(score));
		backgroundLabel.add(scoreLabel);
		scoreLabel.setBounds(824, 130, 150, 60);
		scoreLabel.setBackground(Color.WHITE);
		scoreLabel.setFont(new Font("Maiandra GD", Font.PLAIN, 31));
	    scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel timerLabel = new JLabel("Waitng...");
		backgroundLabel.add(timerLabel);
		timerLabel.setFont(new Font("Maiandra GD", Font.PLAIN, 31));
		timerLabel.setBounds(824, 202, 150, 60);
		
		
		
		JPanel usersPanel = new JPanel();
		usersPanel.setBackground(new Color(0xf8, 0xb8, 0xd7, 192));
		usersPanel.setLayout(new GridLayout(3, 1, 0, 10));
		usersPanel.setBounds(820, 300, 165, 230);
		usersPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		backgroundLabel.add(usersPanel);
		
		users = new UserPanel[3];
		for (int i = 0; i < 3; i ++) {
			users[i] = new UserPanel(55, 70, i + 1);
			usersPanel.add(users[i]);
		}
		
		

		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {
				JButton button = new JButton();
				button.setPreferredSize(new Dimension(50, 50));
				button.addActionListener(new ButtonListener(i, j));
				button.addMouseListener(new MouseListener(i, j));
				
				button.setFont(new Font("Maiandra GD", Font.PLAIN, 11));
				button.setForeground(Color.CYAN);
				but[i][j] = button;
				minePanel.add(button);
			}
		}
		
		ActionListener timerAction = new ActionListener() {
            int counter = 5;
            boolean isStart = false;
            
            @Override
            public void actionPerformed(ActionEvent e) {
            	if (counter == 0) {
            		timerLabel.setText("Start!");
            		isStart = true;
            		counter ++;
            	}
            	else {
            		timerLabel.setText("" + counter);
            		
            		if (!isStart) {
            			counter--;
            		}
            		else {
            			counter++;
            		}
            	}
                timerLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            }
        };
        
        timer = new Timer(1000, timerAction); // 1초마다 실행
//        timer.start();
		
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
	
	private class MouseListener extends MouseAdapter {
		private int row;
		private int col;
		private boolean color_toggle;
		
		public MouseListener(int row, int col) {
			this.row = row;
			this.col = col;
			color_toggle = false;
		}
		

	    @Override
	    public void mouseClicked(MouseEvent e) {
	        if (e.getButton() == MouseEvent.BUTTON3 && but[row][col].isEnabled()) {
	        	
	        	if (color_toggle) {
	        		but[row][col].setBackground(new Color(0xb9, 0xf0, 0xf8));
	        		color_toggle = false;
	        		but[row][col].setEnabled(true);
	        	}
	        	else {
	        		but[row][col].setBackground(Color.PINK);
	        		color_toggle = true;
	        	}
	        }
	    }
	}
	

	private void revealCell(int row, int col) {
		if (row < 0 || row >= ROWS || col < 0 || col >= COLS || visited[row][col])
			return;

		visited[row][col] = true;
		but[row][col].setEnabled(false);
		but[row][col].setText(Character.toString(board[row][col]));
		remainingCells--;

		if (board[row][col] == '0') {
			but[row][col].setText("");
			score++;
			scoreLabel.setText(Integer.toString(score));
			revealNeighbors(row, col);
		}
		else if (board[row][col] >= '1' && board[row][col] <= '9') {
			score++;
			scoreLabel.setText(Integer.toString(score));
		}
		else if (board[row][col] == '*') {
			gameOver(false);
		}
		else if (remainingCells == 0) {
			gameOver(true);
		}
	}

	private void revealNeighbors(int row, int col) {
		for (int i = row - 1; i <= row + 1; i++) {
		    for (int j = col - 1; j <= col + 1; j++) {
		        if (i >= 0 && i < ROWS && j >= 0 && j < COLS) {
		        	if (board[i][j] != '*') {
		        		revealCell(i, j);		        		
		        	}
		        }
		    }
		}
	
	}
	
	private void printBoard() {
		for (int i = 0; i < ROWS; i ++) {
			for (int j = 0; j < COLS; j ++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

	private void placeMines() {
		int count = 0;
		while (count < MINES) {
			int x = (int) (Math.random() * ROWS);
			int y = (int) (Math.random() * COLS);
			if (board[x][y] != '*') {
				board[x][y] = '*';
				count++;
			}
		}
	}
	
	private void setCellText() {
		for (int i = 0; i < ROWS; i ++) {
			for (int j = 0; j < COLS; j ++) {
				// mine 있는 cell은 건너뛰기
				if (board[i][j] == '*') {
					continue;
				}
				board[i][j] = countMines(i, j);
			}
		}
	}

	private char countMines(int row, int col) {
		int count = 0;
		
		for (int i = row - 1; i <= row + 1; i ++) {
			for (int j = col - 1; j <= col + 1; j ++) {
				// 범위 벗어나면 continue
				if (i < 0 || i >= ROWS || j < 0 || j >= COLS) {
					continue;
				}
				
				// 폭탄 있으면 count
				if (board[i][j] == '*') {
					count ++;
				}
			}
		}
		
		return (char)('0' + count);
	}
	
	private void gameOver(boolean win) {
		if (win) {
            JOptionPane.showMessageDialog(this, "Congratulations! You won the game.");
        } else {
            JOptionPane.showMessageDialog(this, "Game over! You hit a mine.");
        }
		
		cs.writer.println("boom/" + score);
		timer.stop();
	}
}


