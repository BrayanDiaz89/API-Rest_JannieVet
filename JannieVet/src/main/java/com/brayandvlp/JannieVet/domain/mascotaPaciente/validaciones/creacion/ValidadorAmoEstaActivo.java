package com.brayandvlp.JannieVet.domain.mascotaPaciente.validaciones.creacion;

import com.brayandvlp.JannieVet.domain.cliente.ClienteRepository;
import com.brayandvlp.JannieVet.domain.mascotaPaciente.dtos.DatosRegistrarPaciente;
import com.brayandvlp.JannieVet.infra.errores.ValidacionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorAmoEstaActivo  implements ValidadorDePacientes{

    @Autowired
    private ClienteRepository clienteRepository;

    public void validar(DatosRegistrarPaciente datosRegistrarPaciente){

        var amoEstaActivo = clienteRepository.findByActivoById(datosRegistrarPaciente.idAmo());
        if(!amoEstaActivo){
            throw new ValidacionException("El amo no está activo, debe ser activado en la tabla clientes.");
        }
    }

}
