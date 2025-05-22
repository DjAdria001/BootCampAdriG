-- 1
SELECT * FROM Almacenes;

-- 2
SELECT * FROM Cajas WHERE Valor > 150;

-- 3
SELECT DISTINCT Contenido FROM Cajas;

-- 4
SELECT AVG(Valor) AS ValorMedio FROM Cajas;

-- 5
SELECT Almacen, AVG(Valor) AS ValorMedio
FROM Cajas
GROUP BY Almacen;

-- 6
SELECT Almacen
FROM Cajas
GROUP BY Almacen
HAVING AVG(Valor) > 150;

-- 7
SELECT C.NumReferencia, A.Lugar
FROM Cajas C
JOIN Almacenes A ON C.Almacen = A.Codigo;

-- 8
SELECT Almacen, COUNT(*) AS NumCajas
FROM Cajas
GROUP BY Almacen;

-- 9
SELECT A.Codigo
FROM Almacenes A
JOIN (
    SELECT Almacen, COUNT(*) AS NumCajas
    FROM Cajas
    GROUP BY Almacen
) C ON A.Codigo = C.Almacen
WHERE C.NumCajas > A.Capacidad;

-- 10
SELECT C.NumReferencia
FROM Cajas C
JOIN Almacenes A ON C.Almacen = A.Codigo
WHERE A.Lugar = 'Bilbao';

-- 11
INSERT INTO Almacenes (Lugar, Capacidad)
VALUES ('Barcelona', 3);

-- 12
INSERT INTO Cajas (NumReferencia, Contenido, Valor, Almacen)
VALUES ('H5RT', 'Papel', 200, 2);

-- 13
UPDATE Cajas
SET Valor = Valor * 0.85;

-- 14
UPDATE Cajas
SET Valor = Valor * 0.80
WHERE Valor > (SELECT AVG(Valor) FROM Cajas);

-- 15
DELETE FROM Cajas
WHERE Valor < 100;

-- 16
UPDATE Cajas
SET Contenido = NULL
WHERE Almacen IN (
    SELECT A.Codigo
    FROM Almacenes A
    JOIN (
        SELECT Almacen, COUNT(*) AS NumCajas
        FROM Cajas
        GROUP BY Almacen
    ) C ON A.Codigo = C.Almacen
    WHERE C.NumCajas > A.Capacidad
);
