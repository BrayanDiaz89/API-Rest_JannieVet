package com.brayandvlp.JannieVet.domain.cliente.dtos;

import com.brayandvlp.JannieVet.domain.direccion.dtos.DatosDireccion;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

public record DatosRegistrarCliente(@NotBlank
                                    @Pattern(regexp = "^\\d{6,10}$", message = "El documento debe tener de 6 a 10 dígitos.")
                                    String documentoIdentidad,
                                    @NotBlank(message = "Debe ingresar un nombre.")
                                    String nombreCompleto,
                                    @NotBlank
                                    @Pattern(regexp = "^3\\d{9}$", message = "El número telefónico debe empezar por 3 y tener de 10 dígitos.")
                                    String numeroTelefonico,
                                    @NotBlank(message = "Debe ingresar un email válido.")
                                    @Email
                                    String email,
                                    @NotNull(message = "La dirección no debe tener ningún campo vacío.") //Es un objeto contiene más atributos dentro
                                    @Valid
                                    DatosDireccion direccion//Por lo que retornario nulo, y no blanco.
) {
}
