package com.brayandvlp.JannieVet.domain.cliente.dtos;
import com.brayandvlp.JannieVet.domain.direccion.DatosDireccion;

import java.time.LocalDateTime;

public record DatosRespuestaCliente(
        Long id,
        String documento,
        String nombreCompleto,
        String numeroTelefonico,
        String email,
        LocalDateTime fecha_registro,
        Boolean activo,
        DatosDireccion direccion
            ) {
}
