package com.brayandvlp.JannieVet.domain.mascotaPaciente.dtos;

import com.brayandvlp.JannieVet.domain.mascotaPaciente.Especie;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DatosRegistrarPaciente(
        @NotBlank(message = "Debe registrarse un nombre para el paciente.")
        String nombre,
        @NotNull(message = "Debe registrarse una especie válida, de la lista.")
        Especie especie,
        @NotBlank(message = "Debe ingresar una raza del paciente.")
        String raza,
        @NotNull(message = "Debe registrarse un peso.")
        Double peso,
        @NotBlank(message = "Debe registrar un color del paciente.")
        String color,
        @NotNull(message = "Debe registrar una fecha de nacimiento del paciente.")
        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate fechaNacimiento
        ) {
}
