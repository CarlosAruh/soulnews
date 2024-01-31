use noticias_db;

data_realizadaINSERT INTO usuarios (nome, email, data_nascimento, telefone, cpf)
VALUES
  ('Alice Silva', 'alice.silva@example.com', '1990-05-15', '123456789', '12345678901'),
  ('Bob Oliveira', 'bob.oliveira@example.com', '1985-10-22', '234567890', '23456789012'),
  ('Carlos Souza', 'carlos.souza@example.com', '1992-03-05', '345678901', '34567890123'),
  ('Daniela Santos', 'daniela.santos@example.com', '1988-07-12', '456789012', '45678901234'),
  ('Eduardo Lima', 'eduardo.lima@example.com', '1994-01-30', '567890123', '56789012345'),
  ('Fernanda Pereira', 'fernanda.pereira@example.com', '1991-11-18', '678901234', '67890123456'),
  ('Gabriel Rocha', 'gabriel.rocha@example.com', '1987-09-08', '789012345', '78901234567'),
  ('Helena Costa', 'helena.costa@example.com', '1993-06-25', '890123456', '89012345678'),
  ('Isaac Santos', 'isaac.santos@example.com', '1986-04-02', '901234567', '90123456789'),
  ('Julia Lima', 'julia.lima@example.com', '1990-08-14', '012345678', '01234567890'),
  ('Kai Pereira', 'kai.pereira@example.com', '1997-02-28', '112233445', '11223344556'),
  ('Laura Souza', 'laura.souza@example.com', '1989-12-07', '223344556', '22334455667'),
  ('Miguel Rocha', 'miguel.rocha@example.com', '1995-09-03', '334455667', '33445566778'),
  ('Nina Oliveira', 'nina.oliveira@example.com', '1984-07-19', '445566778', '44556677889'),
  ('Otávio Costa', 'otavio.costa@example.com', '1998-03-22', '556677889', '55667788990'),
  ('Patrícia Santos', 'patricia.santos@example.com', '1991-01-11', '667788990', '66778899001'),
  ('Quiteria Lima', 'quiteria.lima@example.com', '1986-08-29', '778899001', '77889900112'),
  ('Rafael Rocha', 'rafael.rocha@example.com', '1994-06-16', '889900112', '88990011223'),
  ('Sofia Oliveira', 'sofia.oliveira@example.com', '1983-04-04', '990011223', '99001122334'),
  ('Tiago Costa', 'tiago.costa@example.com', '1997-12-20', '001122334', '00112233445');

INSERT INTO noticias (titulo, conteudo, data_publicacao)
VALUES
  ('Descoberta científica revolucionária', 'Cientistas descobrem uma nova partícula subatômica que pode revolucionar a física moderna.', '2024-01-30 10:00:00'),
  ('Avanço na cura do câncer', 'Pesquisadores anunciam um avanço significativo na busca por uma cura para o câncer.', '2024-01-29 15:30:00'),
  ('Empresa lança novo smartphone', 'A gigante da tecnologia lança seu mais recente modelo de smartphone com recursos inovadores.', '2024-01-28 14:45:00'),
  ('Novo filme blockbuster anunciado', 'O próximo filme da franquia de sucesso é revelado, prometendo ser um sucesso de bilheteria.', '2024-01-27 12:20:00'),
  ('Descoberta arqueológica fascinante', 'Arqueólogos descobrem uma cidade antiga perdida há séculos, revelando insights sobre civilizações antigas.', '2024-01-26 09:15:00'),
  ('Tendências de moda para a próxima estação', 'Estilistas renomados revelam as tendências de moda que dominarão a próxima estação.', '2024-01-25 17:00:00'),
  ('Startup recebe investimento milionário', 'Uma startup inovadora arrecada um investimento significativo para expandir suas operações.', '2024-01-24 11:30:00'),
  ('Descoberta de exoplaneta habitável', 'Astrônomos identificam um exoplaneta na zona habitável, aumentando as esperanças de encontrar vida extraterrestre.', '2024-01-23 08:45:00'),
  ('Atleta quebra recorde mundial', 'Um atleta surpreende o mundo ao quebrar um recorde mundial em sua disciplina.', '2024-01-22 16:10:00'),
  ('Lançamento de novo livro best-seller', 'Um autor renomado lança seu mais recente livro, previsto para se tornar um best-seller.', '2024-01-21 13:00:00');

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