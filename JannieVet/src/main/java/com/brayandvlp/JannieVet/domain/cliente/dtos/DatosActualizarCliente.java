package com.brayandvlp.JannieVet.domain.cliente.dtos;

import com.brayandvlp.JannieVet.domain.direccion.dtos.DatosDireccion;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DatosActualizarCliente(
        @NotNull
        Long id,
        String nombreCompleto,
        @Pattern(regexp = "^3\\d{9}$", message = "El número telefónico debe empezar por 3 y tener de 10 dígitos.")
        String numeroTelefonico,
        @Email
        String email,
        @Valid
        DatosDireccion direccion,//Por lo que retornario nulo, y no blanco.
        Boolean activo
) {
}
