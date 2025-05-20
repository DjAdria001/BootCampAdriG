INSERT INTO Facultad (Codigo, Nombre) VALUES
(1, 'Ingeniería'),
(2, 'Medicina'),
(3, 'Ciencias'),
(4, 'Derecho'),
(5, 'Psicología'),
(6, 'Economía'),
(7, 'Arquitectura'),
(8, 'Filosofía'),
(9, 'Educación'),
(10, 'Química');

INSERT INTO Investigadores (DNI, NomApels, Facultad) VALUES
('11111111', 'Laura Martínez', 1),
('22222222', 'Carlos Gómez', 2),
('33333333', 'María Rodríguez', 3),
('44444444', 'Juan Pérez', 4),
('55555555', 'Ana Torres', 5),
('66666666', 'Pedro Sánchez', 6),
('77777777', 'Lucía Moreno', 7),
('88888888', 'Alberto Ruiz', 8),
('99999999', 'Sara López', 9),
('12345678', 'David Ramírez', 10);

INSERT INTO Equipos (NumSerie, Nombre, Facultad) VALUES
('E001', 'Microscopio', 1),
('E002', 'Centrífuga', 2),
('E003', 'Ordenador', 3),
('E004', 'Impresora 3D', 4),
('E005', 'Telescopio', 5),
('E006', 'Osciloscopio', 6),
('E007', 'Silla Ergonómica', 7),
('E008', 'Lámpara UV', 8),
('E009', 'Tablet', 9),
('E010', 'Proyector', 10);

INSERT INTO Reserva (DNI, NumSerie, Comienzo, Fin) VALUES
('11111111', 'E001', '2025-05-20 08:00:00', '2025-05-20 10:00:00'),
('22222222', 'E002', '2025-05-20 09:00:00', '2025-05-20 11:00:00'),
('33333333', 'E003', '2025-05-20 10:00:00', '2025-05-20 12:00:00'),
('44444444', 'E004', '2025-05-20 11:00:00', '2025-05-20 13:00:00'),
('55555555', 'E005', '2025-05-20 12:00:00', '2025-05-20 14:00:00'),
('66666666', 'E006', '2025-05-20 13:00:00', '2025-05-20 15:00:00'),
('77777777', 'E007', '2025-05-20 14:00:00', '2025-05-20 16:00:00'),
('88888888', 'E008', '2025-05-20 15:00:00', '2025-05-20 17:00:00'),
('99999999', 'E009', '2025-05-20 16:00:00', '2025-05-20 18:00:00'),
('12345678', 'E010', '2025-05-20 17:00:00', '2025-05-20 19:00:00');
