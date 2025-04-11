package com.brayandvlp.JannieVet.controllers;


import com.brayandvlp.JannieVet.domain.mascotaPaciente.PacienteRepository;
import com.brayandvlp.JannieVet.domain.mascotaPaciente.dtos.DatosRegistrarPaciente;
import com.brayandvlp.JannieVet.domain.mascotaPaciente.dtos.DatosRespuestaPaciente;
import com.brayandvlp.JannieVet.domain.mascotaPaciente.service.RegistroDePacientes;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private RegistroDePacientes registroDePacientes;

    @PostMapping
    public ResponseEntity<DatosRespuestaPaciente> registrarPaciente(@RequestBody @Valid DatosRegistrarPaciente datosRegistrarPaciente){
        var detalleRegistroPaciente = registroDePacientes.crearPaciente(datosRegistrarPaciente);
        return ResponseEntity.ok(detalleRegistroPaciente);
    }

}
