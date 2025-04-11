package com.brayandvlp.JannieVet.domain.mascotaPaciente;

import com.brayandvlp.JannieVet.domain.cliente.Cliente;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

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
    private Integer edad;
    @Enumerated(EnumType.STRING)
    private Especie especie;
    private String raza;
    private Double peso;
    private String color;
    private LocalDate fechaNacimiento;
    @Column(columnDefinition = "TINYINT(1)")
    private Boolean activo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_clienteAmo")
    private Cliente cliente;

    public MascotaPaciente(Long id, Cliente cliente, String nombre, Integer edad, Especie especie, String raza, Double peso,
                           String color, LocalDate fechaNacimiento, Boolean activo){
        this.id = id;
        this.cliente = cliente;
        this.nombrePaciente = nombre;
        this.edad = edad;
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
