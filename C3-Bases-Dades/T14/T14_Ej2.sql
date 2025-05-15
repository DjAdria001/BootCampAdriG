CREATE DATABASE t14_ej2;
USE t14_ej2;

CREATE TABLE editorial (
    ClaveEditorial SMALLINT(6) PRIMARY KEY,
    Nombre VARCHAR(60),
    Direccion VARCHAR(60),
    Telefono VARCHAR(15)
);

CREATE TABLE autor (
    ClaveAutor INT(11) PRIMARY KEY,
    Nombre VARCHAR(60)
);

CREATE TABLE tema (
    ClaveTema SMALLINT(6) PRIMARY KEY,
    Nombre VARCHAR(40)
);

CREATE TABLE libro (
    ClaveLibro INT(11) PRIMARY KEY,
    Titulo VARCHAR(60),
    Idioma VARCHAR(15),
    Formato VARCHAR(15),
    ClaveEditorial SMALLINT(6),
    FOREIGN KEY (ClaveEditorial) REFERENCES editorial(ClaveEditorial)
);

CREATE TABLE escrito_por (
    ClaveLibro INT(11),
    ClaveAutor INT(11),
    PRIMARY KEY (ClaveLibro, ClaveAutor),
    FOREIGN KEY (ClaveLibro) REFERENCES libro(ClaveLibro),
    FOREIGN KEY (ClaveAutor) REFERENCES autor(ClaveAutor)
);

CREATE TABLE trata_sobre (
    ClaveLibro INT(11),
    ClaveTema SMALLINT(6),
    PRIMARY KEY (ClaveLibro, ClaveTema),
    FOREIGN KEY (ClaveLibro) REFERENCES libro(ClaveLibro),
    FOREIGN KEY (ClaveTema) REFERENCES tema(ClaveTema)
);

CREATE TABLE ejemplar (
    ClaveEjemplar INT(11) PRIMARY KEY,
    ClaveLibro INT(11),
    NumeroOrden SMALLINT(6),
    Edicion SMALLINT(6),
    Ubicacion VARCHAR(15),
);
