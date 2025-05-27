import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class T20_08 extends JFrame {
    private static final double TASA_CAMBIO = 166.386;

    private JTextField campoCantidad;
    private JLabel resultadoLabel;

    public T20_08() {
        setTitle("Conversor Pesetas a Euros");
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 1));

        // Campo de entrada
        campoCantidad = new JTextField();
        campoCantidad.setToolTipText("Introduce una cantidad en euros o pesetas");

        // Etiqueta para resultado
        resultadoLabel = new JLabel("Euros(Alt+E) Pesetas(Alt+P) Borrar(Alt+B)", SwingConstants.CENTER);

        // Panel con botones
        JPanel panelBotones = new JPanel();
        JButton btnAEuros = new JButton("Convertir a Euros");
        JButton btnAPesetas = new JButton("Convertir a Pesetas");
        JButton btnBorrar = new JButton("Borrar");

        // Teclas rápidas (mnemonics)
        btnAEuros.setMnemonic(KeyEvent.VK_E);      // Alt + E
        btnAPesetas.setMnemonic(KeyEvent.VK_P);    // Alt + P
        btnBorrar.setMnemonic(KeyEvent.VK_B);      // Alt + B

        panelBotones.add(btnAEuros);
        panelBotones.add(btnAPesetas);
        panelBotones.add(btnBorrar);

        // Añadir componentes a la ventana
        add(new JLabel("Introduce una cantidad y selecciona una conversión", SwingConstants.CENTER));
        add(campoCantidad);
        add(panelBotones);
        add(resultadoLabel);

        // Acción: convertir a euros
        btnAEuros.addActionListener(e -> convertir("euros"));

        // Acción: convertir a pesetas
        btnAPesetas.addActionListener(e -> convertir("pesetas"));

        // Acción: borrar campos
        btnBorrar.addActionListener(e -> {
            campoCantidad.setText("");
            resultadoLabel.setText("Euros(Alt+E) Pesetas(Alt+P) Borrar(Alt+B)");
        });

        // Permitir presionar Enter para convertir
        campoCantidad.addActionListener(e -> convertir("euros")); // por defecto a euros

        setVisible(true);
    }

    private void convertir(String tipo) {
        try {
            double cantidad = Double.parseDouble(campoCantidad.getText());

            if (tipo.equals("euros")) {
                double resultado = cantidad / TASA_CAMBIO;
                resultadoLabel.setText(String.format("%.2f pesetas = %.2f euros", cantidad, resultado));
            } else {
                double resultado = cantidad * TASA_CAMBIO;
                resultadoLabel.setText(String.format("%.2f euros = %.2f pesetas", cantidad, resultado));
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Numero no valido.\nPor favor introduce un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(T20_08::new);
    }
}
