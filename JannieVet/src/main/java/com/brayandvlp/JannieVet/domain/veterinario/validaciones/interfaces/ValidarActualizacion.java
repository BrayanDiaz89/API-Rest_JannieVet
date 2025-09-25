package com.brayandvlp.JannieVet.domain.veterinario.validaciones.interfaces;

import com.brayandvlp.JannieVet.domain.veterinario.dtos.DatosActualizarVeterinario;
import com.brayandvlp.JannieVet.domain.veterinario.dtos.DatosRespuestaVeterinario;

public interface ValidarActualizacion {
    void validar(DatosActualizarVeterinario datosActualizacion);
}
