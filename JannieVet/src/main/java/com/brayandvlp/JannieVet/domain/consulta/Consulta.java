package com.brayandvlp.JannieVet.domain.consulta;

import com.brayandvlp.JannieVet.domain.mascotaPaciente.MascotaPaciente;
import com.brayandvlp.JannieVet.domain.veterinario.Veterinario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "consultas")
@Entity(name = "Consulta")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double precioConsulta;
    private LocalDateTime fecha;
    @Enumerated(EnumType.STRING)
    private MotivoCancelamiento motivoCancelamiento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_veterinario")
    private Veterinario veterinario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_paciente")
    private MascotaPaciente mascotaPaciente;

}
