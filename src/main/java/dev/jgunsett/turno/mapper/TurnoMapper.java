package dev.jgunsett.turno.mapper;

import dev.jgunsett.agenda.entity.Agenda;
import dev.jgunsett.turno.dto.TurnoCreateDTO;
import dev.jgunsett.turno.dto.TurnoResponseDTO;
import dev.jgunsett.turno.entity.EstadoTurno;
import dev.jgunsett.turno.entity.Turno;
import dev.jgunsett.usuario.entity.Usuario;
import org.springframework.stereotype.Component;

@Component
public class TurnoMapper {
    public Turno toEntity(TurnoCreateDTO dto, Usuario cliente, Usuario profesional, Agenda agenda){
        return Turno.builder()
                .fechaHora(dto.getFechaHora())
                .cliente(cliente)
                .profesional(profesional)
                .agenda(agenda)
                .estado(EstadoTurno.PENDIENTE)
                .observaciones(dto.getObservaciones())
                .build();
    }

    public TurnoResponseDTO toDTO(Turno turno){
        return TurnoResponseDTO.builder()
                .id(turno.getId())
                .fechaHora(turno.getFechaHora())
                .clienteId(turno.getCliente().getId())
                .profesionalId(turno.getProfesional().getId())
                .agendaId(turno.getAgenda().getId())
                .estado(turno.getEstado().name())
                .observaciones(turno.getObservaciones())
                .fechaCreacion(turno.getFechaCreacion())
                .build();
    }
}
