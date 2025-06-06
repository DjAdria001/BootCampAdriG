package com.tetris;

import javax.swing.*;

public class Tetris {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Tetris");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            GamePanel gamePanel = new GamePanel();
            frame.add(gamePanel);

            frame.pack();  // Ajusta la ventana al tamaño preferido del panel
            frame.setLocationRelativeTo(null);  // Centrar ventana
            frame.setVisible(true);
        });
    }
}
