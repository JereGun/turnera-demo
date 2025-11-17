package dev.jgunsett.agenda.controller;

import dev.jgunsett.agenda.dto.AgendaCreateDTO;
import dev.jgunsett.agenda.dto.AgendaResponseDTO;
import dev.jgunsett.agenda.service.AgendaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/agendas")
@RequiredArgsConstructor
public class AgendaController {

    private final AgendaService agendaService;

    @PostMapping
    public ResponseEntity<AgendaResponseDTO> crearAgenda(@RequestBody @Valid AgendaCreateDTO dto) {
        return ResponseEntity.ok(agendaService.crearAgenda(dto));
    }
}
