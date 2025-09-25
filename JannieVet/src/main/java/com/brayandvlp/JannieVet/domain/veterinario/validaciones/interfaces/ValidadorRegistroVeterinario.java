package com.brayandvlp.JannieVet.domain.veterinario.validaciones.interfaces;

import com.brayandvlp.JannieVet.domain.veterinario.dtos.DatosRegistrarVeterinario;

public interface ValidadorRegistroVeterinario {
    void validar(DatosRegistrarVeterinario datosRegistro);
}
