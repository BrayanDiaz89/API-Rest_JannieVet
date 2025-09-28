package com.brayandvlp.JannieVet.domain.consulta.validaciones.registro;

import com.brayandvlp.JannieVet.domain.consulta.ConsultaRepository;
import com.brayandvlp.JannieVet.domain.consulta.dtos.DatosRegistroConsulta;
import com.brayandvlp.JannieVet.domain.veterinario.VeterinarioRepository;
import com.brayandvlp.JannieVet.infra.errores.ValidacionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidaVeterinarioTieneConsultaMismaHora implements ValidadorRegistroConsulta{

    @Autowired
    private ConsultaRepository consultaRepository;

    public void validar(DatosRegistroConsulta datosRegistroConsulta){
        var veterinarioReservadoEnConsulta = consultaRepository.existsByVeterinarioIdAndFechaAndMotivoCancelamientoIsNull(datosRegistroConsulta.veterinario().getId(),
                                                                                                                datosRegistroConsulta.fecha());
        if(veterinarioReservadoEnConsulta){
            throw new ValidacionException("El veterinario ya tiene una consulta programada para la fecha indicada.");
        }
    }


}
