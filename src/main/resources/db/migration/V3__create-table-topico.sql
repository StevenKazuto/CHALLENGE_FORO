CREATE TABLE topicos(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL UNIQUE,
    mensaje VARCHAR(255) NOT NULL UNIQUE,
    fecha VARCHAR(255) NOT NULL,
    status tinyint NOT NULL,
    autor_nick VARCHAR(255) NOT NULL,
    curso VARCHAR(255) NOT NULL);