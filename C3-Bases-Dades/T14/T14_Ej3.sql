CREATE DATABASE t14_ej3;
USE t14_ej3;

CREATE TABLE fabricantes (
    Codigo INT(11) PRIMARY KEY,
    Nombre VARCHAR(100)
);

CREATE TABLE articulos (
    Codigo INT(11) PRIMARY KEY,
    Nombre VARCHAR(100),
    Precio INT(11),
    Fabricante INT(11),
    FOREIGN KEY (Fabricante) REFERENCES fabricantes(Codigo)
);
