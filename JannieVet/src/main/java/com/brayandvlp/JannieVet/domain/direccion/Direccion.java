package com.brayandvlp.JannieVet.domain.direccion;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Direccion {

    @Enumerated(EnumType.STRING)
    private Ciudad ciudad;
    private Integer codigoPostal;
    private String calle;
    private String numero;
    private String complemento;

}
