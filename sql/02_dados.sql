-- dados de teste
-- nao passa o id pq ele é GENERATED ALWAYS, o banco que gera

INSERT INTO item (codigo, titulo, tipo, autor, edicao, disponivel) VALUES
    ('L001', 'Dom Casmurro',      'livro',   'Machado de Assis', '1a edicao', FALSE), -- ta emprestado
    ('L002', 'O Cortico',         'livro',   'Aluisio Azevedo',  '3a edicao', TRUE),
    ('L003', 'Clean Code',        'livro',   'Robert C. Martin', '1a edicao', TRUE),
    ('R001', 'Superinteressante', 'revista', NULL,               'Ed. 450',   TRUE),
    ('R002', 'Mundo Estranho',    'revista', NULL,               'Ed. 120',   TRUE);

INSERT INTO usuario (nome, tipo, limite_itens) VALUES
    ('Joao',  'aluno',     3),
    ('Maria', 'professor', 5);

-- usei subselect pelo codigo/nome pra nao depender do numero do id
-- emprestimo em aberto: Maria pegou o Dom Casmurro e ainda nao devolveu
INSERT INTO emprestimo (item_id, usuario_id, data_retirada, data_devolucao_prevista, data_devolucao, valor_multa) VALUES
    ((SELECT id FROM item WHERE codigo = 'L001'),
     (SELECT id FROM usuario WHERE nome = 'Maria'),
     '2026-10-15', '2026-10-29', NULL, 0);

-- emprestimo ja devolvido: Joao devolveu a revista 3 dias atrasado (3 x R$1,00)
INSERT INTO emprestimo (item_id, usuario_id, data_retirada, data_devolucao_prevista, data_devolucao, valor_multa) VALUES
    ((SELECT id FROM item WHERE codigo = 'R001'),
     (SELECT id FROM usuario WHERE nome = 'Joao'),
     '2026-10-01', '2026-10-08', '2026-10-11', 3.00);
