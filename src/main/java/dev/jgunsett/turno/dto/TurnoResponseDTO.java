package dev.jgunsett.turno.dto;

import lombok.Builder;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Builder
public class TurnoResponseDTO {
    private Long id;
    private LocalDateTime fechaHora;
    private Long clienteId;
    private Long profesionalId;
    private Long agendaId;
    private String estado;
    private String observaciones;
    private LocalDateTime fechaCreacion;
}
