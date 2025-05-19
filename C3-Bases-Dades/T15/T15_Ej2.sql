CREATE TABLE PIEZAS (
    Codigo INT IDENTITY PRIMARY KEY,
    Nombre NVARCHAR(100) NOT NULL
);

CREATE TABLE PROVEEDORES (
    Id CHAR(4) PRIMARY KEY,
    Nombre NVARCHAR(100) NOT NULL
);

CREATE TABLE SUMINISTRA (
    CodigoPieza INT,
    IdProveedor CHAR(4),
    Precio INT,
    PRIMARY KEY (CodigoPieza, IdProveedor),
    FOREIGN KEY (CodigoPieza) REFERENCES PIEZAS(Codigo),
    FOREIGN KEY (IdProveedor) REFERENCES PROVEEDORES(Id)
);
INSERT INTO PIEZAS (Nombre) VALUES
('Tornillo'),
('Tuerca'),
('Eje'),
('Motor'),
('Rueda'),
('Chasis'),
('Volante'),
('Freno'),
('Amortiguador'),
('Filtro');
INSERT INTO PROVEEDORES (Id, Nombre) VALUES
('P001', 'Proveedor Uno'),
('P002', 'Proveedor Dos'),
('P003', 'Proveedor Tres'),
('P004', 'Proveedor Cuatro'),
('P005', 'Proveedor Cinco'),
('P006', 'Proveedor Seis'),
('P007', 'Proveedor Siete'),
('P008', 'Proveedor Ocho'),
('P009', 'Proveedor Nueve'),
('P010', 'Proveedor Diez');
INSERT INTO SUMINISTRA (CodigoPieza, IdProveedor, Precio) VALUES
(1, 'P001', 50),
(2, 'P002', 30),
(3, 'P003', 45),
(4, 'P004', 100),
(5, 'P005', 20),
(6, 'P006', 60),
(7, 'P007', 80),
(8, 'P008', 25),
(9, 'P009', 55),
(10, 'P010', 70);
