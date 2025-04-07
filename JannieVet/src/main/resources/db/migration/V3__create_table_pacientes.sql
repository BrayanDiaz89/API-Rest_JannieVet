create table pacientes(
        id bigint not null auto_increment,
        nombrePaciente varchar(100) not null,
        edad int not null,
        especie varchar(25) not null,
        raza varchar(50) not null,
        peso decimal(10,2) NOT NULL,
        color varchar(50) not null,
        fechaNacimiento datetime not null,
        activo tinyint,
        id_clienteAmo bigint not null,

        primary key(id),
        constraint fk_pacientes_id_clienteAmo foreign key(id_clienteAmo) references clientes(id)
        );