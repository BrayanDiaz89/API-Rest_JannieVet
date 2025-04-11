package com.brayandvlp.JannieVet.domain.mascotaPaciente;

import com.brayandvlp.JannieVet.domain.cliente.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface PacienteRepository extends JpaRepository<MascotaPaciente, Long> {

    boolean existsByNombrePacienteAndFechaNacimientoAndColorAndEspecieAndCliente(
            String nombrePaciente,
            LocalDate fechaNacimiento,
            String color,
            Especie especie,
            Cliente cliente
    );

}
