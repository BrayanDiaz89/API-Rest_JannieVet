package com.brayandvlp.JannieVet.domain.cliente.service;

import com.brayandvlp.JannieVet.domain.cliente.Cliente;
import com.brayandvlp.JannieVet.domain.cliente.ClienteRepository;
import com.brayandvlp.JannieVet.domain.cliente.dtos.DatosRegistrarCliente;
import com.brayandvlp.JannieVet.domain.cliente.dtos.DatosRespuestaCliente;
import com.brayandvlp.JannieVet.domain.direccion.Direccion;
import com.brayandvlp.JannieVet.infra.errores.ValidacionException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class RegistrarCliente {

    @Autowired
    private ClienteRepository clienteRepository;

    public DatosRespuestaCliente crearCliente(@Valid DatosRegistrarCliente datosRegistro) {
        var clienteYaExiste = clienteRepository.existsByDocumentoOrEmailOrNumeroTelefonico(
                datosRegistro.documentoIdentidad(),
                datosRegistro.email(),
                datosRegistro.numeroTelefonico());
        //Validamos si el documento o el correo ya ha sido registrado antes
        if(clienteYaExiste){
            throw new ValidacionException("""
                    El cliente ya ha sido registrado antes.
                    Los siguientes valores deben ser únicos en la BD.
                    Valide por favor su: 
                    -> documento,
                    -> email,
                    -> numero telefónico.
                    en el registro suministrado.""");
        }
        var timestamp = LocalDateTime.now();
        var cliente = new Cliente(null, datosRegistro.documentoIdentidad(), datosRegistro.nombreCompleto(), datosRegistro.numeroTelefonico(),
                datosRegistro.email(), new Direccion(datosRegistro.direccion().ciudad(), datosRegistro.direccion().codigoPostal(),
                datosRegistro.direccion().calle(), datosRegistro.direccion().numero(), datosRegistro.direccion().complemento()),
                timestamp, true);
        clienteRepository.save(cliente);
        return new DatosRespuestaCliente(cliente);
    }
}
