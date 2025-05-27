import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TiendaInformatica {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/";
        String user = "root";
        String password = ""; // cambia según tu configuración

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement()) {

            // Crear base de datos
            stmt.executeUpdate("DROP DATABASE IF EXISTS TiendaInformatica");
            stmt.executeUpdate("CREATE DATABASE TiendaInformatica");
            stmt.executeUpdate("USE TiendaInformatica");

            // Crear tabla FABRICANTES
            stmt.executeUpdate(
                "CREATE TABLE FABRICANTES (" +
                "Codigo INT AUTO_INCREMENT PRIMARY KEY," +
                "Nombre NVARCHAR(100))"
            );

            // Crear tabla ARTICULOS
            stmt.executeUpdate(
                "CREATE TABLE ARTICULOS (" +
                "Codigo INT AUTO_INCREMENT PRIMARY KEY," +
                "Nombre NVARCHAR(100)," +
                "Precio INT," +
                "Fabricante INT," +
                "FOREIGN KEY (Fabricante) REFERENCES FABRICANTES(Codigo))"
            );

            // Insertar fabricantes
            stmt.executeUpdate("INSERT INTO FABRICANTES (Nombre) VALUES ('HP')");
            stmt.executeUpdate("INSERT INTO FABRICANTES (Nombre) VALUES ('Dell')");
            stmt.executeUpdate("INSERT INTO FABRICANTES (Nombre) VALUES ('Asus')");
            stmt.executeUpdate("INSERT INTO FABRICANTES (Nombre) VALUES ('Acer')");
            stmt.executeUpdate("INSERT INTO FABRICANTES (Nombre) VALUES ('Lenovo')");

            // Insertar artículos (usando códigos de fabricante del 1 al 5)
            stmt.executeUpdate("INSERT INTO ARTICULOS (Nombre, Precio, Fabricante) VALUES ('Portátil HP 15', 700, 1)");
            stmt.executeUpdate("INSERT INTO ARTICULOS (Nombre, Precio, Fabricante) VALUES ('Monitor Dell 24\"', 200, 2)");
            stmt.executeUpdate("INSERT INTO ARTICULOS (Nombre, Precio, Fabricante) VALUES ('Router Asus AX3000', 130, 3)");
            stmt.executeUpdate("INSERT INTO ARTICULOS (Nombre, Precio, Fabricante) VALUES ('Teclado Acer', 40, 4)");
            stmt.executeUpdate("INSERT INTO ARTICULOS (Nombre, Precio, Fabricante) VALUES ('Mouse Lenovo', 25, 5)");

            System.out.println("Base de datos creada y datos insertados con éxito.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
