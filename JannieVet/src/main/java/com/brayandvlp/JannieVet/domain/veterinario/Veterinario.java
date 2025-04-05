package com.brayandvlp.JannieVet.domain.veterinario;

import com.brayandvlp.JannieVet.domain.direccion.Direccion;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "veterinarios")
@Entity(name = "Veterinario")
//Anotaciones lombok
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Veterinario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String documento;
    private String nombreCompleto;
    private String numeroTelefonico;
    private String email;
    @Embedded
    private Direccion direccion;
    @Enumerated(EnumType.STRING)
    private Especialidad especialidad;
    private LocalDateTime fecha;
    private Boolean activo;

    public Veterinario(DatosRegistrarVeterinario datosRegistro){
        this.documento = datosRegistro.documentoIdentidad();
        this.nombreCompleto = datosRegistro.nombreCompleto();
        this.numeroTelefonico = datosRegistro.numeroTelefonico();
        this.email = datosRegistro.email();
        this.direccion = new Direccion(datosRegistro.direccion());
        this.especialidad = datosRegistro.especialidad();
        this.fecha = datosRegistro.fecha();
        this.activo = datosRegistro.activo();
    }

}
