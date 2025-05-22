-- 1
SELECT Apellidos FROM Empleados;

-- 2
SELECT DISTINCT Apellidos FROM Empleados;

-- 3
SELECT * FROM Empleados WHERE Apellidos = 'López';

-- 4
SELECT * FROM Empleados WHERE Apellidos IN ('López', 'Pérez');

-- 5
SELECT * FROM Empleados WHERE Departamento = 14;

-- 6
SELECT * FROM Empleados WHERE Departamento IN (37, 77);

-- 7
SELECT * FROM Empleados WHERE Apellidos LIKE 'P%';

-- 8
SELECT SUM(Presupuesto) AS PresupuestoTotal FROM Departamentos;

-- 9
SELECT Departamento, COUNT(*) AS NumeroEmpleados
FROM Empleados
GROUP BY Departamento;

-- 10
SELECT *
FROM Empleados E
JOIN Departamentos D ON E.Departamento = D.Codigo;

-- 11
SELECT E.Nombre, E.Apellidos, D.Nombre AS Departamento, D.Presupuesto
FROM Empleados E
JOIN Departamentos D ON E.Departamento = D.Codigo;

-- 12
SELECT E.Nombre, E.Apellidos
FROM Empleados E
JOIN Departamentos D ON E.Departamento = D.Codigo
WHERE D.Presupuesto > 60000;

-- 13
SELECT *
FROM Departamentos
WHERE Presupuesto > (SELECT AVG(Presupuesto) FROM Departamentos);

-- 14
SELECT D.Nombre
FROM Departamentos D
JOIN Empleados E ON D.Codigo = E.Departamento
GROUP BY D.Nombre
HAVING COUNT(*) > 2;

-- 15
INSERT INTO Departamentos (Codigo, Nombre, Presupuesto)
VALUES (11, 'Calidad', 40000);

INSERT INTO Empleados (DNI, Nombre, Apellidos, Departamento)
VALUES ('89267109', 'Esther', 'Vázquez', 11);

-- 16
UPDATE Departamentos
SET Presupuesto = Presupuesto * 0.9;

-- 17
UPDATE Empleados
SET Departamento = 14
WHERE Departamento = 77;

-- 18
DELETE FROM Empleados
WHERE Departamento = 14;

-- 19
DELETE FROM Empleados
WHERE Departamento IN (
    SELECT Codigo
    FROM Departamentos
    WHERE Presupuesto > 60000
);

-- 20
DELETE FROM Empleados;
