package com.brayandvlp.JannieVet.domain.mascotaPaciente.validaciones.registro;

import com.brayandvlp.JannieVet.domain.mascotaPaciente.dtos.DatosCompletosRegistrarPaciente;
import com.brayandvlp.JannieVet.infra.errores.ValidacionException;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class ValidadorFechaNacimientoEsFutura implements ValidadorDePacientes{

    public void validar(DatosCompletosRegistrarPaciente datosRegistro){
        LocalDate hoy = LocalDate.now();
        LocalDate nacimientoPaciente = datosRegistro.paciente().fechaNacimiento();
        if(nacimientoPaciente.isAfter(hoy)){
            throw new ValidacionException("La fecha de nacimiento no es válida, verifique por favor.");
        }
    }
}
