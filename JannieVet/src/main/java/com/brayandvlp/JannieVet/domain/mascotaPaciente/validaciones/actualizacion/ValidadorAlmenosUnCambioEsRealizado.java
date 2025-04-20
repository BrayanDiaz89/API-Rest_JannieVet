package com.brayandvlp.JannieVet.domain.mascotaPaciente.validaciones.actualizacion;

import com.brayandvlp.JannieVet.domain.mascotaPaciente.dtos.DatosActualizarPaciente;
import com.brayandvlp.JannieVet.infra.errores.ValidacionException;
import org.springframework.stereotype.Component;

@Component
public class ValidadorAlmenosUnCambioEsRealizado implements ValidadorDeActualizacion{

    public void validarActualizacion(DatosActualizarPaciente datos){
        if(datos.peso() == null && datos.activo() == null) {
            throw new ValidacionException("Debe realizar almenos un cambio, para que la actualización sea exitosa.");
        }
    }
}
