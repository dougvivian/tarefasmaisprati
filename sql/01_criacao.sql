-- Exercicio 2 - criacao das tabelas da biblioteca
-- emprestimo tem que ser por ultimo senao da erro na FK

CREATE TABLE item (
    id         INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY, -- nada de SERIAL, isso aqui que é o moderno
    codigo     VARCHAR(20)  NOT NULL UNIQUE,
    titulo     VARCHAR(200) NOT NULL,
    tipo       VARCHAR(20)  NOT NULL CHECK (tipo IN ('livro', 'revista')),
    autor      VARCHAR(150),  -- revista as vezes nao tem autor, entao pode ser null
    edicao     VARCHAR(50),
    disponivel BOOLEAN NOT NULL DEFAULT TRUE
);

CREATE TABLE usuario (
    id           INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nome         VARCHAR(150) NOT NULL,
    tipo         VARCHAR(20)  NOT NULL CHECK (tipo IN ('aluno', 'professor')),
    limite_itens INT NOT NULL CHECK (limite_itens > 0)
);

CREATE TABLE emprestimo (
    id                      INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    item_id                 INT NOT NULL REFERENCES item(id),
    usuario_id              INT NOT NULL REFERENCES usuario(id),
    data_retirada           DATE NOT NULL DEFAULT CURRENT_DATE,
    data_devolucao_prevista DATE NOT NULL,
    data_devolucao          DATE, -- sem NOT NULL pq fica vazio ate devolver
    valor_multa             NUMERIC(10, 2) NOT NULL DEFAULT 0
);
