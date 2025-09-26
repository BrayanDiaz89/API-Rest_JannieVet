package com.brayandvlp.JannieVet.domain.consulta.validaciones.registro;

import com.brayandvlp.JannieVet.domain.consulta.dtos.DatosRegistroConsulta;
import com.brayandvlp.JannieVet.infra.errores.ValidacionException;
import de.jollyday.*;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.Set;

@Component
public class ValidaConsultaParaUnDomingoOFestivo implements ValidadorRegistroConsulta {

    public void validar(DatosRegistroConsulta datosRegistro){
        if(datosRegistro.fecha().getDayOfWeek() == DayOfWeek.SUNDAY){
            throw new ValidacionException("No se puede programar una consulta para un domingo. Si lo necesitas con urgencia, ve por el servicio de urgencias.");
        }
        if(esFestivo(datosRegistro.fecha())){
            throw new ValidacionException("No se puede programar una consulta para un festivo. Si lo necesitas con urgencia, ve por el servicio de urgencias.");
        }
    }
    public static boolean esFestivo(LocalDateTime fecha){
        HolidayManager holidayManager = HolidayManager.getInstance(ManagerParameters.create(HolidayCalendar.COLOMBIA));
        Set<Holiday> holidays = holidayManager.getHolidays(fecha.getYear());
        return holidays.stream().anyMatch(holiday -> holiday.getDate().equals(fecha.toLocalDate()));
    }
}
