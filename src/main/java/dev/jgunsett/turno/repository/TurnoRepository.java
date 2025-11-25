package dev.jgunsett.turno.repository;

import dev.jgunsett.agenda.entity.Agenda;
import dev.jgunsett.turno.entity.Turno;
import dev.jgunsett.usuario.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TurnoRepository extends JpaRepository<Turno, Long> {
    List<Turno> findByCliente(Usuario cliente);
    List<Turno> findByProfesional(Usuario profesional);
    boolean existsByAgendaAndFechaHora(Agenda agenda, LocalDateTime fechaHora);
}
