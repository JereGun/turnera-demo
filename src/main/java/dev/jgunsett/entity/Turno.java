package dev.jgunsett.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
    private Agenda agenda;

    private EstadoTurno estado;

    private String observaciones;
}
