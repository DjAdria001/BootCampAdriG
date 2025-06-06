package com.tetris;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GamePanel extends JPanel implements ActionListener {

    private final int ROWS = 20;
    private final int COLS = 10;
    private final int BLOCK_SIZE = 30;

    private int[][] board = new int[ROWS][COLS];
    private Tetromino currentPiece;
    private Timer timer;
    private boolean gameOver = false;

    public GamePanel() {
        setPreferredSize(new Dimension(COLS * BLOCK_SIZE, ROWS * BLOCK_SIZE));
        setBackground(Color.BLACK);

        initGame();

        timer = new Timer(500, this); // mueve pieza cada 500ms
        timer.start();

        addKeyListener(new KeyAdapter() {
            @Override
			public void keyPressed(KeyEvent e) {
				if (gameOver)
					return;

				switch (e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					currentPiece.moveLeft(board);
					break;
				case KeyEvent.VK_RIGHT:
					currentPiece.moveRight(board);
					break;
				case KeyEvent.VK_DOWN:
					currentPiece.moveDown(board);
					break;
				case KeyEvent.VK_UP:
					currentPiece.rotate(board);
					break;
				case KeyEvent.VK_SPACE:
					while (currentPiece.moveDown(board)) {
					} // cae rápido hasta el fondo
					placePiece();
					break;
				}
				repaint();
			}
        });

        setFocusable(true);
    }

    private void initGame() {
        // limpia el tablero
        for (int r = 0; r < ROWS; r++)
            for (int c = 0; c < COLS; c++)
                board[r][c] = 0;

        currentPiece = Tetromino.getRandomTetromino();
        gameOver = false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (gameOver) {
            timer.stop();
            return;
        }

        if (!currentPiece.moveDown(board)) {
            placePiece();
        }
        repaint();
    }

    private void placePiece() {
        currentPiece.merge(board);
        clearLines();
        currentPiece = Tetromino.getRandomTetromino();
        if (!currentPiece.isValidPosition(board)) {
            gameOver = true;
            timer.stop();
            JOptionPane.showMessageDialog(this, "Game Over! Press OK to restart.");
            initGame(); // reinicia el juego
            repaint();
            } else {
            	currentPiece = Tetromino.getRandomTetromino();
				if (!currentPiece.isValidPosition(board)) {
					gameOver = true;
					timer.stop();
					JOptionPane.showMessageDialog(this, "Game Over! Press OK to restart.");
					initGame(); // reinicia el juego
					repaint();
				}
				
        }
    }

    private void clearLines() {
        for (int r = ROWS - 1; r >= 0; r--) {
            boolean full = true;
            for (int c = 0; c < COLS; c++) {
                if (board[r][c] == 0) {
                    full = false;
                    break;
                }
            }
            if (full) {
                // Baja todas las filas encima una posición
                for (int row = r; row > 0; row--) {
                    System.arraycopy(board[row - 1], 0, board[row], 0, COLS);
                }
                // Limpia fila 0
                for (int c = 0; c < COLS; c++) {
                    board[0][c] = 0;
                }
                r++; // revisa esta fila otra vez (porque bajaron las filas)
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Dibuja tablero
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (board[r][c] != 0) {
                    g.setColor(getColor(board[r][c]));
                    g.fillRect(c * BLOCK_SIZE, r * BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE);
                    g.setColor(Color.BLACK);
                    g.drawRect(c * BLOCK_SIZE, r * BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE);
                }
            }
        }

        // Dibuja pieza actual
        currentPiece.draw(g, BLOCK_SIZE);
    }

    private Color getColor(int value) {
        // Aquí deberías mapear valor a color
        switch (value) {
            case 1: return Color.CYAN;
            case 2: return Color.BLUE;
            case 3: return Color.ORANGE;
            case 4: return Color.YELLOW;
            case 5: return Color.GREEN;
            case 6: return Color.MAGENTA;
            case 7: return Color.RED;
            default: return Color.GRAY;
        }
    }
}
