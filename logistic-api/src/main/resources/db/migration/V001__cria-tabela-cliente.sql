CREATE TABLE cliente (
	id serial PRIMARY KEY,
	nome VARCHAR ( 60 ) UNIQUE NOT NULL,
	email VARCHAR ( 255 ) UNIQUE NOT NULL,
	telefone VARCHAR ( 20 ) NOT NULL
	);