package com.brayandvlp.JannieVet.domain.veterinario.validaciones.actualizacion;

import com.brayandvlp.JannieVet.domain.veterinario.dtos.DatosActualizarVeterinario;
import com.brayandvlp.JannieVet.domain.veterinario.validaciones.interfaces.ValidarActualizacion;
import com.brayandvlp.JannieVet.infra.errores.ValidacionException;
import org.springframework.stereotype.Component;

@Component
public class ValidacionAlMenosUnCambioEsRealizado implements ValidarActualizacion {

    public void validar(DatosActualizarVeterinario datosActualizacion){

        if(datosActualizacion.nombreCompleto() == null && datosActualizacion.numeroTelefonico() == null
           && datosActualizacion.email() == null && datosActualizacion.direccion() == null
           && datosActualizacion.especialidad() == null && datosActualizacion.activo() == null){
            throw new ValidacionException("Debe realizar almenos un cambio, para que la actualización sea exitosa.");
        }
    }

}
