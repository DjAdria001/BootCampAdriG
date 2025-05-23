import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VentanaCalculadora extends JFrame {
    private JTextField pantalla;
    private String operacion = "";
    private double num1 = 0;
    private boolean nuevaOperacion = true;

    public VentanaCalculadora() {
        setTitle("Calculadora Clásica");
        setSize(300, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        pantalla = new JTextField("0");
        pantalla.setEditable(false);
        pantalla.setFont(new Font("Arial", Font.BOLD, 24));
        pantalla.setHorizontalAlignment(SwingConstants.RIGHT);
        add(pantalla, BorderLayout.NORTH);

        JPanel panel = new JPanel(new GridLayout(5, 4, 5, 5));
        String[] botones = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+",
            "C"
        };

        for (String texto : botones) {
            JButton btn = new JButton(texto);
            btn.setFont(new Font("Arial", Font.BOLD, 18));
            btn.addActionListener(this::botonPresionado);
            panel.add(btn);
        }

        add(panel, BorderLayout.CENTER);

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Opciones");

        JMenuItem itemHistorial = new JMenuItem("Historial");
        JMenuItem itemAbout = new JMenuItem("About");
        JMenuItem itemSalir = new JMenuItem("Salir");

        itemHistorial.addActionListener(e -> mostrarHistorial());
        itemAbout.addActionListener(e -> JOptionPane.showMessageDialog(this,
                "Mini Calculadora Clásica\nVersión 1.0\nCreado en Java con Swing y JDBC.",
                "About", JOptionPane.INFORMATION_MESSAGE));
        itemSalir.addActionListener(e -> System.exit(0));

        menu.add(itemHistorial);
        menu.add(itemAbout);
        menu.add(itemSalir);
        menuBar.add(menu);
        setJMenuBar(menuBar);

        setVisible(true);
    }

    private void botonPresionado(ActionEvent e) {
        String texto = ((JButton)e.getSource()).getText();

        if (texto.matches("[0-9\\.]")) {
            if (nuevaOperacion) {
                pantalla.setText(texto);
                nuevaOperacion = false;
            } else {
                pantalla.setText(pantalla.getText() + texto);
            }
        } else if (texto.matches("[\\+\\-\\*/]")) {
            num1 = Double.parseDouble(pantalla.getText());
            operacion = texto;
            nuevaOperacion = true;
        } else if (texto.equals("=")) {
            calcular();
        } else if (texto.equals("C")) {
            pantalla.setText("0");
            num1 = 0;
            operacion = "";
            nuevaOperacion = true;
        }
    }

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

        String operacionCompleta = num1 + " " + operacion + " " + num2;
        pantalla.setText(String.valueOf(resultado));
        GestorBD.guardarOperacion(operacionCompleta, resultado);
        nuevaOperacion = true;
    }

    private void mostrarHistorial() {
        String historial = GestorBD.obtenerHistorial();
        JTextArea area = new JTextArea(historial);
        area.setEditable(false);
        JScrollPane scroll = new JScrollPane(area);
        scroll.setPreferredSize(new Dimension(350, 200));
        JOptionPane.showMessageDialog(this, scroll, "Historial", JOptionPane.INFORMATION_MESSAGE);
    }
}
