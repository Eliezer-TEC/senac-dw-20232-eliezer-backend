drop schema EXEMPLOS;

CREATE SCHEMA EXEMPLOS;
USE EXEMPLOS;

CREATE TABLE exemplos.fabricantes (
	id int auto_increment NOT NULL,
	nome varchar(400) NOT NULL,
	cnpj varchar (14) not null,
	cidade varchar(400) not null,
	cep varchar(9) not null,
	uf varchar(2) not null,
	CONSTRAINT fabricantes_pk PRIMARY KEY (id)
);

CREATE TABLE exemplos.produtos (
	id int auto_increment NOT NULL,
	nome varchar(400) NOT NULL,
	id_fabricante int NOT NULL,
	valor DECIMAL NOT NULL,
	peso DECIMAL NOT NULL,
	data_cadastro DATE NOT NULL,
	CONSTRAINT produtos_pk PRIMARY KEY (id),
	CONSTRAINT id_fabricante foreign key (id_fabricante) references exemplos.fabricantes(ID)
);



INSERT INTO exemplos.fabricantes (nome, cnpj, cidade, cep, uf)
VALUES('Ouro', '1122233344422', 'São Paulo', '88475030', 'SP');

INSERT INTO exemplos.fabricantes (nome, cnpj, cidade, cep, uf)
VALUES('Pelé', '2222233344422', 'Rio de Janeiro', '82175030', 'RJ');

INSERT INTO exemplos.fabricantes (nome, cnpj, cidade, cep, uf)
VALUES('Havaianas', '3322233344422', 'Rio de Janeiro', '32175030', 'RJ');

INSERT INTO exemplos.fabricantes (nome, cnpj, cidade, cep, uf)
VALUES('Rider', '4422233344422','Santa Catarina', '82121030', 'SC');

INSERT INTO exemplos.produtos (nome, id_fabricante, valor, peso, data_cadastro)
VALUES('Café', 1, 12.5, 0.5, sysdate());

INSERT INTO exemplos.produtos (nome, id_fabricante, valor, peso, data_cadastro)
VALUES('Café', 2, 10.0, 0.5, sysdate());

INSERT INTO exemplos.produtos (nome, id_fabricante, valor, peso, data_cadastro)
VALUES('Chinela de tira', 3, 80.5, 0.2, sysdate());

INSERT INTO exemplos.produtos (nome, id_fabricante, valor, peso, data_cadastro)
VALUES('Chinela pesada', 4, 70.2, 0.3, sysdate());

