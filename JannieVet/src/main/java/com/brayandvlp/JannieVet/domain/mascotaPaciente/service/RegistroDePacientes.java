package com.brayandvlp.JannieVet.domain.mascotaPaciente.service;

import com.brayandvlp.JannieVet.domain.cliente.ClienteRepository;
import com.brayandvlp.JannieVet.domain.mascotaPaciente.MascotaPaciente;
import com.brayandvlp.JannieVet.domain.mascotaPaciente.PacienteRepository;
import com.brayandvlp.JannieVet.domain.mascotaPaciente.dtos.DatosCompletosRegistrarPaciente;
import com.brayandvlp.JannieVet.domain.mascotaPaciente.dtos.DatosListadoPacientes;
import com.brayandvlp.JannieVet.domain.mascotaPaciente.validaciones.creacion.ValidadorDePacientes;
import com.brayandvlp.JannieVet.infra.errores.ValidacionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistroDePacientes {
    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private List<ValidadorDePacientes> validadoresCreacion;

    public DatosListadoPacientes crearPaciente (DatosCompletosRegistrarPaciente datosRegistro){

        if(!clienteRepository.existsById(datosRegistro.cliente().getId())){
            throw new ValidacionException("El amo no está registrado en la base de datos, debe ser creado como cliente.");
        }
        if(datosRegistro.cliente().getId() == null){
            throw new ValidacionException("El cliente está llegando null.");
        }

        //Validadores de creación de pacientes
        validadoresCreacion.forEach(v->v.validar(datosRegistro));

        //Una vez validado entonces crea el paciente
        var cliente = clienteRepository.findById(datosRegistro.cliente().getId()).get();
        var registro = new MascotaPaciente(null, cliente, datosRegistro.paciente().nombre(), datosRegistro.paciente().especie(),
                datosRegistro.paciente().raza(), datosRegistro.paciente().peso(), datosRegistro.paciente().color(), datosRegistro.paciente().fechaNacimiento());

        pacienteRepository.save(registro);
        return new DatosListadoPacientes(registro);
    }
}
