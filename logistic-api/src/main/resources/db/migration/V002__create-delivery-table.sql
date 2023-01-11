CREATE TABLE delivery (

	id serial PRIMARY KEY,
	customer_id serial NOT NULL,
	tax decimal(10,2) NOT NULL,
	status VARCHAR ( 20 ) NOT NULL,
	requestDate TIMESTAMP NOT NULL,
	deliveryDate TIMESTAMP,
	
     recipient_name VARCHAR(60) NOT NULL,
     recipient_address VARCHAR(255) NOT NULL,
     recipient_number VARCHAR(30) NOT NULL,
     recipient_complement VARCHAR(60),
     recipient_district VARCHAR (30) NO T NULL
	);

	alter table delivery add constraint fk_delivery_customer foreign key (customer_id) references customer (id);