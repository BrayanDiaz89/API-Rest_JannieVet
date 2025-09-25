package com.brayandvlp.JannieVet.domain.veterinario.validaciones.actualizacion;

import com.brayandvlp.JannieVet.domain.veterinario.dtos.DatosActualizarVeterinario;
import com.brayandvlp.JannieVet.domain.veterinario.validaciones.interfaces.ValidadorActualizaVeterinario;
import com.brayandvlp.JannieVet.infra.errores.ValidacionException;
import org.springframework.stereotype.Component;

@Component
public class ValidacionIdEsNull implements ValidadorActualizaVeterinario {

    public void validar(DatosActualizarVeterinario datosActualizacion){
        if(datosActualizacion.id() == null){
            throw new ValidacionException("El id es null");
        }
    }
}
