package com.videoclub.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteDAO {

    public Cliente obtenerClientePorId(int id) {
        Cliente cliente = null;
        String sql = "SELECT * FROM cliente WHERE id = ?";

        try (Connection conn = ConexionBD.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                cliente = new Cliente(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getString("direccion"),
                    rs.getInt("dni"),
                    rs.getDate("fecha")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cliente;
    }
}
