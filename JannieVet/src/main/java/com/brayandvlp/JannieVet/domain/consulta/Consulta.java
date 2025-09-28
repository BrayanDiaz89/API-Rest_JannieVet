package com.brayandvlp.JannieVet.domain.consulta;

import com.brayandvlp.JannieVet.domain.consulta.dtos.DatosRegistroConsulta;
import com.brayandvlp.JannieVet.domain.mascotaPaciente.MascotaPaciente;
import com.brayandvlp.JannieVet.domain.pago.Pago;
import com.brayandvlp.JannieVet.domain.veterinario.Especialidad;
import com.brayandvlp.JannieVet.domain.veterinario.Veterinario;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
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
    private LocalDateTime fecha;
    @Enumerated(EnumType.STRING)
    private MotivoCancelamiento motivoCancelamiento;
    private String motivoConsulta;
    @Enumerated(EnumType.STRING)
    private Especialidad especialidad;
    private String diagnostico;
    private String tratamiento;
    @Column(columnDefinition = "TINYINT(1)")
    private Boolean activa;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_veterinario")
    private Veterinario veterinario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_paciente")
    private MascotaPaciente mascotaPaciente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pago")
    private Pago pago;

    public Consulta(@Valid LocalDateTime fecha, String motivoConsulta, Especialidad especialidad, Veterinario veterinario, MascotaPaciente mascotaPaciente){
        this.fecha = fecha != null ? fecha : LocalDateTime.now();
        if(motivoConsulta != null && !motivoConsulta.isBlank()){
            this.motivoConsulta = motivoConsulta;
        }
        if(especialidad != null){
            this.especialidad = especialidad;
        }
        if(veterinario != null){
            this.veterinario = veterinario;
        }
        if(mascotaPaciente != null) {
            this.mascotaPaciente = mascotaPaciente;
        }
        this.activa = true;
    }

}
