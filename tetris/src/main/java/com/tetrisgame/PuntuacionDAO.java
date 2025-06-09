package com.tetrisgame;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PuntuacionDAO {

    public void guardarPuntuacion(String jugador, int puntuacion) {
        String sql = "INSERT INTO puntuaciones (jugador, puntuacion) VALUES (?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, jugador);
            stmt.setInt(2, puntuacion);
            stmt.executeUpdate();

            System.out.println("Puntuación guardada correctamente.");

        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error al guardar la puntuación.");
        }
    }
}
