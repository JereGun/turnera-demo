package dev.jgunsett.turno.service;

import dev.jgunsett.agenda.entity.Agenda;
import dev.jgunsett.agenda.repository.AgendaRepository;
import dev.jgunsett.exception.ResourceNotFoundException;
import dev.jgunsett.turno.dto.TurnoCreateDTO;
import dev.jgunsett.turno.dto.TurnoResponseDTO;
import dev.jgunsett.turno.mapper.TurnoMapper;
import dev.jgunsett.turno.repository.TurnoRepository;
import dev.jgunsett.usuario.entity.Usuario;
import dev.jgunsett.usuario.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TurnoService {
    private final TurnoRepository turnoRepository;
    private final UsuarioRepository usuarioRepository;
    private final AgendaRepository agendaRepository;
    private final TurnoMapper turnoMapper;

    public TurnoResponseDTO crearTurno(TurnoCreateDTO dto){
        Usuario cliente = usuarioRepository.findById(dto.getClienteId())
                .orElseThrow(() -> new ResourceNotFoundException("Usuario -Cliente- con el ID: " + dto.getClienteId() + " No existe o no se encuentra"));

        Usuario profesional = usuarioRepository.findById(dto.getProfesionalId())
                .orElseThrow(() -> new ResourceNotFoundException("Usuario -Profesional- con el ID: " + dto.getProfesionalId() + " No existe o no se encuentra"));

        Agenda agenda = agendaRepository.findById(dto.getAgendaId())
                .orElseThrow(() -> new ResourceNotFoundException("Agenda con el ID: " + dto.getAgendaId() + " No existe o no se encuentra"));

        Turno turno =
    }
}
