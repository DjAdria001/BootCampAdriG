CREATE TABLE DESPACHOS (
    Numero INT PRIMARY KEY,
    Capacidad INT NOT NULL
);

CREATE TABLE DIRECTORES (
    DNI VARCHAR(8) PRIMARY KEY,
    NomApels NVARCHAR(255) NOT NULL,
    DNIJefe VARCHAR(8),
    Despacho INT,
    FOREIGN KEY (DNIJefe) REFERENCES DIRECTORES(DNI),
    FOREIGN KEY (Despacho) REFERENCES DESPACHOS(Numero)
);

INSERT INTO DESPACHOS (Numero, Capacidad) VALUES
(101, 3),
(102, 2),
(103, 4),
(104, 1),
(105, 2),
(106, 3),
(107, 5),
(108, 2),
(109, 1),
(110, 4);

INSERT INTO DIRECTORES (DNI, NomApels, DNIJefe, Despacho) VALUES
('12345678', 'Laura Martínez',     NULL, 101),
('87654321', 'Carlos Gómez',       NULL, 102),
('11223344', 'María Rodríguez',    NULL, 103),
('44332211', 'Juan Pérez',         NULL, 104),
('99887766', 'Ana Torres',    '12345678', 105),
('66778899', 'Pedro Sánchez', '87654321', 106),
('55667788', 'Lucía Moreno',  '11223344', 107),
('33445566', 'Alberto Ruiz',  '44332211', 108),
('22113344', 'Sara López',    '12345678', 109),
('77889900', 'David Ramírez', '99887766', 110);
