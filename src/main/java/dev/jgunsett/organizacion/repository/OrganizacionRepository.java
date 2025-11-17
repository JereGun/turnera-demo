package dev.jgunsett.organizacion.repository;

import dev.jgunsett.organizacion.entity.Organizacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrganizacionRepository extends JpaRepository<Organizacion, Long> {

    Optional<Organizacion> findByRazonSocial (String razonSocial);

    Optional<Organizacion> findByNombreFantasia (String nombreFantasia);
}
