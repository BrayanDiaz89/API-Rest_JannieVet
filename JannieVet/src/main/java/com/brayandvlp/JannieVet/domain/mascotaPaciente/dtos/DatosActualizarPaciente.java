package com.brayandvlp.JannieVet.domain.mascotaPaciente.dtos;

import jakarta.validation.constraints.NotNull;

public record DatosActualizarPaciente(
            @NotNull
            Long id,
            @NotNull
            Long idAmo,
            Double peso,
            Boolean activo
                        ) {
}
