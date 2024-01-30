CREATE DATABASE IF NOT EXISTS noticias_db;

use noticias_db;

CREATE TABLE IF NOT EXISTS noticias(
    id_noticia INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL UNIQUE,
    conteudo VARCHAR(4000),
    data_publicacao DATE NOT NULL,
    fk_assunto_id INT, -- Adicione a coluna id_assunto
    CONSTRAINT fk_noticias_assunto foreign key (fk_assunto_id) REFERENCES assuntos(id_assunto)
);

create table if not exists assuntos(
	id_assunto INT PRIMARY KEY,
	nome_assunto VARCHAR(100) not null
);

create table if not exists usuarios(
	id_usuario int auto_increment primary key,
	nome varchar(100) not null,
	email varchar(180)not null unique,
	data_nascimento date not null,
	telefone varchar(20) not null,
	cpf varchar(11) not null unique
);

CREATE TABLE IF NOT EXISTS temas_favoritos (
    fk_usuario_id INT,
    fk_assunto_id INT,
    PRIMARY KEY (fk_usuario_id, fk_assunto_id),
    CONSTRAINT fk_temas_favoritos_usuario FOREIGN KEY (fk_usuario_id) REFERENCES usuarios(id_usuario),
    CONSTRAINT fk_temas_favoritos_assunto FOREIGN KEY (fk_assunto_id) REFERENCES assuntos(id_assunto)
);



SHOW CREATE TABLE assuntos;
describe table assuntos;

drop table assuntos;


drop database noticias_db;
