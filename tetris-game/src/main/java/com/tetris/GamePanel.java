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

    // Pieza actual y pieza guardada (simulación)
    private Tetromino currentPiece;
    private Tetromino savedPiece;

    private Timer timer;
    private int score = 0;

    // Listener para cambios de puntuación
    public interface ScoreChangeListener {
        void onScoreChanged(int newScore);
    }
    private ScoreChangeListener scoreChangeListener;

    public void setScoreChangeListener(ScoreChangeListener listener) {
        this.scoreChangeListener = listener;
    }

    public GamePanel() {
        setFocusable(true);
        requestFocusInWindow();
        addKeyListener(this);

        currentPiece = Tetromino.getRandomTetromino(COLS);

        // Definir tamaño preferido del panel (ancho = COLS * BLOCK_SIZE, alto = ROWS * BLOCK_SIZE)
        setPreferredSize(new Dimension(COLS * BLOCK_SIZE, ROWS * BLOCK_SIZE));
        
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
        int linesCleared = 0;
        for (int i = ROWS - 1; i >= 0; i--) {
            boolean fullLine = true;
            for (int j = 0; j < COLS; j++) {
                if (board[i][j] == 0) {
                    fullLine = false;
                    break;
                }
            }
            if (fullLine) {
                linesCleared++;
                for (int k = i; k > 0; k--) {
                    board[k] = board[k - 1].clone();
                }
                board[0] = new int[COLS];
                i++; // Rechequear la misma línea
            }
        }
        if (linesCleared > 0) {
            addScore(linesCleared * 100);
        }
    }

    private void addScore(int points) {
        score += points;
        if (scoreChangeListener != null) {
            scoreChangeListener.onScoreChanged(score);
        }
    }

    // Método para guardar la pieza actual
    public void saveCurrentPiece() {
        savedPiece = currentPiece;
        System.out.println("Pieza guardada: " + savedPiece);
    }

    // Métodos KeyListener (vacíos para que compile)
    @Override public void keyPressed(KeyEvent e) { /* Implementar */ }
    @Override public void keyReleased(KeyEvent e) { }
    @Override public void keyTyped(KeyEvent e) { }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Fondo negro
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());

        // Dibuja el tablero
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (board[i][j] != 0) {
                    g.setColor(Color.CYAN);
                    g.fillRect(j * BLOCK_SIZE, i * BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE);
                    g.setColor(Color.BLACK);
                    g.drawRect(j * BLOCK_SIZE, i * BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE);
                }
            }
        }

        // Dibuja la pieza actual (asumiendo que Tetromino tiene método draw)
        if (currentPiece != null) {
            currentPiece.draw(g, BLOCK_SIZE);
        }
    }
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(COLS * BLOCK_SIZE + 150, ROWS * BLOCK_SIZE); // +150 para mostrar info lateral
    }

    

}
