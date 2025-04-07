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
    private String codigoPostal;
    private String calle;
    private String numero;
    private String complemento;

    public Direccion(DatosDireccion direccion){
        this.ciudad = direccion.ciudad();
        this.codigoPostal = direccion.codigoPostal();
        this.calle = direccion.calle();
        this.numero = direccion.numero();
        this.complemento = direccion.complemento();
    }

}
