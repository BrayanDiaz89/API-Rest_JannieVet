package com.brayandvlp.JannieVet.domain.cliente.dtos;
import com.brayandvlp.JannieVet.domain.cliente.Cliente;
import com.brayandvlp.JannieVet.domain.direccion.dtos.DatosDireccion;

import java.time.LocalDateTime;

public record DatosRespuestaCliente(
        Long id,
        String documento,
        String nombreCompleto,
        String numeroTelefonico,
        String email,
        LocalDateTime fecha_registro,
        Boolean activo,
        DatosDireccion direccion
) {
    public DatosRespuestaCliente(Cliente cliente){
        this(cliente.getId(), cliente.getDocumento(), cliente.getNombreCompleto(), cliente.getNumeroTelefonico(),
                cliente.getEmail(), cliente.getFecha(), cliente.getActivo(),
                new DatosDireccion(cliente.getDireccion().getCiudad(), cliente.getDireccion().getCodigoPostal(),
                        cliente.getDireccion().getCalle(), cliente.getDireccion().getNumero(), cliente.getDireccion().getComplemento()));
    }
}
