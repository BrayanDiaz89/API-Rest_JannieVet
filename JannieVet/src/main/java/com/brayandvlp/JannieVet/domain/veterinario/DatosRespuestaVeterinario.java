package com.brayandvlp.JannieVet.domain.veterinario;

import com.brayandvlp.JannieVet.domain.direccion.DatosDireccion;
import com.brayandvlp.JannieVet.domain.direccion.Direccion;

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
