package com.brayandvlp.JannieVet.domain.consulta.validaciones.registro;

import com.brayandvlp.JannieVet.domain.consulta.dtos.DatosRegistroConsulta;
import com.brayandvlp.JannieVet.domain.veterinario.VeterinarioRepository;
import com.brayandvlp.JannieVet.infra.errores.ValidacionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidaVeterinarioEstaActivo implements ValidadorRegistroConsulta{

    @Autowired
    private VeterinarioRepository veterinarioRepository;

    public void validar(DatosRegistroConsulta datosRegistroConsulta){
        var veterinario = veterinarioRepository.getReferenceById(datosRegistroConsulta.veterinario().getId());
        if(!veterinario.getActivo()){
            throw new ValidacionException("El veterinario no se encuentra activo, por favor valide su estado.");
        }
    }

}
