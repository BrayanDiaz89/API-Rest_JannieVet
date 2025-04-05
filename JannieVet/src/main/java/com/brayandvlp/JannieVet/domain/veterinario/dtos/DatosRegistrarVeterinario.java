package com.brayandvlp.JannieVet.domain.veterinario.dtos;

import com.brayandvlp.JannieVet.domain.direccion.DatosDireccion;
import com.brayandvlp.JannieVet.domain.veterinario.Especialidad;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

public record DatosRegistrarVeterinario(
        @NotBlank
        @Pattern(regexp = "^\\d{6,10}$", message = "El documento debe tener de 6 a 10 dígitos.")
        String documentoIdentidad,
        @NotBlank(message = "Debe ingresar un nombre.")
        String nombreCompleto,
        @NotBlank
        @Pattern(regexp = "^3\\d{9}$", message = "El número telefónico debe empezar por 3 y tener de 10 dígitos.")
        String numeroTelefonico,
        @NotBlank(message = "Debe ingresar un email válido.")
        @Email
        String email,
        @NotNull(message = "La dirección no debe tener ningún campo vacío.") //Es un objeto contiene más atributos dentro
        @Valid
        DatosDireccion direccion,//Por lo que retornario nulo, y no blanco.
        @NotNull(message = "La especialidad debe ser una de las existentes.")
        Especialidad especialidad,
        @Future
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
        LocalDateTime fecha,
        Boolean activo
        ) {
}
