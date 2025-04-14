package com.brayandvlp.JannieVet.domain.cliente;

import com.brayandvlp.JannieVet.domain.cliente.dtos.DatosActualizarCliente;
import com.brayandvlp.JannieVet.domain.cliente.dtos.DatosRegistrarCliente;
import com.brayandvlp.JannieVet.domain.direccion.Direccion;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Table(name = "clientes")
@Entity(name = "Cliente")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String documento;
    private String nombreCompleto;
    private String numeroTelefonico;
    private String email;
    @Embedded
    private Direccion direccion;
    private LocalDateTime fecha;
    @Column(columnDefinition = "TINYINT(1)")
    private Boolean activo;

    public Cliente(@Valid DatosRegistrarCliente datosRegistrarCliente) {
        this.documento = datosRegistrarCliente.documentoIdentidad();
        this.nombreCompleto = datosRegistrarCliente.nombreCompleto();
        this.numeroTelefonico = datosRegistrarCliente.numeroTelefonico();
        this.email = datosRegistrarCliente.email();
        this.direccion = new Direccion(datosRegistrarCliente.direccion());
        this.fecha = LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES);
        this.activo=true;
    }

    public void actualizarDatos(@Valid DatosActualizarCliente datosActualizarCliente) {
        if (datosActualizarCliente.nombreCompleto() != null){
            this.nombreCompleto = datosActualizarCliente.nombreCompleto();
        }
        if(datosActualizarCliente.numeroTelefonico() != null){
            this.numeroTelefonico = datosActualizarCliente.numeroTelefonico();
        }
        if(datosActualizarCliente.email() != null){
            this.email = datosActualizarCliente.email();
        }
        if(datosActualizarCliente.direccion() != null){
            this.direccion = new Direccion(datosActualizarCliente.direccion());
        }
        if(datosActualizarCliente.activo() != null){
            this.activo = datosActualizarCliente.activo();
        }
        this.fecha = LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES);
    }

    public void desactivarCliente() { this.activo = false; }
}
