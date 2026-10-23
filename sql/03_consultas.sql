-- Exercicio 3 - consultas

-- 1) todo o acervo com codigo, titulo, tipo e se ta disponivel
SELECT codigo, titulo, tipo, disponivel
FROM item
ORDER BY codigo;

-- 2) emprestimos em aberto com nome do usuario e titulo do item
-- IS NULL e nao = NULL (aprendi isso apanhando)
SELECT u.nome AS usuario,
       i.titulo AS item,
       e.data_retirada,
       e.data_devolucao_prevista
FROM emprestimo e
JOIN usuario u ON u.id = e.usuario_id
JOIN item i ON i.id = e.item_id
WHERE e.data_devolucao IS NULL;

-- 3) total de multa de cada usuario
-- LEFT JOIN pra aparecer quem nao tem multa tbm, o COALESCE troca null por 0
SELECT u.nome,
       COALESCE(SUM(e.valor_multa), 0) AS total_multas
FROM usuario u
LEFT JOIN emprestimo e ON e.usuario_id = u.id
GROUP BY u.id, u.nome
ORDER BY total_multas DESC;

-- 4) itens que nunca foram emprestados
-- o LEFT JOIN traz todos os itens, os que nao acharam emprestimo ficam com e.id null
SELECT i.codigo, i.titulo, i.tipo
FROM item i
LEFT JOIN emprestimo e ON e.item_id = i.id
WHERE e.id IS NULL;
