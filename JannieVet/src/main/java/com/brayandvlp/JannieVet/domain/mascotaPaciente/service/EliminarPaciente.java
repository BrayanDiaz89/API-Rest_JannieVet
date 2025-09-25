package com.brayandvlp.JannieVet.domain.mascotaPaciente.service;

import com.brayandvlp.JannieVet.domain.mascotaPaciente.PacienteRepository;
import com.brayandvlp.JannieVet.domain.mascotaPaciente.validaciones.eliminacion.ValidadorEliminaPaciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EliminarPaciente {

    @Autowired
    private PacienteRepository repository;
    @Autowired
    private List<ValidadorEliminaPaciente> validadores;

    public void eliminarPaciente(Long id) {
        validadores.forEach(v-> v.validar(id));
        var paciente = repository.getReferenceById(id);
        paciente.eliminarPaciente();
    }
}
