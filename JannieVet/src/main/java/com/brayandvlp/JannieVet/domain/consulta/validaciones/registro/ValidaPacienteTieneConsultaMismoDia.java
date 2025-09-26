package com.brayandvlp.JannieVet.domain.consulta.validaciones.registro;

import com.brayandvlp.JannieVet.domain.consulta.ConsultaRepository;
import com.brayandvlp.JannieVet.domain.consulta.dtos.DatosRegistroConsulta;
import com.brayandvlp.JannieVet.domain.mascotaPaciente.PacienteRepository;
import com.brayandvlp.JannieVet.infra.errores.ValidacionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidaPacienteTieneConsultaMismoDia implements ValidadorRegistroConsulta{

    @Autowired
    private ConsultaRepository consultaRepository;
    @Autowired
    private PacienteRepository pacienteRepository;

    public void validar(DatosRegistroConsulta datosRegistroConsulta){
        var paciente = pacienteRepository.getReferenceById(datosRegistroConsulta.mascotaPaciente().getId());
        var fechaConsulta = datosRegistroConsulta.fecha();
        var consultaMismoDia = consultaRepository.existsByPacienteIdAndFechaAndMotivoCancelamientoIsNull(paciente.getId(), fechaConsulta);
        if(consultaMismoDia){
            throw new ValidacionException("El paciente ya tiene una consulta programada para la fecha indicada.");
        }
    }


}
