package com.brayandvlp.JannieVet.domain.pago;

import com.brayandvlp.JannieVet.domain.cliente.Cliente;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "Pago")
@Table(name = "pagos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(precision = 10, scale = 2)
    private BigDecimal cantidad;
    @Enumerated(EnumType.STRING)
    private TipoDePago tipoDePago;
    @Enumerated(EnumType.STRING)
    private Estado estado;
    private LocalDateTime fecha;
    private String comprobante;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

}
