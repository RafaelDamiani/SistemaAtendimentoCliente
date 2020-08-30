CREATE TABLE tb_atendimento(
	id_atendimento SERIAL PRIMARY KEY,
	data_atendimento timestamp,
	descricao_atendimento VARCHAR(255),
	nome VARCHAR(255),
	solucao_apresentada VARCHAR(255),
	situacao_atendimento VARCHAR(255),
	id_produto int,
	id_usuario int,
	id_tipo_atendimento int,
	CONSTRAINT fk_atendimento_produto FOREIGN KEY (id_produto) REFERENCES tb_produto(id_produto),
	CONSTRAINT fk_atendimento_usuario FOREIGN KEY (id_usuario) REFERENCES tb_usuario(id_usuario),
	CONSTRAINT fk_atendimento_tipo_atendimento FOREIGN KEY (id_tipo_atendimento) REFERENCES tb_tipo_atendimento(id_tipo_atendimento)
); 