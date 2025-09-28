package com.brayandvlp.JannieVet.domain.consulta.validaciones.registro;

import com.brayandvlp.JannieVet.domain.consulta.dtos.DatosRegistroConsulta;
import com.brayandvlp.JannieVet.domain.mascotaPaciente.PacienteRepository;
import com.brayandvlp.JannieVet.infra.errores.ValidacionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidaPacienteEstaActivo implements ValidadorRegistroConsulta{

    @Autowired
    private PacienteRepository pacienteRepository;

    public void validar(DatosRegistroConsulta datosRegistroConsulta){
        var paciente = pacienteRepository.getReferenceById(datosRegistroConsulta.mascotaPaciente().getId());
        if(!paciente.getActivo()){
            throw new ValidacionException("El paciente no se encuentra activo, por favor valide su estado.");
        }
    }

}
