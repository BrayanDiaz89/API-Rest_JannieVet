package com.brayandvlp.JannieVet.domain.veterinario.service;

import com.brayandvlp.JannieVet.domain.mascotaPaciente.validaciones.eliminacion.ValidadorEliminaPaciente;
import com.brayandvlp.JannieVet.domain.veterinario.VeterinarioRepository;
import com.brayandvlp.JannieVet.domain.veterinario.validaciones.interfaces.ValidadorEliminaVeterinario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EliminarVeterinario {

    @Autowired
    private List<ValidadorEliminaVeterinario> validadores;
    @Autowired
    private VeterinarioRepository veterinarioRepository;

    public void eliminarVeterinario(Long id){
        validadores.forEach(v-> v.validarEliminacion(id));
        var veterinario = veterinarioRepository.getReferenceById(id);
        veterinario.desactivarVeterinario();
    }

}
