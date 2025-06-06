package com.tetris;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainPanel extends JPanel {
    private GamePanel gamePanel;
    private JLabel scoreLabel;
    private JLabel highScoreLabel;
    private JButton savePieceButton;

    public MainPanel() {
        setLayout(new BorderLayout());

        gamePanel = new GamePanel();
        gamePanel.setPreferredSize(new Dimension(300, 600)); // tablero 10x20 con bloques 30px

        JPanel infoPanel = new JPanel();
        infoPanel.setPreferredSize(new Dimension(150, 600));
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));

        scoreLabel = new JLabel("Puntuación: 0");
        highScoreLabel = new JLabel("Mejor Puntuación: 0");
        savePieceButton = new JButton("Guardar Pieza");

        scoreLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        highScoreLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        savePieceButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        infoPanel.add(Box.createVerticalStrut(50));
        infoPanel.add(scoreLabel);
        infoPanel.add(Box.createVerticalStrut(20));
        infoPanel.add(highScoreLabel);
        infoPanel.add(Box.createVerticalStrut(50));
        infoPanel.add(savePieceButton);

        add(gamePanel, BorderLayout.CENTER);
        add(infoPanel, BorderLayout.EAST);

        // Acción para el botón
        savePieceButton.addActionListener(e -> {
            // Aquí llamamos a un método para guardar la pieza actual
            gamePanel.saveCurrentPiece();
            JOptionPane.showMessageDialog(this, "Pieza guardada!");
        });

        // Escuchar cambios de puntuación (podrías implementar un listener o método)
        gamePanel.setScoreChangeListener(score -> {
            scoreLabel.setText("Puntuación: " + score);
            if (score > getHighScore()) {
                setHighScore(score);
                highScoreLabel.setText("Mejor Puntuación: " + getHighScore());
            }
        });
    }

    private int highScore = 0;
    private int getHighScore() {
        return highScore;
    }
    private void setHighScore(int score) {
        highScore = score;
        // Podrías guardar en archivo o base de datos si quieres persistir
    }
}
