package com.brayandvlp.JannieVet.domain.consulta.dtos;

import com.brayandvlp.JannieVet.domain.mascotaPaciente.MascotaPaciente;
import com.brayandvlp.JannieVet.domain.veterinario.Especialidad;
import com.brayandvlp.JannieVet.domain.veterinario.Veterinario;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

public record DatosRegistroConsulta(
        @NotNull(message = "La fecha no puede estar vacia")
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
        LocalDateTime fecha,
        @NotBlank(message = "El motivo de la consulta no puede estar vacio")
        String motivoConsulta,
        @NotNull(message = "La especialidad no puede estar vacia")
        Especialidad especialidad,
        @NotNull(message = "La mascota no puede estar vacia")
        MascotaPaciente mascotaPaciente,
        @NotNull(message = "El veterinario no puede estar vacio")
        Veterinario veterinario
) {
}
