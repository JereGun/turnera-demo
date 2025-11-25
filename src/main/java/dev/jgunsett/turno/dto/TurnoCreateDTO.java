package dev.jgunsett.turno.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class TurnoCreateDTO {
    private LocalDateTime fechaHora;
    private Long clienteId;
    private Long profesionalId;
    private Long agendaId;
    private String observaciones;
}
