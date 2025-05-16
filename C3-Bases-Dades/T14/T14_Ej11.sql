CREATE DATABASE t14_ej11;
USE t14_ej11;

CREATE TABLE Facultad (
    Codigo INT(11) PRIMARY KEY,
    Nombre VARCHAR(100)
);

CREATE TABLE Investigadores (
    DNI VARCHAR(8) PRIMARY KEY,
    NomApels VARCHAR(255),
    Facultad INT(11),
    FOREIGN KEY (Facultad) REFERENCES Facultad(Codigo)
);

CREATE TABLE Equipos (
    NumSerie CHAR(4) PRIMARY KEY,
    Nombre VARCHAR(100),
    Facultad INT(11),
    FOREIGN KEY (Facultad) REFERENCES Facultad(Codigo)
);

CREATE TABLE Reserva(
    DNI VARCHAR(8) PRIMARY KEY,
    NumSerie CHAR(4) PRIMARY KEY,
    Comienzo DATETIME,
    Fin DATETIME,
    FOREIGN KEY (DNI) REFERENCES Investigadores(DNI),
    FOREIGN KEY (NumSerie) REFERENCES Equipos(NumSerie)
);