package com.brayandvlp.JannieVet.controllers;


import com.brayandvlp.JannieVet.domain.cliente.dtos.DatosListadoClientes;
import com.brayandvlp.JannieVet.domain.mascotaPaciente.PacienteRepository;
import com.brayandvlp.JannieVet.domain.mascotaPaciente.dtos.DatosCompletosRegistrarPaciente;
import com.brayandvlp.JannieVet.domain.mascotaPaciente.dtos.DatosListadoPacientes;
import com.brayandvlp.JannieVet.domain.mascotaPaciente.dtos.DatosRegistrarPaciente;
import com.brayandvlp.JannieVet.domain.mascotaPaciente.dtos.DatosRespuestaPaciente;
import com.brayandvlp.JannieVet.domain.mascotaPaciente.service.RegistroDePacientes;

import com.brayandvlp.JannieVet.domain.veterinario.dtos.DatosListadoVeterinario;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private RegistroDePacientes registroDePacientes;

    @PostMapping
    public ResponseEntity<DatosRespuestaPaciente> registrarPaciente(@RequestBody @Valid DatosCompletosRegistrarPaciente datosRegistro){
        var detalleRegistroPaciente = registroDePacientes.crearPaciente(datosRegistro);
        return ResponseEntity.ok(detalleRegistroPaciente);
    }

    @GetMapping
    public ResponseEntity<Page<DatosListadoPacientes>> listadoDePacientesActivos(@PageableDefault(size = 5) Pageable paginacion) {
        return ResponseEntity.ok(pacienteRepository.findByActivoTrue(paginacion).map(DatosListadoPacientes::new));
    }

    @GetMapping("/inactive")
    public ResponseEntity<Page<DatosListadoPacientes>> listadoDePacientesInactivos(@PageableDefault(size = 5) Pageable paginacion) {
        return ResponseEntity.ok(pacienteRepository.findByActivoFalse(paginacion).map(DatosListadoPacientes::new));
    }



}
