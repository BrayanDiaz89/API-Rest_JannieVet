package com.brayandvlp.JannieVet.domain.mascotaPaciente.validaciones.actualizacion;

import com.brayandvlp.JannieVet.domain.mascotaPaciente.dtos.DatosActualizarPaciente;

public interface ValidadorDeActualizacion {
    void validarActualizacion(DatosActualizarPaciente datos);
}
