package com.tetris;

import java.awt.*;
import java.util.Random;

public class Tetromino {

    // Posición de la pieza en el tablero
    private int posX;
    private int posY;

    // Bloques que forman la pieza (relativos a posX, posY)
    private Point[] blocks;

    // Formas posibles (como matrices o arrays de puntos)
    private static final Point[][] SHAPES = {
        {new Point(0,0), new Point(1,0), new Point(0,1), new Point(1,1)}, // O
        {new Point(0,0), new Point(-1,0), new Point(1,0), new Point(2,0)}, // I
        {new Point(0,0), new Point(-1,0), new Point(0,1), new Point(1,1)}, // S
        {new Point(0,0), new Point(1,0), new Point(0,1), new Point(-1,1)}, // Z
        {new Point(0,0), new Point(-1,0), new Point(1,0), new Point(0,1)}, // T
        {new Point(0,0), new Point(-1,0), new Point(-1,1), new Point(0,1)}, // J
        {new Point(0,0), new Point(1,0), new Point(1,1), new Point(0,1)}  // L
    };

    public Tetromino(Point[] shape) {
        this.blocks = shape;
        this.posX = 4;  // Empieza en columna 4 para centrar
        this.posY = 0;  // Arriba del tablero
    }

    // Obtener una pieza aleatoria
    public static Tetromino getRandomTetromino(int boardWidth) {
        Random rand = new Random();
        Point[] shape = SHAPES[rand.nextInt(SHAPES.length)];
        return new Tetromino(shape);
    }

    // Dibuja la pieza en pantalla
    public void draw(Graphics g, int blockSize) {
        g.setColor(Color.RED);
        for (Point p : blocks) {
            int x = (posX + p.x) * blockSize;
            int y = (posY + p.y) * blockSize;
            g.fillRect(x, y, blockSize, blockSize);
            g.setColor(Color.BLACK);
            g.drawRect(x, y, blockSize, blockSize);
            g.setColor(Color.RED);
        }
    }

    // Mover la pieza hacia abajo
    public boolean moveDown(int[][] board) {
        posY++;
        if (!isValidPosition(board)) {
            posY--;
            return false;
        }
        return true;
    }

    // Mover la pieza hacia la izquierda
    public void moveLeft(int[][] board) {
        posX--;
        if (!isValidPosition(board)) {
            posX++;
        }
    }

    // Mover la pieza hacia la derecha
    public void moveRight(int[][] board) {
        posX++;
        if (!isValidPosition(board)) {
            posX--;
        }
    }

    // Rotar la pieza 90 grados (sentido horario)
    public void rotate(int[][] board) {
        for (int i = 0; i < blocks.length; i++) {
            int x = blocks[i].x;
            blocks[i].x = -blocks[i].y;
            blocks[i].y = x;
        }
        if (!isValidPosition(board)) {
            // revertir rotación
            for (int i = 0; i < blocks.length; i++) {
                int x = blocks[i].x;
                blocks[i].x = blocks[i].y;
                blocks[i].y = -x;
            }
        }
    }

    // Comprueba si la posición actual es válida (sin colisiones ni fuera del tablero)
    public boolean isValidPosition(int[][] board) {
        for (Point p : blocks) {
            int x = posX + p.x;
            int y = posY + p.y;
            if (x < 0 || x >= board[0].length || y < 0 || y >= board.length) {
                return false;
            }
            if (board[y][x] != 0) {
                return false;
            }
        }
        return true;
    }

    // Fusiona la pieza con el tablero (coloca los bloques en el tablero)
    public void merge(int[][] board) {
        for (Point p : blocks) {
            int x = posX + p.x;
            int y = posY + p.y;
            if (y >= 0 && y < board.length && x >= 0 && x < board[0].length) {
                board[y][x] = 1;
            }
        }
    }
}
