package com.brayandvlp.JannieVet.domain.cliente;

import com.brayandvlp.JannieVet.domain.direccion.Direccion;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

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
    private Boolean activo;

}
