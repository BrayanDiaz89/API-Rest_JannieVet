package com.brayandvlp.JannieVet.domain.mascotaPaciente;

import com.brayandvlp.JannieVet.domain.cliente.Cliente;

import com.brayandvlp.JannieVet.domain.cliente.dtos.DatosActualizarCliente;
import com.brayandvlp.JannieVet.domain.mascotaPaciente.dtos.DatosActualizarPaciente;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.mapping.UniqueKey;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Table(name = "pacientes")
@Entity(name = "MascotaPaciente")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class MascotaPaciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombrePaciente;
    @Transient
    private Double edad;
    @Enumerated(EnumType.STRING)
    private Especie especie;
    private String raza;
    private Double peso;
    private String color;
    private LocalDate fechaNacimiento;
    @Column(columnDefinition = "TINYINT(1)")
    private Boolean activo;
    @Transient
    public static final double diasAno = 365.25;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_clienteAmo")
    private Cliente cliente;

    @Transient
    public double getEdad(){
        LocalDate hoy = LocalDate.now();
        long diasEntre = ChronoUnit.DAYS.between(fechaNacimiento, hoy);
        //Teniendo en cuenta años bisiestos  365.25
        double edadDecimal = diasEntre / diasAno;
        return Math.round(edadDecimal * 10.0) / 10.0;
    }

    //Constructor para registrar paciente
    public MascotaPaciente(@Valid Long id, Cliente cliente, String nombre, Especie especie, String raza, Double peso,
                           String color, LocalDate fechaNacimiento){
        this.id = id;
        this.cliente = cliente;
        this.nombrePaciente = nombre;
        this.especie = especie;
        this.raza = raza;
        this.peso = peso;
        this.color = color;
        this.fechaNacimiento = fechaNacimiento;
        this.activo = true;
    }
    //Constructor para Actualizar paciente
    public void actualizarPaciente(DatosActualizarPaciente datosActualizarPaciente) {
        if(datosActualizarPaciente.peso() != null){
            this.peso = datosActualizarPaciente.peso();
        }
        if(datosActualizarPaciente.activo() == null){
            this.activo = true;
        } else {
            this.activo = datosActualizarPaciente.activo();
        }
    }

}
