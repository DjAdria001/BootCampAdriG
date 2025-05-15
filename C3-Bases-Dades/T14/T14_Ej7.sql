CREATE DATABASE t14_ej7;
USE t14_ej7;

CREATE TABLE directores (
    DNI VARCHAR(8) PRIMARY KEY,
    NomApels VARCHAR(255),
    DNIJefe VARCHAR(8),
    Despacho INT(11),
    FOREIGN KEY (DNIJefe) REFERENCES directores(DNI),
    FOREIGN KEY (Despacho) REFERENCES despachos(Numero)
);
Create TABLE despachos (
    Numero INT(11) PRIMARY KEY,
    Capacidad INT(11)
);