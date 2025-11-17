package dev.jgunsett.turno.entity;

import dev.jgunsett.agenda.entity.Agenda;
import dev.jgunsett.usuario.entity.Usuario;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;

public class Turno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private LocalDate fecha;

    @NotNull
    private LocalTime hora;

    @ManyToOne
    private Usuario cliente;

    @ManyToOne
    private Usuario profesional;

    @ManyToOne
    @JoinColumn(name = "agenda_id")
    private Agenda agenda;

    private EstadoTurno estado;

    private String observaciones;
}
