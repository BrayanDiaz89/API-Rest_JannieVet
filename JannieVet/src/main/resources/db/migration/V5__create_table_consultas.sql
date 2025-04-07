create table consultas(
        id bigint not null auto_increment,
        fecha datetime not null,
        motivoCancelamiento varchar(100),
        motivoConsulta varchar(500) NOT NULL,
        diagnostico varchar(500) NOT NULL,
        tratamiento varchar(500) NOT NULL,
        activa tinyint,
        id_veterinario bigint not null,
        id_paciente bigint not null,
        id_pago bigint not null,

        primary key(id),
        constraint fk_consultas_id_veterinario foreign key(id_veterinario) references veterinarios(id),
        constraint fk_consultas_id_paciente foreign key(id_paciente) references pacientes(id),
        constraint fk_consultas_id_pago foreign key(id_pago) references pagos(id)
        );