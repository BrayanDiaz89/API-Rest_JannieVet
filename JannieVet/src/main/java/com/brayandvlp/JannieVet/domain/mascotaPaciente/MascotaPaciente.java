package com.brayandvlp.JannieVet.domain.mascotaPaciente;

import com.brayandvlp.JannieVet.domain.cliente.Cliente;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
    private Raza raza;
    private Double peso;
    private String color;
    @Enumerated(EnumType.STRING)
    private Mes mesHappyBirthDay;
    private Boolean activo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_clienteAmo")
    private Cliente cliente;

}
