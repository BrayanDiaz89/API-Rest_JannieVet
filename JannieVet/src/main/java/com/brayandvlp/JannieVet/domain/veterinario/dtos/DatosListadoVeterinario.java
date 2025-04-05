package com.brayandvlp.JannieVet.domain.veterinario.dtos;

import com.brayandvlp.JannieVet.domain.veterinario.Especialidad;
import com.brayandvlp.JannieVet.domain.veterinario.Veterinario;

import java.time.LocalDateTime;

public record DatosListadoVeterinario(
                                      Long id,
                                      String documento,
                                      String nombreCompleto,
                                      String numeroTelefonico,
                                      String email,
                                      Especialidad especialidad,
                                      LocalDateTime fecha,
                                      Boolean activo
                                    ) {
    public DatosListadoVeterinario(Veterinario veterinario){
        this(veterinario.getId(), veterinario.getDocumento(), veterinario.getNombreCompleto(),
                veterinario.getNumeroTelefonico(), veterinario.getEmail(), veterinario.getEspecialidad(),
                veterinario.getFecha(), veterinario.getActivo());
    }
}
