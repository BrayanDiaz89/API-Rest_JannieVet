package com.brayandvlp.JannieVet.domain.mascotaPaciente.validaciones.registro;

import com.brayandvlp.JannieVet.domain.mascotaPaciente.PacienteRepository;
import com.brayandvlp.JannieVet.domain.mascotaPaciente.dtos.DatosCompletosRegistrarPaciente;
import com.brayandvlp.JannieVet.infra.errores.ValidacionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorDePacienteYaRegistrado implements ValidadorDePacientes {

    @Autowired
    private PacienteRepository pacienteRepository;

    public void validar(DatosCompletosRegistrarPaciente datos){
        var pacienteYaExiste = pacienteRepository.existsByNombrePacienteAndFechaNacimientoAndColorAndEspecieAndCliente(
                datos.paciente().nombre(), datos.paciente().fechaNacimiento(), datos.paciente().color(), datos.paciente().especie(),
                datos.cliente());
        if(pacienteYaExiste){
           throw new ValidacionException("El paciente ya ha sido registrado antes, favor valide en los registros.");
        }
    }
}
