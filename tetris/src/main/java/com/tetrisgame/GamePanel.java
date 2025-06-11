package com.tetrisgame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GamePanel extends JPanel {
    private final int tileSize = 30;
    private final int cols = 10;
    private final int rows = 20;
    private final Board board;
    private Tetromino currentPiece;
    private Tetromino nextPiece;
    private int pieceX, pieceY;
    private Timer timer;
    private int level = 1;
    private int initialDelay = 500;
    private Tetromino heldPiece = null;
    private boolean canHold = true;
    private final SoundPlayer soundPlayer = new SoundPlayer();
    private final List<FloatingText> floatingTexts = new ArrayList<>();

    private int score = 0;
    private int highScore = 0;

    public GamePanel() {
        setPreferredSize(new Dimension(cols * tileSize + 150, rows * tileSize + 40));
        setBackground(Color.BLACK);
        setFocusable(true);

        board = new Board(cols, rows);

        PuntuacionDAO dao = new PuntuacionDAO();
        highScore = dao.obtenerMaxPuntuacion();

        nextPiece = generateRandomPiece();
        spawnPiece();

        timer = new Timer(initialDelay, e -> {
            if (!tryMove(0, 1)) {
                board.placeTetromino(currentPiece, pieceX, pieceY);
                int linesCleared = board.clearLines();
                if (linesCleared > 0) {
                    score += linesCleared * 100;
                    floatingTexts.add(new FloatingText("+" + (linesCleared * 100), pieceX * tileSize, pieceY * tileSize));
                    soundPlayer.playEffect("/sounds/line_clear.wav");
                    level++;
                    int newDelay = Math.max(100, initialDelay - level * 20);
                    timer.setDelay(newDelay);
                }
                if (score > highScore) highScore = score;
                spawnPiece();
            }
            updateFloatingTexts();
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
                    case KeyEvent.VK_C -> holdPiece();
                }
                repaint();
            }
        });
    }

    private void updateFloatingTexts() {
        floatingTexts.removeIf(ft -> {
            ft.update();
            return !ft.isVisible();
        });
    }

    private Tetromino generateRandomPiece() {
        Tetromino.Type[] values = Tetromino.Type.values();
        Tetromino.Type randomType = values[new Random().nextInt(values.length)];
        return new Tetromino(randomType);
    }

    private void spawnPiece() {
        currentPiece = nextPiece;
        nextPiece = generateRandomPiece();
        canHold = true;

        if (!findValidSpawnPosition()) {
            endGame();
        }
    }

    private boolean findValidSpawnPosition() {
        pieceX = cols / 2;
        for (int y = 0; y < rows; y++) {
            pieceY = y;
            if (board.isValidPosition(currentPiece, pieceX, pieceY)) {
                return true;
            }
        }
        return false;
    }

    private void holdPiece() {
        if (!canHold) return;

        Tetromino temp = heldPiece;
        heldPiece = currentPiece;
        canHold = false;

        if (temp == null) {
            spawnPiece();
        } else {
            currentPiece = temp;
            if (!findValidSpawnPosition()) {
                endGame();
            }
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

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(new Color(30, 30, 30));
        g.fillRect(0, 0, cols * tileSize, rows * tileSize);
        g.setColor(Color.WHITE);
        g.drawRect(0, 0, cols * tileSize, rows * tileSize);

        g.setColor(new Color(80, 80, 80));
        for (int i = 1; i < cols; i++) g.drawLine(i * tileSize, 0, i * tileSize, rows * tileSize);
        for (int i = 1; i < rows; i++) g.drawLine(0, i * tileSize, cols * tileSize, i * tileSize);

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

        for (FloatingText ft : floatingTexts) {
            g.setColor(new Color(255, 255, 0, ft.alpha));
            g.setFont(new Font("Arial", Font.BOLD, 16));
            g.drawString(ft.text, ft.x, ft.y);
        }
        // --- PANEL LATERAL ---
        int sideX = cols * tileSize + 10;

        // PIEZA GUARDADA
        g.setColor(new Color(50, 50, 70)); // fondo azul oscuro
        g.fillRoundRect(sideX, 10, 120, 150, 15, 15);
        g.setColor(Color.WHITE);
        g.setFont(g.getFont().deriveFont(Font.BOLD, 16f));
        g.drawString("Guardada", sideX + 25, 30);
        if (heldPiece != null) {
            g.setColor(heldPiece.getColor());
            for (Point p : heldPiece.getBlocks()) {
                int x = sideX + 40 + p.x * tileSize / 2;
                int y = 40 + p.y * tileSize / 2;
                g.fillRect(x, y, tileSize / 2, tileSize / 2);
                g.setColor(Color.DARK_GRAY);
                g.drawRect(x, y, tileSize / 2, tileSize / 2);
                g.setColor(heldPiece.getColor());
            }
        }

        // SIGUIENTE PIEZA
        int nextY = 180;
        g.setColor(new Color(50, 70, 50)); // fondo verde oscuro
        g.fillRoundRect(sideX, nextY, 120, 150, 15, 15);
        g.setColor(Color.WHITE);
        g.drawString("Siguiente", sideX + 20, nextY + 25);
        if (nextPiece != null) {
            g.setColor(nextPiece.getColor());
            for (Point p : nextPiece.getBlocks()) {
                int x = sideX + 40 + p.x * tileSize / 2;
                int y = nextY + 40 + p.y * tileSize / 2;
                g.fillRect(x, y, tileSize / 2, tileSize / 2);
                g.setColor(Color.DARK_GRAY);
                g.drawRect(x, y, tileSize / 2, tileSize / 2);
                g.setColor(nextPiece.getColor());
            }
        }

        // PUNTUACIÓN Y RÉCORD
        int scoreY = nextY + 170;
        g.setColor(new Color(70, 50, 50)); // fondo rojo oscuro
        g.fillRoundRect(sideX, scoreY, 120, 100, 15, 15);
        g.setColor(Color.WHITE);
        g.setFont(g.getFont().deriveFont(Font.BOLD, 14f));
        g.drawString("Puntuación:", sideX + 15, scoreY + 25);
        g.drawString(String.valueOf(score), sideX + 15, scoreY + 45);
        g.drawString("Récord:", sideX + 15, scoreY + 70);
        g.drawString(String.valueOf(highScore), sideX + 15, scoreY + 90);

        // (resto de panel lateral omitido por brevedad pero es igual que el que ya tienes)
    }

    private void endGame() {
        timer.stop();
        PuntuacionDAO dao = new PuntuacionDAO();

        String nombreJugador = JOptionPane.showInputDialog(this, "Introduce tu nombre (3 caracteres):");
        while (nombreJugador == null || nombreJugador.length() != 3) {
            nombreJugador = JOptionPane.showInputDialog(this, "Nombre inválido. Introduce tu nombre (exactamente 3 caracteres):");
        }

        dao.guardarPuntuacion(nombreJugador, score);

        StringBuilder mensaje = new StringBuilder();
        mensaje.append("Game Over\nPuntuación: ").append(score)
               .append("\nRécord: ").append(highScore)
               .append("\n\nTOP 10:\n");

        List<String> top10 = dao.obtenerTop10();
        for (String entrada : top10) mensaje.append(entrada).append("\n");

        JOptionPane.showMessageDialog(this, mensaje.toString(), "Tetris", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }

    public static class FloatingText {
        public String text;
        public int x, y;
        public int alpha = 255;

        public FloatingText(String text, int x, int y) {
            this.text = text;
            this.x = x;
            this.y = y;
        }

        public void update() {
            y -= 1;
            alpha -= 5;
        }

        public boolean isVisible() {
            return alpha > 0;
        }
    }
}
