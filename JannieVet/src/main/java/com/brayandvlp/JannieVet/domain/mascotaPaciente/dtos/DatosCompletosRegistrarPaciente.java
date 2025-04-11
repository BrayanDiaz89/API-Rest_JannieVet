package com.brayandvlp.JannieVet.domain.mascotaPaciente.dtos;

import com.brayandvlp.JannieVet.domain.cliente.Cliente;
import com.fasterxml.jackson.annotation.JsonProperty;

public record DatosCompletosRegistrarPaciente(
        @JsonProperty("paciente")
        DatosRegistrarPaciente paciente,
        @JsonProperty("cliente")
        Cliente cliente
) {
}
