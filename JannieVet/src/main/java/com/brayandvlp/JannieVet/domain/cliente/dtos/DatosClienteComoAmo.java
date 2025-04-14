package com.brayandvlp.JannieVet.domain.cliente.dtos;

import com.brayandvlp.JannieVet.domain.cliente.Cliente;

public record DatosClienteComoAmo(
        Long idAmo,
        String nombre,
        String documento,
        String numeroTelefonico,
        String email
) {
    public DatosClienteComoAmo(Cliente cliente){
        this(cliente.getId(), cliente.getNombreCompleto(), cliente.getDocumento(),
             cliente.getNumeroTelefonico(), cliente.getEmail());
    }

}
