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
    private Tetromino heldPiece = null;
    private boolean canHold = true;

    private int pieceX, pieceY;
    private Timer timer;

    private final SoundPlayer soundPlayer = new SoundPlayer();
    private final List<FloatingText> floatingTexts = new ArrayList<>();

    private int score = 0;
    private int highScore = 0;
    private int level = 1;
    private final int maxScore = 5000;
    private final int initialDelay = 500;

    public GamePanel() {
        setPreferredSize(new Dimension(cols * tileSize + 200, rows * tileSize + 40));
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
                    double multiplier = switch (linesCleared) {
                        case 2 -> 1.5;
                        case 3 -> 1.75;
                        case 4 -> 2.0;
                        default -> 1.0;
                    };
                    int gained = (int)(linesCleared * 100 * multiplier);
                    score += gained;
                    floatingTexts.add(new FloatingText("+" + gained, pieceX * tileSize, pieceY * tileSize));
                    soundPlayer.playEffect("/sounds/line_clear.wav");

                    int targetLevel = 1 + (int)(((double)score / maxScore) * 9);
                    if (targetLevel > level) {
                        level = targetLevel;
                        int newDelay = Math.max(100, initialDelay - (level - 1) * 40);
                        timer.setDelay(newDelay);
                    }
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
        return new Tetromino(values[new Random().nextInt(values.length)]);
    }

    private void spawnPiece() {
        currentPiece = nextPiece;
        nextPiece = generateRandomPiece();
        canHold = true;

        if (!findValidSpawnPosition()) endGame();
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
            if (!findValidSpawnPosition()) endGame();
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
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        // Fondo del tablero
        g2.setColor(new Color(30, 30, 30));
        g2.fillRect(0, 0, cols * tileSize, rows * tileSize);
        g2.setColor(Color.WHITE);
        g2.drawRect(0, 0, cols * tileSize, rows * tileSize);

        // Líneas de cuadrícula
        g2.setColor(new Color(60, 60, 60));
        for (int i = 1; i < cols; i++) g2.drawLine(i * tileSize, 0, i * tileSize, rows * tileSize);
        for (int i = 1; i < rows; i++) g2.drawLine(0, i * tileSize, cols * tileSize, i * tileSize);

        // Dibujar el tablero
        board.draw(g2, tileSize);

        // Pieza actual
        g2.setColor(currentPiece.getColor());
        for (Point p : currentPiece.getBlocks()) {
            int x = (pieceX + p.x) * tileSize;
            int y = (pieceY + p.y) * tileSize;
            g2.fillRoundRect(x, y, tileSize, tileSize, 6, 6);
            g2.setColor(Color.DARK_GRAY);
            g2.drawRoundRect(x, y, tileSize, tileSize, 6, 6);
            g2.setColor(currentPiece.getColor());
        }

        // Animaciones flotantes
        for (FloatingText ft : floatingTexts) {
            g2.setColor(new Color(255, 255, 0, ft.alpha));
            g2.setFont(new Font("Arial", Font.BOLD, 18));
            g2.drawString(ft.text, ft.x, ft.y);
        }

        // PANEL LATERAL
        int offsetX = cols * tileSize + 20;

        // Fondo lateral con borde
        g2.setColor(new Color(40, 40, 50));
        g2.fillRoundRect(offsetX - 10, 10, 170, 340, 20, 20);

        // Sombra de texto
        g2.setFont(new Font("Arial", Font.BOLD, 16));
        g2.setColor(Color.BLACK);
        g2.drawString("Siguiente:", offsetX + 1, 30 + 1);
        g2.setColor(Color.CYAN);
        g2.drawString("Siguiente:", offsetX, 30);

        for (Point p : nextPiece.getBlocks()) {
            int x = offsetX + 10 + (p.x * tileSize);
            int y = 40 + (p.y * tileSize);

            g2.setColor(nextPiece.getColor());
            g2.fillRoundRect(x, y, tileSize, tileSize, 6, 6);
            g2.setColor(Color.DARK_GRAY);
            g2.drawRoundRect(x, y, tileSize, tileSize, 6, 6);
        }

        // Separador
        g2.setColor(new Color(70, 70, 90));
        g2.fillRect(offsetX - 5, 90, 160, 2);

        // Pieza guardada
        g2.setColor(Color.BLACK);
        g2.drawString("Guardada:", offsetX + 1, 120 + 1);
        g2.setColor(Color.PINK);
        g2.drawString("Guardada:", offsetX, 120);

        if (heldPiece != null) {
        	for (Point p : heldPiece.getBlocks()) {
        	    int x = offsetX + 10 + (p.x * tileSize);
        	    int y = 130 + (p.y * tileSize);

                g2.setColor(heldPiece.getColor());
                g2.fillRoundRect(x, y, tileSize, tileSize, 6, 6);
                g2.setColor(Color.DARK_GRAY);
                g2.drawRoundRect(x, y, tileSize, tileSize, 6, 6);
            }
        }

        // Separador
        g2.setColor(new Color(70, 70, 90));
        g2.fillRect(offsetX - 5, 190, 160, 2);

        // Estadísticas
        g2.setFont(new Font("Arial", Font.BOLD, 14));
        g2.setColor(Color.ORANGE);
        g2.drawString("Puntos: " + score, offsetX, 220);
        g2.setColor(Color.GREEN);
        g2.drawString("Récord: " + highScore, offsetX, 240);
        g2.setColor(Color.MAGENTA);
        g2.drawString("Nivel: " + level, offsetX, 260);
        g2.setColor(Color.WHITE);
        g2.drawString("Progreso: " + (int)(((double)score / maxScore) * 100) + "%", offsetX, 280);
    }


    private void endGame() {
        timer.stop();
        PuntuacionDAO dao = new PuntuacionDAO();

        String nombre = JOptionPane.showInputDialog(this, "Nombre (3 caracteres):");
        while (nombre == null || nombre.length() != 3) {
            nombre = JOptionPane.showInputDialog(this, "Nombre inválido. (3 caracteres):");
        }

        dao.guardarPuntuacion(nombre, score);

        StringBuilder mensaje = new StringBuilder();
        mensaje.append("Game Over\nPuntos: ").append(score)
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
            y -= 2; // velocidad mayor
            alpha -= 15;
        }

        public boolean isVisible() {
            return alpha > 0;
        }
    }
}

