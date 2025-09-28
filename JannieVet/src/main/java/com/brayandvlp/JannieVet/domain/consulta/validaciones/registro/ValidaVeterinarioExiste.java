package com.brayandvlp.JannieVet.domain.consulta.validaciones.registro;

import com.brayandvlp.JannieVet.domain.consulta.dtos.DatosRegistroConsulta;
import com.brayandvlp.JannieVet.domain.veterinario.VeterinarioRepository;
import com.brayandvlp.JannieVet.infra.errores.ValidacionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidaVeterinarioExiste implements ValidadorRegistroConsulta{

    @Autowired
    private VeterinarioRepository veterinarioRepository;

    public void validar(DatosRegistroConsulta datosRegistro){
        var veterinario = veterinarioRepository.existsById(datosRegistro.veterinario().getId());
        if(!veterinario){
            throw new ValidacionException("El veterinario no existe, por favor valide su id.");
        }
    }

}
