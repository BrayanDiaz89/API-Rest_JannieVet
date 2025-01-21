package com.brayandvlp.JannieVet.domain.veterinario;

import com.brayandvlp.JannieVet.domain.direccion.Ciudad;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Normalized;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

public record DatosRegistrarVeterinario(
        @NotBlank
        @Pattern(regexp = "^\\d{6,10}$", message = "El documento debe tener de 6 a 10 dígitos.")
        String documentoIdentidad,
        @NotBlank(message = "Debe ingresar un nombre.")
        String nombreCompleto,
        @NotBlank
        @Pattern(regexp = "^3\\d{9}$", message = "El documento debe tener de 6 a 10 dígitos.")
        String numeroTelefonico,
        @NotBlank(message = "Debe ingresar un email válido.")
        @Email
        String email,
        @NotNull(message = "La ciudad debe ser una de las existentes.")
        Ciudad ciudad,
        @NotBlank(message = "Debe ingresar un código postal.")
        Integer codigoPostal,
        @NotBlank(message = "Debe ingresar una calle.")
        String calle,
        @NotBlank(message = "Debe ingresar un número.")
        String numero,
        @NotBlank(message = "Debe ingresar un complemento.")
        String complemento,
        @NotNull(message = "La especialidad debe ser una de las existentes.")
        Especialidad especialidad,
        @Future
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
        LocalDateTime fecha
        ) {
}
