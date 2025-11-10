package dev.jgunsett.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.time.LocalTime;

public class Turno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate fecha;

    private LocalTime hora;

    private Usuario cliente;

    private Usuario profesional;

    private Agenda agenda;

    private EstadoTurno estado;

    private String observaciones;
}
