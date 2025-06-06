package com.tetris;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;

public class GamePanel extends JPanel implements KeyListener {

    private final int ROWS = 20;
    private final int COLS = 10;
    private final int BLOCK_SIZE = 30;
    private int[][] board = new int[ROWS][COLS];
    private Tetromino currentPiece;

    private Timer timer;

    public GamePanel() {
        setFocusable(true);
        requestFocusInWindow();
        addKeyListener(this);

        setPreferredSize(new Dimension(COLS * BLOCK_SIZE, ROWS * BLOCK_SIZE));

        currentPiece = Tetromino.getRandomTetromino(COLS);
        startGameLoop();
    }

    private void startGameLoop() {
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                update();
                repaint();
            }
        }, 0, 500);
    }

    private void update() {
        if (!currentPiece.moveDown(board)) {
            currentPiece.merge(board);
            clearLines();
            currentPiece = Tetromino.getRandomTetromino(COLS);
            if (!currentPiece.isValidPosition(board)) {
                timer.cancel();
                JOptionPane.showMessageDialog(this, "¡Fin del juego!");
                System.exit(0);
            }
        }
    }

    private void clearLines() {
        for (int i = ROWS - 1; i >= 0; i--) {
            boolean fullLine = true;
            for (int j = 0; j < COLS; j++) {
                if (board[i][j] == 0) {
                    fullLine = false;
                    break;
                }
            }
            if (fullLine) {
                for (int k = i; k > 0; k--) {
                    board[k] = board[k - 1].clone();
                }
                board[0] = new int[COLS];
                i++; // Rechequear la misma línea
            }
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());

        // Dibujar tablero
        g.setColor(Color.CYAN);
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (board[i][j] != 0) {
                    g.fillRect(j * BLOCK_SIZE, i * BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE);
                    g.setColor(Color.BLACK);
                    g.drawRect(j * BLOCK_SIZE, i * BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE);
                    g.setColor(Color.CYAN);
                }
            }
        }

        // Dibujar pieza actual
        currentPiece.draw(g, BLOCK_SIZE);
    }

    @Override
    public void keyPressed(KeyEvent e) {
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
            case KeyEvent.VK_C:
                saveCurrentPiece();
                break;
        }
        repaint();
    }


    @Override
    public void keyReleased(KeyEvent e) { }
    @Override
    public void keyTyped(KeyEvent e) { }

    private Tetromino savedPiece = null;
    private boolean canSave = true;

    private void saveCurrentPiece() {
        if (!canSave) return;

        if (savedPiece == null) {
            savedPiece = currentPiece;
            currentPiece = Tetromino.getRandomTetromino(COLS);
        } else {
            Tetromino temp = currentPiece;
            currentPiece = savedPiece;
            savedPiece = temp;
        }
        canSave = false;
    }

    // Para permitir guardar solo una vez hasta que la pieza caiga
    private void resetCanSave() {
        canSave = true;
    }
}
