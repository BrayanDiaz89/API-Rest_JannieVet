package com.brayandvlp.JannieVet.domain.veterinario;

import com.brayandvlp.JannieVet.domain.consulta.MotivoCancelamiento;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface VeterinarioRepository extends JpaRepository<Veterinario, Long> {

    Page<Veterinario> findByActivoTrue(Pageable paginacion);
    Page<Veterinario> findByActivoFalse(Pageable paginacion);

    boolean existsByDocumentoOrNumeroTelefonicoOrEmail(String documento,
                                                   String numeroTelefonico,
                                                   String email);
}
