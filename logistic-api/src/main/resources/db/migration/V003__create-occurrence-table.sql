CREATE TABLE occurrence (

	id serial PRIMARY KEY,
	delivery_id serial NOT NULL,
	description TEXT NOT NULL,
	registration_date TIMESTAMP NOT NULL
	);

	alter table occurrence add constraint fk_occurrence_delivery foreign key (delivery_id) references delivery (id);