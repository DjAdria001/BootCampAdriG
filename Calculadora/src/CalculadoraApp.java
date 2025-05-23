public class CalculadoraApp {
    public static void main(String[] args) {
        // Inicia la interfaz gráfica en el hilo de eventos de Swing (buena práctica)
        javax.swing.SwingUtilities.invokeLater(VentanaCalculadora::new);
    }
}
