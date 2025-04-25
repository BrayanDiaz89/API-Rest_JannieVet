package com.brayandvlp.JannieVet.domain.mascotaPaciente.validaciones.actualizacion;

import com.brayandvlp.JannieVet.domain.cliente.ClienteRepository;
import com.brayandvlp.JannieVet.domain.mascotaPaciente.PacienteRepository;
import com.brayandvlp.JannieVet.domain.mascotaPaciente.dtos.DatosActualizarPaciente;
import com.brayandvlp.JannieVet.infra.errores.ValidacionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorIdAmoCoincideConPaciente implements ValidadorDeActualizacion{

    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private ClienteRepository clienteRepository;

    public void validarActualizacion(DatosActualizarPaciente datos){

        var clienteEsAmoDePaciente = pacienteRepository.findByClienteIdAndIdPaciente(datos.id(), datos.idAmo());
        if(!clienteEsAmoDePaciente){
            throw new ValidacionException("El id del amo no coincide con la mascota que desea actualizar.");
        }
    }

}
