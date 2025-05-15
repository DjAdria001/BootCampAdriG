CREATE DATABASE t14_ej1;
USE t14_ej1;

CREATE TABLE estacion (
    Identificador INT(11) PRIMARY KEY,
    Latitud DECIMAL(10,0),
    Longitud DECIMAL(10,0),
    Altitud INT(11)
);

CREATE TABLE muestra (
    IdentificadorEstacion INT(11),
    Fecha DATE,
    Temperatura_minima DECIMAL(10,0),
    Temperatura_maxima DECIMAL(10,0),
    Precipitaciones DECIMAL(10,0),
    Humedad_minima DECIMAL(10,0),
    Humedad_maxima DECIMAL(10,0),
    Velocidad_viento_minima DECIMAL(10,0),
    Velocidad_viento_maxima DECIMAL(10,0),
    PRIMARY KEY (IdentificadorEstacion, Fecha),
    FOREIGN KEY (IdentificadorEstacion) REFERENCES estacion(Identificador)
);
