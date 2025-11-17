package dev.jgunsett.agenda.dto;

import lombok.Data;
import java.util.List;

@Data

public class AgendaCreateDTO {
    private String nombre;
    private Long centroId;
    private List<HorarioLaboralDTO> horarios;
}
