package com.brayandvlp.JannieVet.domain.mascotaPaciente.validaciones.actualizacion;

import com.brayandvlp.JannieVet.domain.cliente.ClienteRepository;
import com.brayandvlp.JannieVet.domain.mascotaPaciente.dtos.DatosActualizarPaciente;
import com.brayandvlp.JannieVet.infra.errores.ValidacionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorIdAmoExiste implements ValidadorDeActualizacion{

    @Autowired
    private ClienteRepository clienteRepository;

    public void validarActualizacion(DatosActualizarPaciente datos) {
        var clienteExiste = clienteRepository.existsById(datos.idAmo());
        if(!clienteExiste){
            throw new ValidacionException("El id del cliente amo no existe en la base de datos.");
        }
    }

}
