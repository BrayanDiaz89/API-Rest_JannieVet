create table clientes(
        id bigint not null auto_increment,
        documento bigint not null unique,
        nombreCompleto varchar(120) not null,
        numeroTelefonico bigint not null unique,
        email varchar(100) not null unique,
        ciudad varchar(100) not null,
        codigoPostal int not null,
        calle varchar(30) not null,
        numero varchar(30) not null,
        complemento varchar(50) not null,
        fecha datetime not null,
        activo tinyint,

        primary key(id)
        );