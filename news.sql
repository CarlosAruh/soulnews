CREATE DATABASE IF NOT EXISTS noticias_db;

use noticias_db;

create table if not exists usuarios(
	id_usuario int auto_increment primary key,
	nome varchar(100) not null,
	email varchar(180)not null unique,
	data_nascimento date not null,
	telefone varchar(20) not null,
	cpf varchar(11) not null unique
);

CREATE TABLE IF NOT EXISTS noticias(
    id_noticia INT AUTO_INCREMENT PRIMARY KEY,
    topico varchar(50) NOT NULL,
    titulo VARCHAR(255) NOT NULL UNIQUE,
    caminho_imagem varchar(200) not null,
    conteudo VARCHAR(4000),
    data_publicacao DATE NOT NULL,
    categoria VARCHAR(50) not null,
    fonte varchar(100)not null
);

CREATE TABLE IF NOT EXISTS favoritas (
    id_favoritas INT AUTO_INCREMENT PRIMARY KEY,
    fk_usuario INT not null,
    fk_noticia INT not null,
    data_adicao date not null,
    CONSTRAINT fk_usuario FOREIGN KEY (fk_usuario) REFERENCES usuarios(id_usuario),
    CONSTRAINT fk_noticia FOREIGN KEY (fk_noticia) REFERENCES noticias(id_noticia),
    UNIQUE KEY unique_usuario_favorita (fk_usuario, fk_noticia)
);

CREATE TABLE IF NOT EXISTS salvos (
    id_salvo INT AUTO_INCREMENT PRIMARY KEY,
    fk_usuario_salvo INT NOT NULL,
    fk_noticia_salvo INT NOT NULL,
    data_adicao date NOT NULL,
    CONSTRAINT fk_usuario_salvo FOREIGN KEY (fk_usuario_salvo) REFERENCES usuarios(id_usuario),
    CONSTRAINT fk_noticia_salvo FOREIGN KEY (fk_noticia_salvo) REFERENCES noticias(id_noticia),
    UNIQUE KEY unique_usuario_lista (fk_usuario_salvo, fk_noticia_salvo)
);

SHOW CREATE TABLE assuntos;
describe table noticias;

drop table temas;

DELETE FROM NOTICIAS;


DESCRIBE noticias;

use soulib_db

SELECT * FROM noticias;




drop database noticias_db;

INSERT INTO favoritas (fk_usuario, fk_noticia, data_adicao) 
VALUES (1, 1, '2024-02-01');