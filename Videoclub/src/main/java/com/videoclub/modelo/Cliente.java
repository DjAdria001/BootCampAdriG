package com.videoclub.modelo;

import java.sql.Date;

public class Cliente {
    private int id;
    private String nombre;
    private String apellido;
    private String direccion;
    private int dni;
    private Date fecha;

    public Cliente(int id, String nombre, String apellido, String direccion, int dni, Date fecha) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.dni = dni;
        this.fecha = fecha;
    }
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public int getDni() {
        return dni;
    }

    public Date getFecha() {
        return fecha;
    }
}
