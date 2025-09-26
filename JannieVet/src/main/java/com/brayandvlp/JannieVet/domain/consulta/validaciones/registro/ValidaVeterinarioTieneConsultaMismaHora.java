package com.brayandvlp.JannieVet.domain.consulta.validaciones.registro;

import com.brayandvlp.JannieVet.domain.consulta.ConsultaRepository;
import com.brayandvlp.JannieVet.domain.consulta.dtos.DatosRegistroConsulta;
import com.brayandvlp.JannieVet.domain.veterinario.VeterinarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidaVeterinarioTieneConsultaMismaHora implements ValidadorRegistroConsulta{

    @Autowired
    private ConsultaRepository consultaRepository;
    @Autowired
    private VeterinarioRepository veterinarioRepository;

    public void validar(DatosRegistroConsulta datosRegistroConsulta){

    }


}
