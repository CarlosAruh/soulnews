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
    topico varchar(30) NOT NULL,
    titulo VARCHAR(255) NOT NULL UNIQUE,
    conteudo VARCHAR(4000),
    data_publicacao DATE NOT NULL,
    categoria VARCHAR(30) not null,
    fonte varchar(100)not null
);

CREATE TABLE IF NOT EXISTS noticias_favoritas (
    id_noticias_favoritas INT AUTO_INCREMENT PRIMARY KEY,
    fk_usuario INT not null,
    fk_noticia INT not null,
    data_adicao date not null,
    CONSTRAINT fk_noticias_favoritos_usuario FOREIGN KEY (fk_usuario) REFERENCES usuarios(id_usuario),
    CONSTRAINT fk_noticias_favoritos_noticias FOREIGN KEY (fk_noticia) REFERENCES noticias(id_noticia),
    UNIQUE KEY unique_usuario_noticia (fk_usuario, fk_noticia)
);

CREATE TABLE IF NOT EXISTS noticias_depois (
    id_noticias_para_depois INT AUTO_INCREMENT PRIMARY KEY,
    fk_usuario INT NOT NULL,
    fk_noticia INT NOT NULL,
    data_adicao date NOT NULL,
    CONSTRAINT fk_noticias_para_ler_usuario FOREIGN KEY (fk_usuario) REFERENCES usuarios(id_usuario),
    CONSTRAINT fk_noticias_para_ler_noticias FOREIGN KEY (fk_noticia) REFERENCES noticias(id_noticia),
    UNIQUE KEY unique_usuario_noticia_ler (fk_usuario, fk_noticia)
);

SHOW CREATE TABLE assuntos;
describe table noticias;

drop table temas;

DELETE FROM NOTICIAS;


DESCRIBE temas

use soulib_db

SELECT * FROM noticias;




drop database noticias_db;