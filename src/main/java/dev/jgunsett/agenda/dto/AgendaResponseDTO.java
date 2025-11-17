package dev.jgunsett.agenda.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class AgendaResponseDTO {
    private Long id;
    private String nombre;
    private Long centroId;
    private List<HorarioLaboralDTO> horarios;
    private LocalDateTime fechaCreacion;
}
