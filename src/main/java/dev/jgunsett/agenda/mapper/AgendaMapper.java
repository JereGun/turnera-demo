package dev.jgunsett.agenda.mapper;

import dev.jgunsett.agenda.dto.AgendaCreateDTO;
import dev.jgunsett.agenda.dto.AgendaResponseDTO;
import dev.jgunsett.agenda.dto.HorarioLaboralDTO;
import dev.jgunsett.agenda.entity.Agenda;
import org.springframework.stereotype.Component;

@Component
public class AgendaMapper {
    public Agenda toEntity(AgendaCreateDTO dto){
        Agenda agenda = new Agenda();
        agenda.setNombre(dto.getNombre());
        return agenda;
    }

    public AgendaResponseDTO toDTO(Agenda agenda){
        return AgendaResponseDTO.builder()
                .id(agenda.getId())
                .nombre(agenda.getNombre())
                .centroId(agenda.getCentro().getId())
                .horarios(
                        agenda.getHorarios().stream().map(h ->
                                new HorarioLaboralDTO(
                                        h.getDiaSemana(),
                                        h.getHoraInicio(),
                                        h.getHoraFin()
                                )
                        ).toList()
                )
                .fechaCreacion(agenda.getFechaCreacion())
                .build();
    }
}
