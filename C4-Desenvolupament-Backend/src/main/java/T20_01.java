import javax.swing.*;

public class T20_01 extends JFrame {

    public T20_01() {
        // Establecer el título de la ventana
        setTitle("Ventana con Controles Básicos");

        // Establecer el tamaño inicial de la ventana
        setSize(400, 200);

        // Permitir que el usuario cambie el tamaño de la ventana
        setResizable(true);

        // Establecer la operación por defecto al cerrar la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear una etiqueta
        JLabel etiqueta = new JLabel("¡Bienvenido a la aplicación!", SwingConstants.CENTER);

        // Añadir la etiqueta al contenido de la ventana
        add(etiqueta);

        // Hacer visible la ventana
        setVisible(true);
    }

    public static void main(String[] args) {
        // Crear y mostrar la ventana en el hilo de eventos de Swing
        SwingUtilities.invokeLater(() -> new T20_01());
    }
}
