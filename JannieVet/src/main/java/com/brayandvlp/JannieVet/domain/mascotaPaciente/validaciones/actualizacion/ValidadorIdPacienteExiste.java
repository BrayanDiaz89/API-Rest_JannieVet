package com.brayandvlp.JannieVet.domain.mascotaPaciente.validaciones.actualizacion;

import com.brayandvlp.JannieVet.domain.mascotaPaciente.PacienteRepository;
import com.brayandvlp.JannieVet.domain.mascotaPaciente.dtos.DatosActualizarPaciente;
import com.brayandvlp.JannieVet.infra.errores.ValidacionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorIdPacienteExiste implements ValidadorDeActualizacion {

    @Autowired
    private PacienteRepository pacienteRepository;

    public void validarActualizacion(DatosActualizarPaciente datos){
        var pacienteExiste = pacienteRepository.existsById(datos.id());
        if(!pacienteExiste){
            throw new ValidacionException("El paciente no existe en la base de datos, id no encontrado.");
        }
    }

}
