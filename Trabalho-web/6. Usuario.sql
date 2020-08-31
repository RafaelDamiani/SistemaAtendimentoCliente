CREATE TABLE tb_usuario (
    id_usuario SERIAL PRIMARY KEY,
    email VARCHAR(100) UNIQUE,
    senha VARCHAR(200),
	nome VARCHAR(100),
	cpf VARCHAR(11),
	telefone VARCHAR(11),
    cep VARCHAR(8),
	nome_rua VARCHAR(255),
    numero_rua INT,
    complemento VARCHAR(100),
    bairro VARCHAR(30),
    tipo_usuario varchar(1) CHECK (tipo_usuario IN ('c', 'f', 'g')),
    ativo_usuario BOOLEAN DEFAULT true,
	cidade varchar(255)	
);

INSERT INTO tb_usuario (email, senha, tipo_usuario) VALUES ('admin@admin.com', '8C6976E5B5410415BDE908BD4DEE15DFB167A9C873FC4BB8A81F6F2AB448A918', 'c');
INSERT INTO tb_usuario (email, senha, tipo_usuario) VALUES ('organizador@organizador.com', '8C6976E5B5410415BDE908BD4DEE15DFB167A9C873FC4BB8A81F6F2AB448A918', 'f');
INSERT INTO tb_usuario (email, senha, tipo_usuario) VALUES ('comprador@comprador.com', '8C6976E5B5410415BDE908BD4DEE15DFB167A9C873FC4BB8A81F6F2AB448A918', 'g');