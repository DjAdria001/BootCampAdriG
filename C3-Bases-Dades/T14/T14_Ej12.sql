CREATE DATABASE t14_ej12;
USE t14_ej12;

CREATE TABLE profesores (
    DNI INT(11) PRIMARY KEY,
    Nombre VARCHAR(255) NOT NULL UNIQUE,
    Apellido1 VARCHAR(255),
    Apellido2 VARCHAR(255),
    Direccion VARCHAR(255),
    Titulacion VARCHAR(100),
    Cuota_Por_Hora INT(11) NOT NULL, 
    CONSTRAINT nombre_profesor UNIQUE (Nombre) 
);


CREATE TABLE curso (
    Codigo INT(11) PRIMARY KEY,
    Nombre VARCHAR(100) NOT NULL UNIQUE, 
    NumeroMaximoAlumnos INT(60),
    Profesor INT(11),
    FechaInicio DATE,
    FechaFinal DATE,
    Horas INT(11) NOT NULL,  
    
    FOREIGN KEY (Profesor) REFERENCES profesores(DNI),
    CHECK (FechaInicio <= FechaFinal)  
);


CREATE TABLE alumnos (
    DNI INT(11) PRIMARY KEY,
    Nombre VARCHAR(100) NOT NULL,
    Apellido1 VARCHAR(255),
    Apellido2 VARCHAR(255),
    Direccion INT(11),
    FechaNacimiento DATE,
    Sexo CHAR(1) NOT NULL CHECK (Sexo IN ('H', 'M')), 
    Curso INT(11) NOT NULL,  
    
    FOREIGN KEY (Curso) REFERENCES curso(Codigo)
);
