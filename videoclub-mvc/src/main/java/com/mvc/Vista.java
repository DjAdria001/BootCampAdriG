package com.mvc;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Vista extends JFrame {

    private JTextArea areaTexto;
    private JButton botonActualizar;

    public Vista() {
        setTitle("Gestión de Empleados");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        areaTexto = new JTextArea();
        botonActualizar = new JButton("Actualizar");

        add(new JScrollPane(areaTexto), BorderLayout.CENTER);
        add(botonActualizar, BorderLayout.SOUTH);
    }

    public void mostrarEmpleados(List<String> empleados) {
        areaTexto.setText("");
        for (String nombre : empleados) {
            areaTexto.append(nombre + "\n");
        }
    }

    public JButton getBotonActualizar() {
        return botonActualizar;
    }
}
