import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class T20_03 extends JFrame {

    private int contador1 = 0;
    private int contador2 = 0;

    private JLabel etiqueta1;
    private JLabel etiqueta2;

    public T20_03() {
        setTitle("Contador Botones");
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(2, 2)); // Dos filas, dos columnas
        setResizable(false);
        setLocationRelativeTo(null); // Centrar en pantalla

        // Inicializar etiquetas
        etiqueta1 = new JLabel("Botón 1 clics: 0");
        etiqueta2 = new JLabel("Botón 2 clics: 0");

        // Inicializar botones
        JButton boton1 = new JButton("Botón 1");
        JButton boton2 = new JButton("Botón 2");

        // Añadir acción a los botones
        boton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                contador1++;
                etiqueta1.setText("Botón 1 clics: " + contador1);
            }
        });

        boton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                contador2++;
                etiqueta2.setText("Botón 2 clics: " + contador2);
            }
        });

        // Añadir componentes a la ventana
        add(etiqueta1);
        add(boton1);
        add(etiqueta2);
        add(boton2);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new T20_03());
    }
}
