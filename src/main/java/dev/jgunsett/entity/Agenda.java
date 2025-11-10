package dev.jgunsett.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "agendas")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Agenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nombre; // Ej: "Agenda Dr. Perez"

    @NotBlank
    private LocalTime horaInicio;

    @NotBlank
    private LocalTime horaFin;

    @NotBlank
    private String diasHabiles;

    @ManyToOne
    @JoinColumn(name = "centro_id")
    private Centro centro;

    private List<Turno> turnos = new ArrayList<>();

}
