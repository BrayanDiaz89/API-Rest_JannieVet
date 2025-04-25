package com.brayandvlp.JannieVet.domain.mascotaPaciente.validaciones.eliminacion;

import com.brayandvlp.JannieVet.domain.mascotaPaciente.PacienteRepository;
import com.brayandvlp.JannieVet.infra.errores.ValidacionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidarIdPacienteExiste implements ValidadorEliminaPaciente{

    @Autowired
    private PacienteRepository repository;

    public void validar(Long id){
        var paciente = repository.existsByIdAndActivoTrue(id);
        if(!paciente) {
            throw new ValidacionException("El paciente no existe o no está activo en la base de datos, verificar en pacientes inactivos.");
        }
    }

}
