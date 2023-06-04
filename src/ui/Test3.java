package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Test3 extends JFrame {
    private static final int SIZE = 10;
    private static final int MINES = 15;
    private JButton[][] buttons = new JButton[SIZE][SIZE];
    private boolean[][] visited = new boolean[SIZE][SIZE];
    private char[][] board = new char[SIZE][SIZE];
    private int remainingCells;

    public Test3() {
        setTitle("Minesweeper");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new GridLayout(SIZE, SIZE));

        initializeBoard();
        placeMines();

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                JButton button = new JButton();
                button.setPreferredSize(new Dimension(50, 50));
                button.addActionListener(new ButtonListener(i, j));
                buttons[i][j] = button;
                add(button);
            }
        }

        pack();
        setVisible(true);
    }

    private void initializeBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = '-';
                visited[i][j] = false;
            }
        }

        remainingCells = SIZE * SIZE - MINES;
    }

    private void placeMines() {
        int count = 0;
        while (count < MINES) {
            int x = (int) (Math.random() * SIZE);
            int y = (int) (Math.random() * SIZE);
            if (board[x][y] != '*') {
                board[x][y] = '*';
                count++;
            }
        }
    }

    private void revealCell(int row, int col) {
        if (row < 0 || row >= SIZE || col < 0 || col >= SIZE || visited[row][col])
            return;

        visited[row][col] = true;
        buttons[row][col].setEnabled(false);
        buttons[row][col].setText(Character.toString(board[row][col]));
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
                revealCell(i, j);
            }
        }
    }

    private void gameOver(boolean win) {
        if (win) {
            JOptionPane.showMessageDialog(this, "Congratulations! You won the game.");
        } else {
            JOptionPane.showMessageDialog(this, "Game over! You hit a mine.");
        }
        resetGame();
    }

    private void resetGame() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                buttons[i][j].setEnabled(true);
                buttons[i][j].setText("");
                visited[i][j] = false;
            }
        }

        initializeBoard();
        placeMines();
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Test3();
            }
        });
    }
}
