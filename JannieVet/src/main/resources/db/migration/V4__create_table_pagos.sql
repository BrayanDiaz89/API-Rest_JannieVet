create table pagos(
        id bigint not null auto_increment,
        cantidad DECIMAL(10,2) NOT NULL,
        tipoDePago varchar(25) NOT NULL,
        estado varchar(25) not null,
        fecha datetime not null,
        comprobante varchar(350),
        id_cliente bigint not null,

        primary key(id),
        constraint fk_pagos_id_cliente foreign key(id_cliente) references clientes(id)

        );