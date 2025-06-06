package com.tetris;

import java.awt.*;
import java.util.Random;

public class Tetromino {

    private Point[] blocks = new Point[4]; // posiciones relativas
    private int type; // 1 a 7 para cada tipo
    private int rotation; // estado de rotación (0-3)
    private Point position; // posición en tablero (fila, columna)

    // Formas básicas de cada tipo en rotación 0
    private static final Point[][] SHAPES = {
        // I
        {new Point(0,1), new Point(1,1), new Point(2,1), new Point(3,1)},
        // J
        {new Point(0,0), new Point(1,0), new Point(2,0), new Point(2,1)},
        // L
        {new Point(0,1), new Point(1,1), new Point(2,1), new Point(2,0)},
        // O
        {new Point(0,0), new Point(0,1), new Point(1,0), new Point(1,1)},
        // S
        {new Point(0,1), new Point(0,2), new Point(1,0), new Point(1,1)},
        // T
        {new Point(0,1), new Point(1,0), new Point(1,1), new Point(1,2)},
        // Z
        {new Point(0,0), new Point(0,1), new Point(1,1), new Point(1,2)},
    };

    public Tetromino(int type) {
        this.type = type;
        this.rotation = 0;
        this.position = new Point(0, 3); // empieza en fila 0, columna 3 (casi centro)
        copyShape();
    }

    private void copyShape() {
        Point[] shape = SHAPES[type - 1];
        for (int i = 0; i < 4; i++) {
            blocks[i] = new Point(shape[i]);
        }
    }

    // Genera una nueva pieza aleatoria
    public static Tetromino getRandomTetromino() {
        Random rand = new Random();
        return new Tetromino(rand.nextInt(7) + 1);
    }

    // Intenta mover la pieza hacia abajo, devuelve false si choca
    public boolean moveDown(int[][] board) {
        position.x++;
        if (!isValidPosition(board)) {
            position.x--;
            return false;
        }
        return true;
    }

    // Intenta mover a la izquierda
    public void moveLeft(int[][] board) {
        position.y--;
        if (!isValidPosition(board)) {
            position.y++;
        }
    }

    // Intenta mover a la derecha
    public void moveRight(int[][] board) {
        position.y++;
        if (!isValidPosition(board)) {
            position.y--;
        }
    }

    // Rota la pieza 90 grados en sentido horario
    public void rotate(int[][] board) {
        rotation = (rotation + 1) % 4;
        rotateBlocks();
        if (!isValidPosition(board)) {
            // si no es válido, vuelve atrás
            rotation = (rotation + 3) % 4;
            rotateBlocks();
        }
    }

    // Aplica la rotación a los bloques
    private void rotateBlocks() {
        // El bloque O no rota
        if (type == 4) return;

        for (int i = 0; i < 4; i++) {
            int x = blocks[i].x;
            int y = blocks[i].y;
            // rotación 90° clockwise respecto al centro (1,1)
            blocks[i].x = y;
            blocks[i].y = 3 - x;
        }
    }

    // Verifica si la pieza está en posición válida dentro del tablero
    public boolean isValidPosition(int[][] board) {
        for (Point p : blocks) {
            int x = position.x + p.x;
            int y = position.y + p.y;
            if (x < 0 || x >= board.length || y < 0 || y >= board[0].length)
                return false;
            if (board[x][y] != 0)
                return false;
        }
        return true;
    }

    // Mezcla la pieza con el tablero (fija la pieza)
    public void merge(int[][] board) {
        for (Point p : blocks) {
            int x = position.x + p.x;
            int y = position.y + p.y;
            board[x][y] = type;
        }
    }

    // Dibuja la pieza en el panel
    public void draw(Graphics g, int blockSize) {
        g.setColor(getColor(type));
        for (Point p : blocks) {
            int x = (position.y + p.y) * blockSize;
            int y = (position.x + p.x) * blockSize;
            g.fillRect(x, y, blockSize, blockSize);
            g.setColor(Color.BLACK);
            g.drawRect(x, y, blockSize, blockSize);
            g.setColor(getColor(type));
        }
    }

    // Color para cada tipo de pieza
    private Color getColor(int type) {
        switch (type) {
            case 1: return Color.CYAN;    // I
            case 2: return Color.BLUE;    // J
            case 3: return Color.ORANGE;  // L
            case 4: return Color.YELLOW;  // O
            case 5: return Color.GREEN;   // S
            case 6: return Color.MAGENTA; // T
            case 7: return Color.RED;     // Z
            default: return Color.GRAY;
        }
    }

    }

