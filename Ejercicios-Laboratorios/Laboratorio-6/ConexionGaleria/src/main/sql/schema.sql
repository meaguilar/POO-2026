-- CREAR BASE DE DATOS
CREATE DATABASE bd_galeria;

-- TABLA ARTE
CREATE TABLE arte (
    id_arte     SERIAL PRIMARY KEY,
    nombre_arte VARCHAR(100),
    url_arte    VARCHAR(255)
);

-- Datos de ejemplo (opcional):
-- INSERT INTO arte (nombre_arte, url_arte) VALUES
--   ('La noche estrellada', 'https://picsum.photos/seed/starry/400/300'),
--   ('Paisaje de montana',  'https://picsum.photos/seed/mountain/400/300'),
--   ('Atardecer en la playa','https://picsum.photos/seed/sunset/400/300');
