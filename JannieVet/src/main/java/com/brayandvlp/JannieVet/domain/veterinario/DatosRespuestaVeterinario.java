package com.brayandvlp.JannieVet.domain.veterinario;

import java.time.LocalDateTime;

public record DatosRespuestaVeterinario(
        Long id,
        String documento,
        String nombreCompleto,
        String numeroTelefonico,
        String email,
        Especialidad especialidad,
        LocalDateTime fecha,
        Boolean activo
) {
}
