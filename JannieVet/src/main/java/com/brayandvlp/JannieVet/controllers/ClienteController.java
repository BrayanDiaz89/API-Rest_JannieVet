package com.brayandvlp.JannieVet.controllers;

import com.brayandvlp.JannieVet.domain.cliente.Cliente;
import com.brayandvlp.JannieVet.domain.cliente.ClienteRepository;
import com.brayandvlp.JannieVet.domain.cliente.dtos.*;

import com.brayandvlp.JannieVet.domain.direccion.dtos.DatosDireccion;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping
    public ResponseEntity<DatosRespuestaCliente> registrarCliente(@RequestBody @Valid DatosRegistrarCliente datosRegistrarCliente,
                                                                  UriComponentsBuilder uriComponentsBuilder){
        Cliente cliente = clienteRepository.save(new Cliente(datosRegistrarCliente));

        DatosRespuestaCliente datosRespuestaCliente = new DatosRespuestaCliente(cliente.getId(), cliente.getDocumento(), cliente.getNombreCompleto(), cliente.getNumeroTelefonico(),
                cliente.getEmail(), cliente.getFecha(), cliente.getActivo(),
                new DatosDireccion(cliente.getDireccion().getCiudad(), cliente.getDireccion().getCodigoPostal(), cliente.getDireccion().getCalle(),
                cliente.getDireccion().getNumero(), cliente.getDireccion().getComplemento()));
        URI url = uriComponentsBuilder.path("/veterinarios/{id]").buildAndExpand(cliente.getId()).toUri();
        return ResponseEntity.created(url).body(datosRespuestaCliente);
    }

    @GetMapping
    public ResponseEntity<Page<DatosListadoClientes>> listadoClientes(@PageableDefault(size = 5) Pageable paginacion) {
        return ResponseEntity.ok(clienteRepository.findByActivoTrue(paginacion).map(DatosListadoClientes::new));
    }
    @GetMapping("/inactive")
    public ResponseEntity<Page<DatosListadoClientes>> listadoClientesInactivos(@PageableDefault(size =5)Pageable paginacion) {
        return ResponseEntity.ok(clienteRepository.findByActivoFalse(paginacion).map(DatosListadoClientes::new));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DatosRespuestaCliente> actualizarCliente(@RequestBody @Valid DatosActualizarCliente datosActualizarCliente){
        Cliente cliente = clienteRepository.getReferenceById(datosActualizarCliente.id());
        cliente.actualizarDatos(datosActualizarCliente);

        return ResponseEntity.ok(new DatosRespuestaCliente(cliente.getId(), cliente.getDocumento(), cliente.getNombreCompleto(), cliente.getNumeroTelefonico(),
                cliente.getEmail(), cliente.getFecha(), cliente.getActivo(),
                new DatosDireccion(cliente.getDireccion().getCiudad(), cliente.getDireccion().getCodigoPostal(), cliente.getDireccion().getCalle(),
                cliente.getDireccion().getNumero(), cliente.getDireccion().getComplemento())));
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity desactivarCliente(@PathVariable Long id) {
        Cliente cliente = clienteRepository.getReferenceById(id);
        cliente.desactivarCliente();
        return ResponseEntity.noContent().build();
    }

}
