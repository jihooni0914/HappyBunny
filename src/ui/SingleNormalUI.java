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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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

   private int ROWS = 15;
   private int COLS = 20;
   private boolean[][] visited = new boolean[ROWS][COLS];
   JButton but[][] = new JButton[ROWS][COLS];
   private char[][] board = new char[ROWS][COLS];
   private int remainingCells;
   private static final int MINES = 45;

   
	private int score;
	private JLabel scoreLabel;
	
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

      frame = new JFrame();
      frame.setBounds(100, 100, 1000, 700);
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

//      JButton rabbitBtn = new JButton(imageIcon);
//      rabbitBtn.setBounds(224, 35, 62, 62);
//      backgroundLabel.add(rabbitBtn);
//      rabbitBtn.setVerticalAlignment(SwingConstants.CENTER);
//      rabbitBtn.setHorizontalAlignment(SwingConstants.CENTER);
//      rabbitBtn.setHorizontalTextPosition(SwingConstants.CENTER);
//      rabbitBtn.setVerticalTextPosition(SwingConstants.CENTER);
//   
//      
//      JPanel minePanel = new JPanel();
//      minePanel.setBackground(Color.PINK);
//      minePanel.setBounds(12, 112, 500, 375);
////      minePanel.setBounds(12, 112, 1000, 750);
//      backgroundLabel.add(minePanel);
//      minePanel.setLayout(new GridLayout(ROWS,COLS));
      
        JPanel minePanel = new JPanel();
//        frame.getContentPane().add(minePanel);
        backgroundLabel.add(minePanel);
        minePanel.setBackground(Color.PINK);
        minePanel.setBounds(12, 130, 800, 500);
        minePanel.setLayout(new GridLayout(ROWS,COLS));
      
      ImageIcon logo = new ImageIcon("images/test.png");
       Image logoimage = logo.getImage().getScaledInstance(185, 69, Image.SCALE_SMOOTH);
       logo = new ImageIcon(logoimage);
   
      JPanel EasyPanel = new JPanel();
//      frame.getContentPane().add(EasyPanel);
      backgroundLabel.add(EasyPanel);
      EasyPanel.setLayout(null);
      EasyPanel.setBackground(Color.YELLOW);
      EasyPanel.setBounds(824, 305, 150, 75);

         JButton EastBtn = new JButton("Easy");
         EastBtn.setFont(new Font("Maiandra GD", Font.PLAIN, 30));
         EastBtn.setBounds(0, 0, 150, 75);
         EasyPanel.add(EastBtn);
         EastBtn.addActionListener(new EventHandler());
         EastBtn.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 frame.setVisible(false); // 창 안보이게 하기 
             }
         });

         JPanel hardPanel = new JPanel();
//         frame.getContentPane().add(hardPanel);
         backgroundLabel.add(hardPanel);
         hardPanel.setLayout(null);
         hardPanel.setBackground(Color.YELLOW);
         hardPanel.setBounds(824, 555, 150, 75);

         JButton hardBtn = new JButton("Hard");
         hardBtn.setFont(new Font("Maiandra GD", Font.PLAIN, 30));
         hardBtn.setBounds(0, 0, 150, 75);
         hardPanel.add(hardBtn);
         
         hardBtn.addActionListener(new EventHandler());
         hardBtn.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 frame.setVisible(false); // 창 안보이게 하기 
             }
         });

         JPanel noralPanel = new JPanel();
//         frame.getContentPane().add(noralPanel);
         backgroundLabel.add(noralPanel);
         noralPanel.setLayout(null);
         noralPanel.setBackground(Color.YELLOW);
         noralPanel.setBounds(824, 429, 150, 75);

         JButton notmalBtn = new JButton("Normal");
         notmalBtn.setFont(new Font("Maiandra GD", Font.PLAIN, 30));
         notmalBtn.setBounds(0, 0, 150, 75);
         noralPanel.add(notmalBtn);
         
         notmalBtn.addActionListener(new EventHandler());
         notmalBtn.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 frame.setVisible(false); // 창 안보이게 하기 
             }
         });

         JButton rabbitBtn = new JButton(imageIcon);
//         frame.getContentPane().add(rabbitBtn);
         backgroundLabel.add(rabbitBtn);
         rabbitBtn.setBounds(373, 36, 62, 62);
         rabbitBtn.setVerticalAlignment(SwingConstants.CENTER);
         rabbitBtn.setHorizontalAlignment(SwingConstants.CENTER);
         rabbitBtn.setHorizontalTextPosition(SwingConstants.CENTER);
         rabbitBtn.setVerticalTextPosition(SwingConstants.CENTER);

         JLabel logoLabel = new JLabel(logo);
//         frame.getContentPane().add(logoLabel);
         backgroundLabel.add(logoLabel);
         logoLabel.setFont(new Font("Maiandra GD", Font.PLAIN, 28));
         logoLabel.setBounds(770, 36, 185, 69);

         scoreLabel = new JLabel(String.valueOf(score));
//         frame.getContentPane().add(scoreLabel);
         backgroundLabel.add(scoreLabel);
         scoreLabel.setBounds(824, 130, 150, 62);
         scoreLabel.setBackground(Color.WHITE);
         scoreLabel.setFont(new Font("Maiandra GD", Font.PLAIN, 31));
         scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);


         JLabel timerLabel = new JLabel("Start!");
//         frame.getContentPane().add(timerLabel);
         backgroundLabel.add(timerLabel);
         timerLabel.setFont(new Font("Maiandra GD", Font.PLAIN, 31));
         timerLabel.setBounds(824, 202, 150, 60);
         


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
      for (int i = 0; i < ROWS; i++) {
         for (int j = 0; j < COLS; j++) {
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
      for (int i = 0; i < ROWS; i++) {
         for (int j = 0; j < COLS; j++) {
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

      for (int i = row - 1; i <= row + 1; i++) {
         for (int j = col - 1; j <= col + 1; j++) {
            // 범위 벗어나면 continue
            if (i < 0 || i >= ROWS || j < 0 || j >= COLS) {
               continue;
            }

            // 폭탄 있으면 count
            if (board[i][j] == '*') {
               count++;
            }
         }
      }

      return (char) ('0' + count);
   }

   private void gameOver(boolean win) {
      if (win) {
         JOptionPane.showMessageDialog(frame, "Congratulations! You won the game.");
      } else {
         JOptionPane.showMessageDialog(frame, "Game over! You hit a mine.");
      }
   }
}