-- 1
SELECT Nombre FROM Articulos;

-- 2
SELECT Nombre, Precio FROM Articulos;

-- 3
SELECT Nombre FROM Articulos WHERE Precio <= 200;

-- 4
SELECT * FROM Articulos WHERE Precio BETWEEN 60 AND 120;

-- 5
SELECT Nombre, Precio * 166.386 AS PrecioPesetas FROM Articulos;

-- 6
SELECT AVG(Precio) AS PrecioMedio FROM Articulos;

-- 7
SELECT AVG(Precio) AS PrecioMedio FROM Articulos WHERE Fabricante = 2;

-- 8
SELECT COUNT(*) AS Total FROM Articulos WHERE Precio >= 180;

-- 9
SELECT Nombre, Precio FROM Articulos
WHERE Precio >= 180
ORDER BY Precio DESC, Nombre ASC;

-- 10
SELECT * FROM Articulos
JOIN Fabricantes ON Articulos.Fabricante = Fabricantes.Codigo;

-- 11
SELECT Articulos.Nombre AS NombreArticulo, Articulos.Precio, Fabricantes.Nombre AS NombreFabricante
FROM Articulos
JOIN Fabricantes ON Articulos.Fabricante = Fabricantes.Codigo;

-- 12
SELECT Fabricante, AVG(Precio) AS PrecioMedio
FROM Articulos
GROUP BY Fabricante;

-- 13
SELECT Fabricantes.Nombre, AVG(Articulos.Precio) AS PrecioMedio
FROM Articulos
JOIN Fabricantes ON Articulos.Fabricante = Fabricantes.Codigo
GROUP BY Fabricantes.Nombre;

-- 14
SELECT Fabricantes.Nombre
FROM Articulos
JOIN Fabricantes ON Articulos.Fabricante = Fabricantes.Codigo
GROUP BY Fabricantes.Nombre
HAVING AVG(Articulos.Precio) >= 150;

-- 15
SELECT Nombre, Precio FROM Articulos
WHERE Precio = (SELECT MIN(Precio) FROM Articulos);

-- 16
SELECT F.Nombre AS NombreFabricante, A.Nombre AS NombreArticulo, A.Precio
FROM Articulos A
JOIN Fabricantes F ON A.Fabricante = F.Codigo
WHERE A.Precio = (
  SELECT MAX(A2.Precio)
  FROM Articulos A2
  WHERE A2.Fabricante = A.Fabricante
);

-- 17
INSERT INTO Articulos (Nombre, Precio, Fabricante, Codigo)
VALUES ('Altavoces', 70, 2, Codigo);

-- 18
UPDATE Articulos
SET Nombre = 'Impresora Laser'
WHERE Codigo = 8;

-- 19
UPDATE Articulos
SET Precio = Precio * 0.9;

-- 20
UPDATE Articulos
SET Precio = Precio - 10
WHERE Precio >= 120;
