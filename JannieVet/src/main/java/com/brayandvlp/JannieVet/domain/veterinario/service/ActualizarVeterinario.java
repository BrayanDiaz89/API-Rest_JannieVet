package com.brayandvlp.JannieVet.domain.veterinario.service;

import com.brayandvlp.JannieVet.domain.veterinario.VeterinarioRepository;
import com.brayandvlp.JannieVet.domain.veterinario.dtos.DatosActualizarVeterinario;
import com.brayandvlp.JannieVet.domain.veterinario.dtos.DatosListadoVeterinario;
import com.brayandvlp.JannieVet.domain.veterinario.dtos.DatosRespuestaVeterinario;
import com.brayandvlp.JannieVet.domain.veterinario.validaciones.interfaces.ValidarActualizacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActualizarVeterinario {

    @Autowired
    private VeterinarioRepository veterinarioRepository;
    @Autowired
    private List<ValidarActualizacion> validadores;

    public DatosListadoVeterinario actualizarVeterinario(DatosActualizarVeterinario datosActualizacion){

        validadores.forEach(v -> v.validar(datosActualizacion));
        var veterinario = veterinarioRepository.getReferenceById(datosActualizacion.id());
        veterinario.actualizarDatos(datosActualizacion);

        return new DatosListadoVeterinario(veterinario.getId(), veterinario.getDocumento(), veterinario.getNombreCompleto(),
                veterinario.getNumeroTelefonico(), veterinario.getEmail(), veterinario.getEspecialidad(), veterinario.getFecha(),
                veterinario.getActivo());
    }


}
