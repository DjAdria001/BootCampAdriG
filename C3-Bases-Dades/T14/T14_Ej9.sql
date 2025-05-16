CREATE DATABASE t14_ej9;
USE t14_ej9;

CREATE TABLE cientificos (
    DNI VARCHAR(8) PRIMARY KEY,
    Nombre VARCHAR(255)
);

CREATE TABLE proyecto (
    ID CHAR(4) PRIMARY KEY,
    Nombre VARCHAR(255)
    Horas INT(11)
);

CREATE TABLE asignado_a (
    Cientifico VARCHAR(8),
    Proyecto CHAR(4),
    PRIMARY KEY (Cientifico, Proyecto),
    FOREIGN KEY (Cientifico) REFERENCES cientificos(DNI),
    FOREIGN KEY (Proyecto) REFERENCES proyecto(ID)
);