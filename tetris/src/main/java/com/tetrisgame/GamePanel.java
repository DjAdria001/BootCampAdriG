package com.tetrisgame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class GamePanel extends JPanel {
    private final int tileSize = 30;
    private final int cols = 10;
    private final int rows = 20;
    private final Board board;
    private Tetromino currentPiece;
    private int pieceX, pieceY;
    private final Timer timer;

    private int score = 0;
    private int highScore = 0;

    public GamePanel() {
        setPreferredSize(new Dimension(cols * tileSize, rows * tileSize + 40));
        setBackground(Color.BLACK);
        setFocusable(true);

        board = new Board(cols, rows);
        spawnPiece();

        timer = new Timer(500, e -> {
            if (!tryMove(0, 1)) {
                board.placeTetromino(currentPiece, pieceX, pieceY);
                score += board.clearLines() * 100;
                if (score > highScore) highScore = score;
                spawnPiece();
            }
            repaint();
        });
        timer.start();

        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_LEFT -> tryMove(-1, 0);
                    case KeyEvent.VK_RIGHT -> tryMove(1, 0);
                    case KeyEvent.VK_DOWN -> tryMove(0, 1);
                    case KeyEvent.VK_UP -> {
                        Tetromino rotated = currentPiece.copy();
                        rotated.rotateClockwise();
                        if (board.isValidPosition(rotated, pieceX, pieceY)) {
                            currentPiece = rotated;
                        }
                    }
                }
                repaint();
            }
        });
    }

    private void spawnPiece() {
        Tetromino.Type[] values = Tetromino.Type.values();
        Tetromino.Type randomType = values[new Random().nextInt(values.length)];
        currentPiece = new Tetromino(randomType);
        pieceX = cols / 2;
        pieceY = 0;

        if (!board.isValidPosition(currentPiece, pieceX, pieceY)) {
            timer.stop();
            JOptionPane.showMessageDialog(this, "Game Over\nPuntuación: " + score, "Tetris", JOptionPane.INFORMATION_MESSAGE);
            score = 0;
            board.clearLines(); // reseteamos el tablero visual
            repaint();
            timer.start();
        }
    }

    private boolean tryMove(int dx, int dy) {
        if (board.isValidPosition(currentPiece, pieceX + dx, pieceY + dy)) {
            pieceX += dx;
            pieceY += dy;
            return true;
        }
        return false;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        board.draw(g, tileSize);
        g.setColor(currentPiece.getColor());
        for (Point p : currentPiece.getBlocks()) {
            int x = (pieceX + p.x) * tileSize;
            int y = (pieceY + p.y) * tileSize;
            g.fillRect(x, y, tileSize, tileSize);
            g.setColor(Color.DARK_GRAY);
            g.drawRect(x, y, tileSize, tileSize);
            g.setColor(currentPiece.getColor());
        }

        // Mostrar puntuación
        g.setColor(Color.WHITE);
        g.drawString("Puntuación: " + score, 10, rows * tileSize + 15);
        g.drawString("Récord: " + highScore, 10, rows * tileSize + 30);
    }
}
