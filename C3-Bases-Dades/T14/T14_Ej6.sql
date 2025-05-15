CREATE DATABASE t14_ej6;
USE t14_ej6;

Create TABLE peliculas (
    Codigo INT(11) PRIMARY KEY,
    Nombre VARCHAR(100),
    CalificacionEdad INT(11)
);

CREATE TABLE salas (
    Codigo INT(11) PRIMARY KEY,
    Nombre VARCHAR(100),
    Pelicula INT(11)
     FOREIGN KEY (Pelicula) REFERENCES Peliculas(Codigo)
);