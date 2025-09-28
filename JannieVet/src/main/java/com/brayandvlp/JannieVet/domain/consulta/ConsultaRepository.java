package com.brayandvlp.JannieVet.domain.consulta;

import com.brayandvlp.JannieVet.domain.mascotaPaciente.MascotaPaciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
    Boolean existsByPacienteIdAndFechaAndMotivoCancelamientoIsNull(Long idPaciente, LocalDateTime fechaConsulta);
    Boolean existsByVeterinarioIdAndFechaAndMotivoCancelamientoIsNull(Long id, LocalDateTime fecha);
}
