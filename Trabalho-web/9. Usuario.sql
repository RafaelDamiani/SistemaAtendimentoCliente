CREATE TABLE tb_usuario (
    id_usuario SERIAL PRIMARY KEY,
    nome VARCHAR(100), 
    cpf VARCHAR(11),
    email VARCHAR(100) UNIQUE,
    telefone VARCHAR(11), 
    nome_rua VARCHAR(11),
    numero_rua INT,  
    senha VARCHAR(200),
    complemento VARCHAR(100),
    bairro VARCHAR(30),
    cep VARCHAR(8),
    tipo_usuario CHAR(1) CHECK (tipo_usuario IN ('c', 'f', 'g')),
    ativo_usuario BOOLEAN DEFAULT true
);

INSERT INTO tb_usuario (email_usuario, senha_usuario, id_referencia, tipo_usuario) VALUES ('admin@admin.com', '21232f297a57a5a743894a0e4a801fc3', 1, 'c');
INSERT INTO tb_usuario (email_usuario, senha_usuario, id_referencia, tipo_usuario) VALUES ('organizador@organizador.com', '21232f297a57a5a743894a0e4a801fc3', 1, 'f');
INSERT INTO tb_usuario (email_usuario, senha_usuario, id_referencia, tipo_usuario) VALUES ('comprador@comprador.com', '21232f297a57a5a743894a0e4a801fc3', 1, 'g');