package com.brayandvlp.JannieVet.domain.veterinario.validaciones.registro;

import com.brayandvlp.JannieVet.domain.veterinario.VeterinarioRepository;
import com.brayandvlp.JannieVet.domain.veterinario.dtos.DatosRegistrarVeterinario;
import com.brayandvlp.JannieVet.domain.veterinario.validaciones.interfaces.ValidadorRegistroVeterinario;
import com.brayandvlp.JannieVet.infra.errores.ValidacionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorVeterinarioExiste implements ValidadorRegistroVeterinario {

    @Autowired
    private VeterinarioRepository veterinarioRepository;

    public void validar(DatosRegistrarVeterinario datosRegistro){
        boolean veterinarioExists = veterinarioRepository.existsByDocumentoOrNumeroTelefonicoOrEmail(
                datosRegistro.documentoIdentidad(),
                datosRegistro.numeroTelefonico(),
                datosRegistro.email());
        if (veterinarioExists){
            throw new ValidacionException("""
                                        El veterinario ya ha sido registrado antes.
                                        Los siguientes valores deben ser únicos en la BD.
                                        Valide por favor su:
                                        -> documento,
                                        -> email,
                                        -> numero telefónico.
                                        en el registro suministrado.""");
        }
    }
}
