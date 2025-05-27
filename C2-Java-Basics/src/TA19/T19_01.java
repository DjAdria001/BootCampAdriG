package TA19;

import javax.swing.*;
import java.awt.event.*;

public class T19_01 extends JFrame implements ActionListener {

    private JTextField campoTexto;
    private JButton botonSaludar;

    public T19_01() {
        // Configuracion de la ventana
        setTitle("Saludador");
        setSize(300, 150);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar la ventana

        // Crear y configurar el campo de texto
        campoTexto = new JTextField();
        campoTexto.setBounds(50, 30, 200, 25);
        add(campoTexto);

        // Crear y configurar el boton
        botonSaludar = new JButton("Confirmar");
        botonSaludar.setBounds(100, 70, 100, 30);
        botonSaludar.addActionListener(this);
        add(botonSaludar);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String nombre = campoTexto.getText();
        JOptionPane.showMessageDialog(this, "¡Hola " + nombre + "!");
    }

    public static void main(String[] args) {
        T19_01 ventana = new T19_01();
        ventana.setVisible(true);
    }
}

