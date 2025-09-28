package com.brayandvlp.JannieVet.domain.consulta.validaciones.registro;

import com.brayandvlp.JannieVet.domain.consulta.dtos.DatosRegistroConsulta;
import com.brayandvlp.JannieVet.infra.errores.ValidacionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidaConsultaEnHorarioNoPermitido implements ValidadorRegistroConsulta{

    public void validar(DatosRegistroConsulta datosRegistro){
        var horaConsulta = datosRegistro.fecha().getHour();
        if(horaConsulta < 6 || horaConsulta > 21){
            throw new ValidacionException("No se puede programar una consulta fuera del horario de 6:00 a.m a 21:00 p.m.");
        }
    }
}
