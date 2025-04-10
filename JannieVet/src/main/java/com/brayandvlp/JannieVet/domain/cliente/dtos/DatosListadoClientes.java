package com.brayandvlp.JannieVet.domain.cliente.dtos;

import com.brayandvlp.JannieVet.domain.cliente.Cliente;
import com.brayandvlp.JannieVet.domain.direccion.dtos.DatosDireccion;

import java.time.LocalDateTime;

public record DatosListadoClientes(
        Long id,
        String documento,
        String nombreCompleto,
        String numeroTelefonico,
        String email,
        DatosDireccion direccion,
        LocalDateTime fecha,
        Boolean activo
        ) {
    public DatosListadoClientes(Cliente cliente){
        this(cliente.getId(), cliente.getDocumento(), cliente.getNombreCompleto(), cliente.getNumeroTelefonico(), cliente.getEmail(),
                new DatosDireccion(cliente.getDireccion().getCiudad(), cliente.getDireccion().getCodigoPostal(), cliente.getDireccion().getCalle(),
                        cliente.getDireccion().getNumero(), cliente.getDireccion().getComplemento()), cliente.getFecha(), cliente.getActivo());
    }
}
