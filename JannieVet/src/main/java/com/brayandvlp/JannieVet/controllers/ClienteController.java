package com.brayandvlp.JannieVet.controllers;

import com.brayandvlp.JannieVet.domain.cliente.Cliente;
import com.brayandvlp.JannieVet.domain.cliente.ClienteRepository;
import com.brayandvlp.JannieVet.domain.cliente.dtos.DatosRegistrarCliente;
import com.brayandvlp.JannieVet.domain.cliente.dtos.DatosRespuestaCliente;
import com.brayandvlp.JannieVet.domain.direccion.DatosDireccion;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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



}
