CREATE TABLE tb_tipo_atendimento(
	id_tipo_atendimento SERIAL PRIMARY KEY,
	nome_tipo_atendimento VARCHAR(20)
);

insert into tb_tipo_atendimento (nome_tipo_atendimento)
values 
	('Corte de cabelo'),
	('Lavagem'),
	('Pintura'),
	('Manicure'),
	('Hidratação')