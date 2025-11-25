package dev.jgunsett.agenda.controller;

import dev.jgunsett.agenda.dto.AgendaCreateDTO;
import dev.jgunsett.agenda.dto.AgendaResponseDTO;
import dev.jgunsett.agenda.service.AgendaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/agendas")
@RequiredArgsConstructor
public class AgendaController {

    private final AgendaService agendaService;

    @PostMapping
    public ResponseEntity<AgendaResponseDTO> crear(@RequestBody @Valid AgendaCreateDTO dto) {
        return ResponseEntity.ok(agendaService.crearAgenda(dto));
    }

    @GetMapping
    public ResponseEntity<List<AgendaResponseDTO>> listar() {
        return ResponseEntity.ok(agendaService.listarAgendas());
    }
}
