package com.brayandvlp.JannieVet.domain.direccion;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosDireccion(
        @NotNull(message = "La ciudad debe ser una de las existentes.")
        Ciudad ciudad,
        @NotBlank
        String codigoPostal,
        @NotBlank
        String calle,
        @NotBlank
        String numero,
        @NotBlank
        String complemento
) {
}
