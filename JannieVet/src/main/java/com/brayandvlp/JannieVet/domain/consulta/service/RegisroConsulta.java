package com.brayandvlp.JannieVet.domain.consulta.service;

import com.brayandvlp.JannieVet.domain.consulta.ConsultaRepository;
import com.brayandvlp.JannieVet.domain.consulta.dtos.DatosListadoConsultasSinAtender;
import com.brayandvlp.JannieVet.domain.consulta.dtos.DatosRegistroConsulta;

import com.brayandvlp.JannieVet.domain.mascotaPaciente.PacienteRepository;
import com.brayandvlp.JannieVet.domain.veterinario.VeterinarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisroConsulta {

    @Autowired
    private ConsultaRepository consultaRepository;
    @Autowired
    private VeterinarioRepository veterinarioRepository;
    @Autowired
    private PacienteRepository mascotaPacienteRepository;

    public DatosListadoConsultasSinAtender registrarConsulta(DatosRegistroConsulta datosRegistro){
        var veterinario = veterinarioRepository.getReferenceById(datosRegistro.veterinario().getId());
        var mascotaPaciente = mascotaPacienteRepository.getReferenceById(datosRegistro.mascotaPaciente().getId());

    }


}
