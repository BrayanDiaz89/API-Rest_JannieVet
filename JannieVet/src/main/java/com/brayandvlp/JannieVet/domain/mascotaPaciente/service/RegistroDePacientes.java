package com.brayandvlp.JannieVet.domain.mascotaPaciente.service;

import com.brayandvlp.JannieVet.domain.cliente.ClienteRepository;
import com.brayandvlp.JannieVet.domain.mascotaPaciente.MascotaPaciente;
import com.brayandvlp.JannieVet.domain.mascotaPaciente.PacienteRepository;
import com.brayandvlp.JannieVet.domain.mascotaPaciente.dtos.DatosRegistrarPaciente;
import com.brayandvlp.JannieVet.domain.mascotaPaciente.dtos.DatosRespuestaPaciente;
import com.brayandvlp.JannieVet.domain.mascotaPaciente.validaciones.creacion.ValidadorDePacientes;
import com.brayandvlp.JannieVet.infra.errores.ValidacionException;
import jakarta.validation.Valid;
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

    public DatosRespuestaPaciente crearPaciente (DatosRegistrarPaciente datosRegistrarPaciente){

        if(!clienteRepository.existsById(datosRegistrarPaciente.idAmo())){
            throw new ValidacionException("El amo no está registrado en la base de datos, debe ser creado como cliente.");
        }
        //Validadores de creación de pacientes
        validadoresCreacion.forEach(v->v.validar(datosRegistrarPaciente));

        //Una vez validado entonces crea el paciente
        var cliente = clienteRepository.findById(datosRegistrarPaciente.idAmo()).get();
        var registro = new MascotaPaciente(null, cliente, datosRegistrarPaciente.nombre(), datosRegistrarPaciente.edad(), datosRegistrarPaciente.especie(),
                datosRegistrarPaciente.raza(), datosRegistrarPaciente.peso(), datosRegistrarPaciente.color(), datosRegistrarPaciente.fechaNacimiento(),
                null);

        pacienteRepository.save(registro);
        return new DatosRespuestaPaciente(registro);
    }
}
