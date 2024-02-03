use noticias_db;

INSERT INTO usuarios (nome, email, data_nascimento, telefone, cpf)
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

INSERT INTO noticias (topico, titulo, caminho_imagem, conteudo, data_publicacao, categoria, fonte)
VALUES
  ('Fisica', 'Cientistas Anunciam Descoberta de Nova Partícula', 'imagem1', 'Em uma reviravolta emocionante, cientistas anunciam a descoberta de uma nova partícula subatômica que desafia as teorias atuais da física quântica. A comunidade científica está intrigada com as implicações dessa descoberta.', '2024-02-05', 'Ciência', 'Carlos'),
  ('Oncologia', 'Pesquisadores Alcançam Avanço Promissor no Tratamento do Câncer','imagem2', 'Pesquisadores relatam um avanço significativo no desenvolvimento de uma terapia inovadora para o tratamento do câncer. Os resultados dos testes clínicos são promissores e oferecem esperança para pacientes em todo o mundo.', '2024-02-04','Saúde', 'Marcia'),
  ('Inovação', 'Empresa Lança Novo Dispositivo Revolucionário','imagem3', 'A gigante da tecnologia acaba de lançar seu mais recente dispositivo, prometendo revolucionar a maneira como interagimos com a tecnologia no dia a dia. Os entusiastas aguardam ansiosos para experimentar as inovações apresentadas.', '2024-02-03', 'Tecnologia', 'Jonatas'),
  ('Cinema', 'Novo Filme Blockbuster Domina Bilheterias Mundiais','imagem4', 'O aguardado lançamento do próximo filme da franquia de sucesso supera as expectativas, atraindo multidões aos cinemas e dominando as bilheterias globais. Críticos elogiam a trama envolvente e os efeitos visuais impressionantes.', '2024-02-02', 'Entretenimento', 'Wellington'),
  ('Escavações', 'Arqueólogos Descobrem Cidade Antiga Perdida','imagem5', 'Em uma escavação emocionante, arqueólogos revelam os vestígios de uma antiga cidade perdida há séculos. A descoberta lança luz sobre a vida e a cultura de civilizações antigas até então desconhecidas.', '2024-02-01', 'Arqueologia', 'Jonatas'),
  ('Proxima Estação', 'Estilistas Renomados Antecipam Tendências da Próxima Estação','imagem6', 'Os principais estilistas do mundo da moda revelam suas criações e antecipam as tendências que dominarão a próxima estação. Cores vibrantes, padrões arrojados e designs inovadores são destaque nas passarelas.', '2024-01-31', 'Moda','Marcia'),
  ('Startups', 'Startup Recebe Investimento Milionário para Expansão','imagem7', 'Uma startup inovadora arrecada um investimento significativo em uma rodada de financiamento, visando expandir suas operações globalmente. Os investidores acreditam no potencial disruptivo da empresa no mercado.', '2024-01-30','Negócios', 'Carlos'),
  ('Exoplanetas', 'Astrônomos Identificam Exoplaneta na Zona Habitável','imagem8', 'Em uma descoberta emocionante, astrônomos identificam um exoplaneta localizado na zona habitável de sua estrela-mãe. Essa revelação aumenta as esperanças de encontrar sinais de vida além do nosso sistema solar.', '2024-01-29', 'Astronomia', 'Katiene'),
  ('Atletismo', 'Atleta Quebra Recorde Mundial em Competição','imagem9', 'Um atleta excepcional surpreende o mundo ao quebrar um recorde mundial em sua disciplina durante uma competição internacional. A conquista é saudada como um feito extraordinário no mundo do esporte.', '2024-01-28', 'Esportes', 'Katiene'),
  ('Best-Seller', 'Autor Renomado Lança Novo Livro Best-Seller','imagem10', 'Um autor renomado lança seu mais recente trabalho literário, que rapidamente se torna um best-seller nas listas de livros mais vendidos. Leitores ansiosos elogiam a narrativa envolvente e os personagens cativantes.', '2024-01-27', 'Literatura', 'Wellington');
