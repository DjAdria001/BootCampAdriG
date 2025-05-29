package com.mvc;

import java.sql.*;
import java.util.ArrayList;

public class Modelo {

    private Connection conexion;

    public void iniciarConexion() {
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/empresa", "root", "");
            System.out.println("Conexión exitosa.");
        } catch (SQLException e) {
            System.err.println("Error al conectar: " + e.getMessage());
        }
    }

    public ArrayList<String> obtenerEmpleados() {
        ArrayList<String> lista = new ArrayList<>();
        String consulta = "SELECT nombre FROM empleados";
        try (Statement st = conexion.createStatement(); ResultSet rs = st.executeQuery(consulta)) {
            while (rs.next()) {
                lista.add(rs.getString("nombre"));
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener datos: " + e.getMessage());
        }
        return lista;
    }

    public void cerrarConexion() {
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
                System.out.println("Conexión cerrada.");
            }
        } catch (SQLException e) {
            System.err.println("No se pudo cerrar la conexión: " + e.getMessage());
        }
    }
}
