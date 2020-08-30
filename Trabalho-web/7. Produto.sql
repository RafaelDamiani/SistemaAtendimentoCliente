CREATE TABLE tb_produto(
	id_produto SERIAL PRIMARY KEY,
	nome_produto VARCHAR(255),
	descricao_produto VARCHAR(255),
	peso_produto int,
	id_categoria int,
	CONSTRAINT fk_produto_categoria foreign key (id_categoria) REFERENCES tb_categoria(id_categoria)
);