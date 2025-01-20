package com.brayandvlp.JannieVet.domain.veterinario;

import com.brayandvlp.JannieVet.domain.direccion.Direccion;
import jakarta.persistence.*;
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
    private Long documento;
    private String nombreCompleto;
    private Integer numeroTelefonico;
    private String email;
    @Embedded
    private Direccion direccion;
    @Enumerated(EnumType.STRING)
    private Especialidad especialidad;
    private LocalDateTime fecha;
    private Boolean activo;


}
