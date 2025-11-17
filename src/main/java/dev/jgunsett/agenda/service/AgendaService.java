package dev.jgunsett.agenda.service;

import dev.jgunsett.agenda.dto.AgendaCreateDTO;
import dev.jgunsett.agenda.dto.AgendaResponseDTO;
import dev.jgunsett.agenda.dto.HorarioLaboralDTO;
import dev.jgunsett.agenda.entity.Agenda;
import dev.jgunsett.agenda.entity.HorarioLaboral;
import dev.jgunsett.agenda.mapper.AgendaMapper;
import dev.jgunsett.agenda.repository.AgendaRepository;
import dev.jgunsett.centro.entity.Centro;
import dev.jgunsett.centro.repository.CentroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AgendaService {

    private final AgendaRepository agendaRepository;
    private final CentroRepository centroRepository;
    private final AgendaMapper agendaMapper;

    public AgendaResponseDTO crearAgenda(AgendaCreateDTO dto) {

        Centro centro = centroRepository.findById(dto.getCentroId())
                .orElseThrow(() -> new RuntimeException("Centro no encontrado"));

        Agenda agenda = agendaMapper.toEntity(dto);
        agenda.setCentro(centro);

        // Crear horarios laborales
        if (dto.getHorarios() != null) {
            for (HorarioLaboralDTO hDto : dto.getHorarios()) {
                HorarioLaboral h = HorarioLaboral.builder()
                        .diaSemana(hDto.getDiaSemana())
                        .horaInicio(hDto.getHoraInicio())
                        .horaFin(hDto.getHoraFin())
                        .agenda(agenda)
                        .build();

                agenda.getHorarios().add(h);
            }
        }

        agendaRepository.save(agenda);

        return agendaMapper.toDTO(agenda);
    }
}
