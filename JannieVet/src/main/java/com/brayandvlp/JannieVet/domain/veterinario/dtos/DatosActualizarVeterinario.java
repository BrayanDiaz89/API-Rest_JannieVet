package com.brayandvlp.JannieVet.domain.veterinario.dtos;

import com.brayandvlp.JannieVet.domain.direccion.DatosDireccion;
import com.brayandvlp.JannieVet.domain.veterinario.Especialidad;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

public record DatosActualizarVeterinario(
        @NotNull
        Long id,
        String nombreCompleto,
        @Pattern(regexp = "^3\\d{9}$", message = "El número telefónico debe empezar por 3 y tener de 10 dígitos.")
        String numeroTelefonico,
        @Email
        String email,
        @Valid
        DatosDireccion direccion,//Por lo que retornario nulo, y no blanco.
        Especialidad especialidad,
        Boolean activo
    )  {

}
