CREATE DATABASE t14_ej8;
USE t14_ej8;

CREATE TABLE Piezas (
    Codigo INT(11) PRIMARY KEY,
    Nombre VARCHAR(100)
);
CREATE TABLE Proveedores (
    ID CHAR(4) PRIMARY KEY,
    Nombre VARCHAR(100)
);
CREATE TABLE Suministra (
    CodigoPieza INT(11), 
    IDProveedor CHAR(4),
    Precio INT(11),
    PRIMARY KEY (CodigoPieza, IDProveedor),
    FOREIGN KEY (CodigoPieza) REFERENCES Piezas(Codigo),
    FOREIGN KEY (IDProveedor) REFERENCES Proveedores(ID)
);