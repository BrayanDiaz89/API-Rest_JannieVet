package com.brayandvlp.JannieVet.domain.veterinario.validaciones.components;

import com.brayandvlp.JannieVet.domain.veterinario.VeterinarioRepository;
import com.brayandvlp.JannieVet.domain.veterinario.dtos.DatosRegistrarVeterinario;
import com.brayandvlp.JannieVet.domain.veterinario.validaciones.interfaces.ValidarRegistro;
import com.brayandvlp.JannieVet.infra.errores.ValidacionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorVeterinarioExiste implements ValidarRegistro {

    @Autowired
    private VeterinarioRepository veterinarioRepository;

    public void validar(DatosRegistrarVeterinario datosRegistro){
        var veterinario = veterinarioRepository.existsByDocumento(datosRegistro.documentoIdentidad());
        if (veterinario){
            throw new ValidacionException("El veterinario ya existe, valide su documento de identidad.");
        }
    }

}
