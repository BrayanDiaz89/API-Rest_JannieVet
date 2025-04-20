package com.brayandvlp.JannieVet.domain.mascotaPaciente.validaciones.actualizacion;

import com.brayandvlp.JannieVet.domain.mascotaPaciente.dtos.DatosActualizarPaciente;
import com.brayandvlp.JannieVet.infra.errores.ValidacionException;
import org.springframework.stereotype.Component;

@Component
public class ValidadorIdsSonNulos implements ValidadorDeActualizacion{

    public void validarActualizacion(DatosActualizarPaciente datos) {
        if(datos.idAmo() == null || datos.id() == null){
            throw new ValidacionException("Falta ingresar id del amo o id del paciente. Deben ingresarse los 2.");
        }
    }

}
