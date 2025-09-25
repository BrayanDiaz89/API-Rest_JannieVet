package com.brayandvlp.JannieVet.domain.veterinario.validaciones.eliminacion;

import com.brayandvlp.JannieVet.domain.mascotaPaciente.validaciones.eliminacion.ValidadorEliminaPaciente;
import com.brayandvlp.JannieVet.domain.veterinario.VeterinarioRepository;
import com.brayandvlp.JannieVet.domain.veterinario.validaciones.interfaces.ValidadorEliminaVeterinario;
import com.brayandvlp.JannieVet.infra.errores.ValidacionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidarIdVeterinarioExiste implements ValidadorEliminaVeterinario {

    @Autowired
    private VeterinarioRepository veterinarioRepository;

    public void validarEliminacion(Long id){
        boolean veterinarioExists = veterinarioRepository.existsById(id);
        if(!veterinarioExists){
            throw new ValidacionException("El veterinario no existe, por favor valide el id ingresado.");
        }
    }


}
