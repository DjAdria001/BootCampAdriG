import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VentanaCalculadora extends JFrame {
    private JTextField pantalla;         // Campo para mostrar los números y resultados
    private String operacion = "";       // Guarda la operación actual: +, -, *, /
    private double num1 = 0;             // Primer número ingresado
    private boolean nuevaOperacion = true; // Indica si el siguiente número es nuevo

    public VentanaCalculadora() {
        // Configuración básica de la ventana
        setTitle("Calculadora Clásica");
        setSize(300, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar en pantalla
        setLayout(new BorderLayout());

        // Campo de texto que muestra los números y resultados
        pantalla = new JTextField("0");
        pantalla.setEditable(false);
        pantalla.setFont(new Font("Arial", Font.BOLD, 24));
        pantalla.setHorizontalAlignment(SwingConstants.RIGHT);
        add(pantalla, BorderLayout.NORTH);

        // Panel de botones numéricos y de operaciones
        JPanel panel = new JPanel(new GridLayout(5, 4, 5, 5));
        String[] botones = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+",
            "C"
        };

        // Crea cada botón y le añade su evento
        for (String texto : botones) {
            JButton btn = new JButton(texto);
            btn.setFont(new Font("SansSerif", Font.BOLD, 18));

            // Estilo basado en tipo de botón
            if (texto.matches("[0-9\\.=]")) {
                btn.setBackground(new Color(106, 79, 179)); // violeta fuerte
                btn.setForeground(Color.WHITE);
            } else if (texto.matches("[\\+\\-\\*/]")) {
                btn.setBackground(new Color(255, 215, 0)); // amarillo dorado
                btn.setForeground(Color.BLACK);
            } else if (texto.equals("C")) {
                btn.setBackground(new Color(244, 163, 0)); // naranja suave
                btn.setForeground(Color.BLACK);
            }

            btn.addActionListener(this::botonPresionado);
            panel.add(btn);
        }



        add(panel, BorderLayout.CENTER);

        // Menú desplegable superior
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Opciones");

        JMenuItem itemHistorial = new JMenuItem("Historial");
        JMenuItem itemAbout = new JMenuItem("About");
        JMenuItem itemSalir = new JMenuItem("Salir");

        // Acción para mostrar historial desde base de datos
        itemHistorial.addActionListener(e -> mostrarHistorial());

        // Muestra información sobre la app
        itemAbout.addActionListener(e -> JOptionPane.showMessageDialog(this,
                "Mini Calculadora Clásica\nVersión 1.0\nCreado por: Paula, Ani y Adrià.\nCon la Ayuda especial de ChatGPT",
                "About", JOptionPane.INFORMATION_MESSAGE));

        // Cierra la aplicación
        itemSalir.addActionListener(e -> System.exit(0));

        // Añade los ítems al menú
        menu.add(itemHistorial);
        menu.add(itemAbout);
        menu.add(itemSalir);
        menuBar.add(menu);
        setJMenuBar(menuBar);

        setVisible(true);
    }

    // Método que se ejecuta al presionar cualquier botón
    private void botonPresionado(ActionEvent e) {
        String texto = ((JButton)e.getSource()).getText();

        // Si es número o punto
        if (texto.matches("[0-9\\.]")) {
            if (nuevaOperacion) {
                pantalla.setText(texto); // comienza nuevo número
                nuevaOperacion = false;
            } else {
                pantalla.setText(pantalla.getText() + texto); // agrega al número actual
            }

        // Si es una operación
        } else if (texto.matches("[\\+\\-\\*/]")) {
            num1 = Double.parseDouble(pantalla.getText());
            operacion = texto;
            nuevaOperacion = true;

        // Si es igual, realiza el cálculo
        } else if (texto.equals("=")) {
            calcular();

        // Si es limpiar
        } else if (texto.equals("C")) {
            pantalla.setText("0");
            num1 = 0;
            operacion = "";
            nuevaOperacion = true;
        }
    }

    // Realiza el cálculo de la operación seleccionada
    private void calcular() {
        double num2 = Double.parseDouble(pantalla.getText());
        double resultado = switch (operacion) {
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "*" -> num1 * num2;
            case "/" -> {
                if (num2 == 0) {
                    JOptionPane.showMessageDialog(this, "Error: división por cero");
                    yield 0;
                }
                yield num1 / num2;
            }
            default -> 0;
        };

        // Guarda el cálculo en la base de datos
        String operacionCompleta = num1 + " " + operacion + " " + num2;
        pantalla.setText(String.valueOf(resultado));
        GestorBD.guardarOperacion(operacionCompleta, resultado);
        nuevaOperacion = true;
    }

    // Muestra el historial de operaciones guardadas
    private void mostrarHistorial() {
        String historial = GestorBD.obtenerHistorial();
        JTextArea area = new JTextArea(historial);
        area.setEditable(false);
        JScrollPane scroll = new JScrollPane(area);
        scroll.setPreferredSize(new Dimension(350, 200));
        JOptionPane.showMessageDialog(this, scroll, "Historial", JOptionPane.INFORMATION_MESSAGE);
    }
}
