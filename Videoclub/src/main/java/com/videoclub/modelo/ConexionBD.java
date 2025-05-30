package com.videoclub.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    private static final String URL = "jdbc:mysql://localhost:3306/videoclub?useSSL=false&serverTimezone=UTC";
    private static final String USUARIO = "root"; // Tu usuario
    private static final String CONTRASENA = "";  // Tu contraseña

    public static Connection conectar() {
        try {
            return DriverManager.getConnection(URL, USUARIO, CONTRASENA);
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos");
            e.printStackTrace();
            return null;
        }
    }
}
