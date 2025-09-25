package com.brayandvlp.JannieVet.domain.mascotaPaciente.service;

import com.brayandvlp.JannieVet.domain.cliente.ClienteRepository;
import com.brayandvlp.JannieVet.domain.cliente.dtos.DatosClienteComoAmo;
import com.brayandvlp.JannieVet.domain.mascotaPaciente.MascotaPaciente;
import com.brayandvlp.JannieVet.domain.mascotaPaciente.PacienteRepository;
import com.brayandvlp.JannieVet.domain.mascotaPaciente.dtos.DatosActualizarPaciente;
import com.brayandvlp.JannieVet.domain.mascotaPaciente.dtos.DatosListadoPacientes;
import com.brayandvlp.JannieVet.domain.mascotaPaciente.validaciones.actualizacion.ValidadorDeActualizacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActualizarPaciente {

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private List<ValidadorDeActualizacion> validadores;

    public DatosListadoPacientes actualizarPaciente(DatosActualizarPaciente datosActualizarPaciente) {


        //Recorriendo las validaciones
        validadores.forEach(v->v.validarActualizacion(datosActualizarPaciente));
        MascotaPaciente paciente = pacienteRepository.getReferenceById(datosActualizarPaciente.id());
        paciente.actualizarPaciente(datosActualizarPaciente);

        return new DatosListadoPacientes(paciente.getId(), paciente.getNombrePaciente(), paciente.getEspecie(), paciente.getRaza(),
                                        paciente.getPeso(), paciente.getColor(), paciente.getFechaNacimiento(), paciente.getActivo(),
                new DatosClienteComoAmo(paciente.getCliente().getId(), paciente.getCliente().getNombreCompleto(), paciente.getCliente().getDocumento(),
                        paciente.getCliente().getNumeroTelefonico(), paciente.getCliente().getEmail()));
    }
}
