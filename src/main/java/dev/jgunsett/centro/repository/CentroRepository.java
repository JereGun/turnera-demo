package dev.jgunsett.centro.repository;

import dev.jgunsett.centro.entity.Centro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CentroRepository extends JpaRepository<Centro, Long> {
    Optional<Centro> findByNombre (String nombre);
}
