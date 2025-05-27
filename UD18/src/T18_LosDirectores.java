import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class T18_LosDirectores {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/";
        String user = "root";
        String password = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // por compatibilidad
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();

            // Crear base de datos
            stmt.executeUpdate("DROP DATABASE IF EXISTS T18_LosDirectores");
            stmt.executeUpdate("CREATE DATABASE T18_LosDirectores");
            stmt.executeUpdate("USE T18_LosDirectores");

            // Crear tabla Despachos
            stmt.executeUpdate(
                "CREATE TABLE Despachos (" +
                "Numero INT PRIMARY KEY," +
                "Capacidad INT)"
            );

            // Crear tabla Directores
            stmt.executeUpdate(
                "CREATE TABLE Directores (" +
                "DNI VARCHAR(8) PRIMARY KEY," +
                "NomApels NVARCHAR(255)," +
                "DNIJefe VARCHAR(8)," +
                "Despacho INT," +
                "FOREIGN KEY (DNIJefe) REFERENCES Directores(DNI)," +
                "FOREIGN KEY (Despacho) REFERENCES Despachos(Numero))"
            );

            // Insertar datos en Despachos
            stmt.executeUpdate("INSERT INTO Despachos VALUES (1, 2)");
            stmt.executeUpdate("INSERT INTO Despachos VALUES (2, 3)");
            stmt.executeUpdate("INSERT INTO Despachos VALUES (3, 1)");
            stmt.executeUpdate("INSERT INTO Despachos VALUES (4, 4)");
            stmt.executeUpdate("INSERT INTO Despachos VALUES (5, 2)");

            // Insertar datos en Directores
            stmt.executeUpdate("INSERT INTO Directores VALUES ('11111111', 'Ana García', NULL, 1)");
            stmt.executeUpdate("INSERT INTO Directores VALUES ('22222222', 'Luis Torres', '11111111', 2)");
            stmt.executeUpdate("INSERT INTO Directores VALUES ('33333333', 'Marta López', '11111111', 3)");
            stmt.executeUpdate("INSERT INTO Directores VALUES ('44444444', 'Carlos Pérez', '22222222', 4)");
            stmt.executeUpdate("INSERT INTO Directores VALUES ('55555555', 'Sofía Ruiz', '22222222', 5)");

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
