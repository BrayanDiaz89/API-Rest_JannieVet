create table pacientes(
        id bigint not null auto_increment,
        nombrePaciente varchar(100) not null,
        edad int not null,
        raza varchar(100) not null,
        peso float(10,2) NOT NULL,
        color varchar(50) not null,
        mesCumpleaños varchar(100) not null,
        id_clienteAmo bigint not null,

        primary key(id),
        constraint fk_pacientes_id_clienteAmo foreign key(id_clienteAmo) references clientes(id)
        );