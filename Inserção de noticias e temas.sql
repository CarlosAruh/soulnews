-- Inserir uma notícia
INSERT INTO noticias (titulo, conteudo, data_publicacao) VALUES ('Título da Notícia', 'Conteúdo da Notícia', '2024-01-31 12:00:00');

-- Obter o ID da notícia inserida
SET @id_noticia = LAST_INSERT_ID();

-- Inserir temas associados à notícia
INSERT INTO noticias_temas (id_noticia, id_tema) VALUES (@id_noticia, 1);  -- Substitua 1 pelo ID do tema desejado
INSERT INTO noticias_temas (id_noticia, id_tema) VALUES (@id_noticia, 2);  -- Substitua 2 pelo ID do outro tema desejado
