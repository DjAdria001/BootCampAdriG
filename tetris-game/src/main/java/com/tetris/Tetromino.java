import java.awt.Color;
import java.util.Random;

public class Tetromino {
    // Definir los diferentes tipos con matrices de bloques y su color
    public static final Color[] COLORS = {
        Color.cyan,    // I
        Color.blue,    // J
        Color.orange,  // L
        Color.yellow,  // O
        Color.green,   // S
        Color.magenta, // T
        Color.red      // Z
    };

    private Color color;
    private int[][] shape;
    private int x, y; // posición en tablero

    // Constructor privado para usar en fábrica
    private Tetromino(int[][] shape, Color color) {
        this.shape = shape;
        this.color = color;
        this.x = 3; // posición inicial, ajustar según shape
        this.y = 0;
    }

    public Color getColor() {
        return color;
    }

    // Método estático para crear una pieza aleatoria
    public static Tetromino getRandomTetromino(int boardWidth) {
        Random rand = new Random();
        int index = rand.nextInt(7);

        switch (index) {
            case 0: // I
                return new Tetromino(new int[][]{
                    {1, 1, 1, 1}
                }, COLORS[0]);
            case 1: // J
                return new Tetromino(new int[][]{
                    {1, 0, 0},
                    {1, 1, 1}
                }, COLORS[1]);
            case 2: // L
                return new Tetromino(new int[][]{
                    {0, 0, 1},
                    {1, 1, 1}
                }, COLORS[2]);
            case 3: // O
                return new Tetromino(new int[][]{
                    {1, 1},
                    {1, 1}
                }, COLORS[3]);
            case 4: // S
                return new Tetromino(new int[][]{
                    {0, 1, 1},
                    {1, 1, 0}
                }, COLORS[4]);
            case 5: // T
                return new Tetromino(new int[][]{
                    {0, 1, 0},
                    {1, 1, 1}
                }, COLORS[5]);
            case 6: // Z
                return new Tetromino(new int[][]{
                    {1, 1, 0},
                    {0, 1, 1}
                }, COLORS[6]);
        }

        // Por defecto (no debería pasar)
        return null;
    }

    // Implementa draw para usar el color
    public void draw(Graphics g, int blockSize) {
        g.setColor(color);
        for (int i = 0; i < shape.length; i++) {
            for (int j = 0; j < shape[i].length; j++) {
                if (shape[i][j] != 0) {
                    g.fillRect((x + j) * blockSize, (y + i) * blockSize, blockSize, blockSize);
                    g.setColor(Color.BLACK);
                    g.drawRect((x + j) * blockSize, (y + i) * blockSize, blockSize, blockSize);
                    g.setColor(color);
                }
            }
        }
    }

    // Resto de métodos: moveDown, moveLeft, moveRight, rotate, merge, isValidPosition...
}
