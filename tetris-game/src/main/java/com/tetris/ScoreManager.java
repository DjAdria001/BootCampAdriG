package com.tetris;

import java.sql.*;

public class ScoreManager {

    public static void guardarPuntuacion(String nombre, int puntos) {
        if (nombre.length() != 3) {
            System.out.println("El nombre debe tener exactamente 3 letras.");
            return;
        }

        String query = "INSERT INTO puntuaciones (nombre, puntos) VALUES (?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, nombre.toUpperCase());
            stmt.setInt(2, puntos);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
