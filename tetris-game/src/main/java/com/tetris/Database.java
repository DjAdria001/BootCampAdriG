package com.tetris;

import java.sql.*;

public class Database {
    private static final String URL = "jdbc:mysql://localhost:3306/tetrisdb?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "tu_contraseña";

    public static int loadHighScore() {
        int highScore = 0;
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT MAX(puntos) AS max_puntos FROM puntuaciones")) {

            if (rs.next()) {
                highScore = rs.getInt("max_puntos");
            }
        } catch (SQLException e) {
            System.err.println("Error cargando récord: " + e.getMessage());
        }
        return highScore;
    }

    public static void saveScore(String nombre, int puntos) {
        String sql = "INSERT INTO puntuaciones(nombre, puntos) VALUES (?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, nombre);
            ps.setInt(2, puntos);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error guardando puntuación: " + e.getMessage());
        }
    }
}
