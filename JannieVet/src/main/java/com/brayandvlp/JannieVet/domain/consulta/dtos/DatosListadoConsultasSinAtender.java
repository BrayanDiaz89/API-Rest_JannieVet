package com.brayandvlp.JannieVet.domain.consulta.dtos;

import com.brayandvlp.JannieVet.domain.mascotaPaciente.MascotaPaciente;
import com.brayandvlp.JannieVet.domain.veterinario.Veterinario;

import java.time.LocalDateTime;

public record DatosListadoConsultasSinAtender(
        Long id,
        LocalDateTime fecha,
        String motivoConsulta,
        Veterinario veterinario,
        MascotaPaciente mascotaPaciente,
        Boolean active
) {
}
