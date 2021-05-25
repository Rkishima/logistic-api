create table delivery(
    id bigint not null auto_increment,
    cliente_id bigint not null,
    tax decimal(10,2) not null,
    status varchar(20) not null,
    order_date datetime not null,
    end_date datetime,

    recipient_name varchar(60) not null,
    recipient_public_place varchar(255) not null,
    recipient_number varchar(30) not null,
    recipient_complement varchar (60),
    recipient_district varchar (30) not null,

    primary key (id)

    );

    alter table delivery add constraint fk_delivery_cliente
    foreign key (cliente_id) reference cliente(id);

--    ALterando a tabela delivery, adicionando uma constraint <nome da foreign key>,
--    ai faz a refernecia da coluna (cliente_id) da tabela delivery, que é a tabela que está alterando
--    e referencio a tabela cliente e a chave primária, que é o id.
