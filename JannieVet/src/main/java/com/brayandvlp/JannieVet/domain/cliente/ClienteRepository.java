package com.brayandvlp.JannieVet.domain.cliente;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Page<Cliente> findByActivoTrue(Pageable paginacion);
    Page<Cliente> findByActivoFalse(Pageable paginacion);

    @Query("""
           select c.activo
           from Cliente c
           where
           c.id = :idCliente
           """)
    boolean findByActivoById(Long idCliente);
    //Validar si un cliente ya existe:
    boolean existsByDocumentoOrEmailOrNumeroTelefonico(
            String documento,
            String email,
            String numeroTelefonico);

}
