package com.brayandvlp.JannieVet.domain.veterinario.dtos;

import com.brayandvlp.JannieVet.domain.direccion.dtos.DatosDireccion;
import com.brayandvlp.JannieVet.domain.veterinario.Especialidad;

import java.time.LocalDateTime;

public record DatosRespuestaVeterinario(
        Long id,
        String documento,
        String nombreCompleto,
        String numeroTelefonico,
        String email,
        Especialidad especialidad,
        LocalDateTime fecha,
        Boolean activo,
        DatosDireccion direccion
) {

}
