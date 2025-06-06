package com.brayandvlp.JannieVet.domain.veterinario;

import com.brayandvlp.JannieVet.domain.direccion.Direccion;
import com.brayandvlp.JannieVet.domain.direccion.dtos.DatosDireccion;
import com.brayandvlp.JannieVet.domain.veterinario.dtos.DatosActualizarVeterinario;
import com.brayandvlp.JannieVet.domain.veterinario.dtos.DatosRegistrarVeterinario;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

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
    @Column(columnDefinition = "TINYINT(1)")
    private Boolean activo;

    public Veterinario(DatosRegistrarVeterinario datosRegistro){
        this.documento = datosRegistro.documentoIdentidad();
        this.nombreCompleto = datosRegistro.nombreCompleto();
        this.numeroTelefonico = datosRegistro.numeroTelefonico();
        this.email = datosRegistro.email();
        this.direccion = new Direccion(datosRegistro.direccion());
        this.especialidad = datosRegistro.especialidad();
        this.fecha = LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES);
        this.activo = true;
    }

    public void actualizarDatos(@Valid DatosActualizarVeterinario datosActualizacion) {
        
        if(datosActualizacion.nombreCompleto() != null){
            this.nombreCompleto = datosActualizacion.nombreCompleto();
        }
        if(datosActualizacion.numeroTelefonico() != null){
            this.numeroTelefonico = datosActualizacion.numeroTelefonico();
        }
        if(datosActualizacion.email() != null){
            this.email= datosActualizacion.email();
        }
        if(datosActualizacion.direccion() != null){
            this.direccion = new Direccion(datosActualizacion.direccion());
        }
        if(datosActualizacion.especialidad() != null){
            this.especialidad = datosActualizacion.especialidad();
        }
        if(datosActualizacion.activo() != null){
            this.activo = datosActualizacion.activo();
        }
    }

    public void desactivarVeterinario() { this.activo = false; }

}
