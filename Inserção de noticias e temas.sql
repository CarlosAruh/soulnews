-- Inserir uma notícia
INSERT INTO noticias (titulo, conteudo, data_publicacao) VALUES ('Título da Notícia', 'Conteúdo da Notícia', '2024-01-31 12:00:00');

-- Obter o ID da notícia inserida
SET @id_noticia = LAST_INSERT_ID();

-- Inserir temas associados à notícia
INSERT INTO noticias_temas (id_noticia, id_tema) VALUES (@id_noticia, 1);  -- Substitua 1 pelo ID do tema desejado
INSERT INTO noticias_temas (id_noticia, id_tema) VALUES (@id_noticia, 2);  -- Substitua 2 pelo ID do outro tema desejado

create table if not exists temas(
	id_temas INT AUTO_INCREMENT PRIMARY KEY,
    nome_tema VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS noticias_temas (
    id_noticia_tema INT PRIMARY KEY,
    fk_noticia INT NOT NULL,
    fk_tema INT NOT NULL,
    CONSTRAINT fk_noticias_temas_noticia FOREIGN KEY (fk_noticia) REFERENCES noticias(id_noticia),
    CONSTRAINT fk_noticias_temas_tema FOREIGN KEY (fk_tema) REFERENCES temas(id_temas),
    UNIQUE KEY unique_noticia_tema (fk_noticia, fk_tema)
);

INSERT INTO temas (id_temas, nome_tema)
VALUES
  (1, 'Ciência'),
  (2, 'Saúde'),
  (3, 'Tecnologia'),
  (4, 'Entretenimento'),
  (5, 'Arqueologia'),
  (6, 'Moda'),
  (7, 'Negócios'),
  (8, 'Astronomia'),
  (9, 'Esportes'),
  (10, 'Literatura');