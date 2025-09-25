package com.brayandvlp.JannieVet.domain.veterinario.service;

import com.brayandvlp.JannieVet.domain.veterinario.Veterinario;
import com.brayandvlp.JannieVet.domain.veterinario.VeterinarioRepository;
import com.brayandvlp.JannieVet.domain.veterinario.dtos.DatosListadoVeterinario;
import com.brayandvlp.JannieVet.domain.veterinario.dtos.DatosRegistrarVeterinario;
import com.brayandvlp.JannieVet.domain.veterinario.validaciones.interfaces.ValidarRegistro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistroVeterinario {

    @Autowired
    private VeterinarioRepository veterinarioRepository;

    @Autowired
    private List<ValidarRegistro> validadores;


    public DatosListadoVeterinario registrar(DatosRegistrarVeterinario datosRegistro) {

        //Recorrer la lista de validaciones, para registrar
        validadores.forEach(v-> v.validar(datosRegistro));

        var registro = new Veterinario(datosRegistro);
        veterinarioRepository.save(registro);
        return new DatosListadoVeterinario(registro);
    }
}
