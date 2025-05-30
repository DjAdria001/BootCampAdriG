package com.videoclub;

import com.videoclub.modelo.Cliente;
import com.videoclub.modelo.ClienteDAO;

public class Main {
    public static void main(String[] args) {
        ClienteDAO dao = new ClienteDAO();
        Cliente cliente = dao.obtenerClientePorId(1);

        if (cliente != null) {
            System.out.println("Nombre: " + cliente.getNombre());
            System.out.println("Apellido: " + cliente.getApellido());
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }
}
