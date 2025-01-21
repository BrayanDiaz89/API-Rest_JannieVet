create table consultas(
        id bigint not null auto_increment,
        precioConsulta FLOAT(10,2) NOT NULL,
        fecha datetime not null,
        motivoCancelamiento varchar(100),
        id_veterinario bigint not null,
        id_paciente bigint not null,

        primary key(id),
        constraint fk_consultas_id_veterinario foreign key(id_veterinario) references veterinarios(id),
        constraint fk_consultas_id_paciente foreign key(id_paciente) references pacientes(id)
        );