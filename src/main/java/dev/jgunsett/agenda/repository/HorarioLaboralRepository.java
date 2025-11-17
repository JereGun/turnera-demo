package dev.jgunsett.agenda.repository;

import dev.jgunsett.agenda.entity.HorarioLaboral;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HorarioLaboralRepository extends JpaRepository<HorarioLaboral, Long> {
}
