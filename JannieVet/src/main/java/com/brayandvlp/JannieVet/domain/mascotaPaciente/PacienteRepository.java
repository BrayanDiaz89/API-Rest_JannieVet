package com.brayandvlp.JannieVet.domain.mascotaPaciente;

import com.brayandvlp.JannieVet.domain.cliente.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface PacienteRepository extends JpaRepository<MascotaPaciente, Long> {

    boolean existsByNombrePacienteAndFechaNacimientoAndColorAndEspecieAndCliente(
            String nombrePaciente,
            LocalDate fechaNacimiento,
            String color,
            Especie especie,
            Cliente cliente
    );

    Page<MascotaPaciente> findByActivoTrue(Pageable paginacion);

    Page<MascotaPaciente> findByActivoFalse(Pageable paginacion);

    Boolean existsByIdAndActivoTrue(Long id);

}