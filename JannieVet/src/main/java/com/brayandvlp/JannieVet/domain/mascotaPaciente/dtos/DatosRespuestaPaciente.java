package com.brayandvlp.JannieVet.domain.mascotaPaciente.dtos;

import com.brayandvlp.JannieVet.domain.mascotaPaciente.Especie;
import com.brayandvlp.JannieVet.domain.mascotaPaciente.MascotaPaciente;

import java.time.LocalDate;

public record DatosRespuestaPaciente(
        Long id,
        String nombre,
        Integer edad,
        Especie especie,
        String raza,
        Double peso,
        LocalDate fechaNacimiento,
        Boolean activo,
        Long idAmo,
        String nombreAmo,
        String numeroCelularAmo
) {
    public DatosRespuestaPaciente(MascotaPaciente registro) {
        this(registro.getId(), registro.getNombrePaciente(), registro.getEdad(), registro.getEspecie(), registro.getRaza(),
                registro.getPeso(), registro.getFechaNacimiento(), registro.getActivo(), registro.getCliente().getId(),
                registro.getCliente().getNombreCompleto(), registro.getCliente().getNumeroTelefonico());
    }
}
