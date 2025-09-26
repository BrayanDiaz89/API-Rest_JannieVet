package com.brayandvlp.JannieVet.domain.consulta.validaciones.registro;

import com.brayandvlp.JannieVet.domain.consulta.dtos.DatosRegistroConsulta;
import com.brayandvlp.JannieVet.infra.errores.ValidacionException;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class ValidaConsultaConAnticipacion implements ValidadorRegistroConsulta{

    public void validar(DatosRegistroConsulta datosRegistroConsulta){
        var fechaActual = LocalDateTime.now();
        var fechaConsulta = datosRegistroConsulta.fecha();
        var diferenciaEnMinutos = Duration.between(fechaActual, fechaConsulta).toMinutes();
        if(diferenciaEnMinutos < 30){
            throw new ValidacionException("La consulta debe ser programada con al menos 30 minutos de anticipacion.");
        }

    }

}
