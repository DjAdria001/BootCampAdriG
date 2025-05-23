import java.sql.*;

public class GestorBD {
    private static final String URL = "jdbc:mysql://localhost:3306/CalculadoraDB"; // dirección de la BD
    private static final String USUARIO = "root"; // tu usuario MySQL
    private static final String CONTRASENA = ""; // tu contraseña MySQL

    // Guarda la operación y el resultado en la tabla Historico
    public static void guardarOperacion(String operacion, double resultado) {
        try (Connection conn = DriverManager.getConnection(URL, USUARIO, CONTRASENA)) {
            String sql = "INSERT INTO Historico (operacion, resultado) VALUES (?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, operacion);
                stmt.setDouble(2, resultado);
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            System.err.println("Error al guardar operación: " + e.getMessage());
        }
    }

    // Devuelve una cadena con las últimas operaciones guardadas
    public static String obtenerHistorial() {
        StringBuilder historial = new StringBuilder();

        try (Connection conn = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM Historico ORDER BY fecha DESC LIMIT 20")) {

            while (rs.next()) {
                historial.append(rs.getTimestamp("fecha"))
                         .append(" → ")
                         .append(rs.getString("operacion"))
                         .append(" = ")
                         .append(rs.getDouble("resultado"))
                         .append("\n");
            }

        } catch (SQLException e) {
            historial.append("Error al obtener historial: ").append(e.getMessage());
        }

        return historial.length() == 0 ? "No hay operaciones guardadas." : historial.toString();
    }
}
