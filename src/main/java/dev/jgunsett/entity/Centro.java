package dev.jgunsett.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "centros")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Centro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nombre;

    private String direccion;

    private String telefono;

    @NotBlank
    @Email
    private String email;

    @ManyToOne
    @JoinColumn(name = "organizacion_id")
    private Organizacion organizacion;

}
