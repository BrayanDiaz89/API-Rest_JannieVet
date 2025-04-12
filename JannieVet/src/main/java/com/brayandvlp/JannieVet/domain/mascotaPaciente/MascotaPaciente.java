package com.brayandvlp.JannieVet.domain.mascotaPaciente;

import com.brayandvlp.JannieVet.domain.cliente.Cliente;

import jakarta.persistence.*;
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
    public static final double diasAño = 365.25;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_clienteAmo")
    private Cliente cliente;

    @Transient
    public double getEdad(){
        LocalDate hoy = LocalDate.now();
        long diasEntre = ChronoUnit.DAYS.between(fechaNacimiento, hoy);
        //Teniendo en cuenta años bisiestos  365.25
        double edadDecimal = diasEntre / diasAño;
        return Math.round(edadDecimal * 10.0) / 10.0;
    }

    public MascotaPaciente(Long id, Cliente cliente, String nombre, Especie especie, String raza, Double peso,
                           String color, LocalDate fechaNacimiento, Boolean activo){
        this.id = id;
        this.cliente = cliente;
        this.nombrePaciente = nombre;
        this.especie = especie;
        this.raza = raza;
        this.peso = peso;
        this.color = color;
        this.fechaNacimiento = fechaNacimiento;
        if(activo == null) {
            this.activo = true;
        }
    }
}
