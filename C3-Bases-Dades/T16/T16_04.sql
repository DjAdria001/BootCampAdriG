-- 1
SELECT Nombre FROM Peliculas;

-- 2
SELECT DISTINCT CalificacionEdad FROM Peliculas;

-- 3
SELECT * FROM Peliculas WHERE CalificacionEdad IS NULL;

-- 4
SELECT * FROM Salas WHERE Pelicula IS NULL;

-- 5
SELECT Salas.*, Peliculas.Nombre AS PeliculaNombre, Peliculas.CalificacionEdad
FROM Salas
LEFT JOIN Peliculas ON Salas.Pelicula = Peliculas.Codigo;

-- 6
SELECT Peliculas.*, Salas.Nombre AS SalaNombre
FROM Peliculas
LEFT JOIN Salas ON Peliculas.Codigo = Salas.Pelicula;

-- 7
SELECT Nombre
FROM Peliculas
WHERE Codigo NOT IN (
    SELECT Pelicula FROM Salas WHERE Pelicula IS NOT NULL
);

-- 8
INSERT INTO Peliculas (Nombre, CalificacionEdad)
VALUES ('Uno, Dos, Tres', 7);

-- 9
UPDATE Peliculas
SET CalificacionEdad = 13
WHERE CalificacionEdad IS NULL;

-- 10
DELETE FROM Salas
WHERE Pelicula IN (
    SELECT Codigo FROM Peliculas WHERE CalificacionEdad = 3
);
