package com.brayandvlp.JannieVet.domain.veterinario.validaciones.actualizacion;

import com.brayandvlp.JannieVet.domain.veterinario.VeterinarioRepository;
import com.brayandvlp.JannieVet.domain.veterinario.dtos.DatosActualizarVeterinario;
import com.brayandvlp.JannieVet.domain.veterinario.validaciones.interfaces.ValidadorActualizaVeterinario;
import com.brayandvlp.JannieVet.infra.errores.ValidacionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidacionIdVeterinarioExiste implements ValidadorActualizaVeterinario {

    @Autowired
    private VeterinarioRepository veterinarioRepository;

    public void validar(DatosActualizarVeterinario datosActualizacion) {
        boolean veterinarioExists = veterinarioRepository.existsById(datosActualizacion.id());
        if(!veterinarioExists){
            throw new ValidacionException("El veterinario no existe, por favor valide el id ingresado.");
        }
    }
}
