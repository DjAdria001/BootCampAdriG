CREATE DATABASE t14_ej5;
USE t14_ej5;

CREATE TABLE almacenes (
    Codigo INT(11) PRIMARY KEY,
    Nombre VARCHAR(100),
    Direccion INT(11)
);
Create TABLE cajas (
    NumReferencia CHAR(5) PRIMARY KEY,
    Contenido VARCHAR(100),
    Valor INT(11),
    Almacen INT(11),
    FOREIGN KEY (Almacen) REFERENCES almacenes(Codigo)
);