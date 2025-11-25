package dev.jgunsett.turno.entity;

import dev.jgunsett.agenda.entity.Agenda;
import dev.jgunsett.usuario.entity.Usuario;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "turnos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Turno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private LocalDateTime fechaHora;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Usuario cliente;

    @ManyToOne
    @JoinColumn(name = "profesional_id")
    private Usuario profesional;

    @ManyToOne
    @JoinColumn(name = "agenda_id")
    private Agenda agenda;

    private EstadoTurno estado;

    private String observaciones;

    private LocalDateTime fechaCreacion = LocalDateTime.now();
}
