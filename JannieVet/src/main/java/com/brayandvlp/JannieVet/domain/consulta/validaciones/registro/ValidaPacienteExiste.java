package com.brayandvlp.JannieVet.domain.consulta.validaciones.registro;

import com.brayandvlp.JannieVet.domain.consulta.dtos.DatosRegistroConsulta;
import com.brayandvlp.JannieVet.domain.mascotaPaciente.PacienteRepository;
import com.brayandvlp.JannieVet.infra.errores.ValidacionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidaPacienteExiste implements ValidadorRegistroConsulta{

    @Autowired
    private PacienteRepository pacienteRepository;

    public void validar(DatosRegistroConsulta datosRegistro){
        var paciente = pacienteRepository.existsById(datosRegistro.mascotaPaciente().getId());
        if(!paciente){
            throw new ValidacionException("El paciente no existe, por favor valide su id.");
        }
    }

}
