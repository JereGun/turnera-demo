package dev.jgunsett.agenda.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Entity
@Table(name = "horario_laboral")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HorarioLaboral {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer diaSemana; //1=Lunes ... 7=Domingo

    private LocalTime horaInicio;
    private LocalTime horaFin;

    @ManyToOne
    @JoinColumn(name = "agenda_id")
    private Agenda agenda;
}
