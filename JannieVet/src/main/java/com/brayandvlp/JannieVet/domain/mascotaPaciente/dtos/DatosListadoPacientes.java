package com.brayandvlp.JannieVet.domain.mascotaPaciente.dtos;

import com.brayandvlp.JannieVet.domain.cliente.dtos.DatosClienteComoAmo;
import com.brayandvlp.JannieVet.domain.mascotaPaciente.Especie;
import com.brayandvlp.JannieVet.domain.mascotaPaciente.MascotaPaciente;


import java.time.LocalDate;

public record DatosListadoPacientes(
                            Long id,
                            String nombreDePaciente,
                            Especie especie,
                            String raza,
                            Double peso,
                            String color,
                            LocalDate fechaDeNacimiento,
                            Boolean activo,
                            DatosClienteComoAmo datosDelAmo
                                    ) {
        public DatosListadoPacientes(MascotaPaciente paciente) {
            this(paciente.getId(), paciente.getNombrePaciente(), paciente.getEspecie(), paciente.getRaza(), paciente.getPeso(),
                    paciente.getColor(), paciente.getFechaNacimiento(), paciente.getActivo(),
                    new DatosClienteComoAmo(paciente.getCliente()));
        }
}
