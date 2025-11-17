package dev.jgunsett.agenda.entity;

import dev.jgunsett.centro.entity.Centro;
import dev.jgunsett.turno.entity.Turno;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
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

    @Builder.Default
    @OneToMany(mappedBy = "agenda", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HorarioLaboral> horarios = new ArrayList<>();

    @NotNull
    @ManyToOne
    @JoinColumn(name = "centro_id", nullable = false)
    private Centro centro;

    @Builder.Default
    @OneToMany(mappedBy = "agenda", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Turno> turnos = new ArrayList<>();

    private LocalDateTime fechaCreacion = LocalDateTime.now();

    private LocalDateTime fechaModificacion;

    @PreUpdate
    public void onUpdate() {
        this.fechaModificacion = LocalDateTime.now();
    }
}
