package dev.jgunsett.agenda.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HorarioLaboralDTO {
    private Integer diaSemana;
    private LocalTime horaInicio;
    private LocalTime horaFin;
}
