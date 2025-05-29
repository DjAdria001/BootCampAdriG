package com.mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador {

    private Modelo modelo;
    private Vista vista;

    public Controlador(Modelo modelo, Vista vista) {
        this.modelo = modelo;
        this.vista = vista;

        vista.getBotonActualizar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarVista();
            }
        });
    }

    public void iniciar() {
        modelo.iniciarConexion();
        vista.setVisible(true);
        actualizarVista();
    }

    private void actualizarVista() {
        vista.mostrarEmpleados(modelo.obtenerEmpleados());
    }
}
