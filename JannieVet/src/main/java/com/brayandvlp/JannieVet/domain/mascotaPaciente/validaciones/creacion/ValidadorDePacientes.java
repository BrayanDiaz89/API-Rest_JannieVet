package com.brayandvlp.JannieVet.domain.mascotaPaciente.validaciones.creacion;

import com.brayandvlp.JannieVet.domain.cliente.Cliente;
import com.brayandvlp.JannieVet.domain.mascotaPaciente.dtos.DatosCompletosRegistrarPaciente;
import com.brayandvlp.JannieVet.domain.mascotaPaciente.dtos.DatosRegistrarPaciente;

public interface ValidadorDePacientes {
    void validar(DatosCompletosRegistrarPaciente datosCompletosRegistrarPaciente);
}
