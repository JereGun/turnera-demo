package dev.jgunsett.centro.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "feriados")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DiaNoLaboral {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate fecha;

    private String motivo; //"Feriado Nacional", "Puente Turistico", etc.

    @ManyToOne
    private Centro centro;

}
