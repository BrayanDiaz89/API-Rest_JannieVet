package com.brayandvlp.JannieVet.domain.mascotaPaciente.validaciones.actualizacion;

import com.brayandvlp.JannieVet.domain.cliente.ClienteRepository;
import com.brayandvlp.JannieVet.domain.mascotaPaciente.dtos.DatosActualizarPaciente;
import com.brayandvlp.JannieVet.infra.errores.ValidacionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorIdAmoInactivo implements ValidadorDeActualizacion{

    @Autowired
    private ClienteRepository clienteRepository;

    public void validarActualizacion(DatosActualizarPaciente datos){
        var clienteActivo = clienteRepository.findByActivoById(datos.idAmo());
        if(!clienteActivo){
            throw new ValidacionException("El cliente (Amo) no está activo, revisar este id.");
        }
    }

}
