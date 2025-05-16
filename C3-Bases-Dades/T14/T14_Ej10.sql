CREATE DATABASE t14_ej10;
USE t14_ej10;

CREATE TABLE Cajeros (
   Codigo INT(11) PRIMARY KEY,
   NomApels VARCHAR(255)
);

CREATE TABLE Maquinas_Registradoras (
    Codigo INT(11) PRIMARY KEY,
    Piso INT(11)
);

CREATE TABLE Productos (
    Codigo INT(11) PRIMARY KEY,
    Nombre VARCHAR(100),
    Precio INT(11)
);

CREATE TABLE Venta (
    Codigo INT(11) PRIMARY KEY,
    Cajero INT(11) PRIMARY KEY,
    Maquina INT(11) PRIMARY KEY,
    FOREIGN KEY (Cajero) REFERENCES Cajeros(Codigo),
    FOREIGN KEY (Maquina) REFERENCES Maquinas_Registradoras(Codigo),
    FOREIGN KEY (Producto) REFERENCES Productos(Codigo)
);
