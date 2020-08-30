CREATE TABLE tb_usuario (
    id_usuario SERIAL PRIMARY KEY,
    email VARCHAR(100) UNIQUE,
    senha VARCHAR(200),
	nome VARCHAR(100),
	cpf VARCHAR(11),
	telefone VARCHAR(11),
    cep VARCHAR(8),
	nome_rua VARCHAR(11),
    numero_rua INT,
    complemento VARCHAR(100),
    bairro VARCHAR(30),
    tipo_usuario CHAR(1) CHECK (tipo_usuario IN ('c', 'f', 'g')),
    ativo_usuario BOOLEAN DEFAULT true,
	id_cidade int,
	CONSTRAINT fk_usuario_cidade FOREIGN KEY (id_cidade) REFERENCES tb_cidade(id_cidade)
);

INSERT INTO tb_usuario (email, senha, tipo_usuario) VALUES ('admin@admin.com', '21232f297a57a5a743894a0e4a801fc3', 'c');
INSERT INTO tb_usuario (email, senha, tipo_usuario) VALUES ('organizador@organizador.com', '21232f297a57a5a743894a0e4a801fc3', 'f');
INSERT INTO tb_usuario (email, senha, tipo_usuario) VALUES ('comprador@comprador.com', '21232f297a57a5a743894a0e4a801fc3', 'g');