-- CREAR BASE DE DATOS
CREATE DATABASE bd_galeria;

-- TABLA ARTE
CREATE TABLE arte (
    id_arte SERIAL PRIMARY KEY,
    nombre_arte VARCHAR(100),
    url_arte VARCHAR(255)
);
