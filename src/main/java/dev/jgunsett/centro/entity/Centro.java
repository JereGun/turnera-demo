package dev.jgunsett.centro.entity;

import dev.jgunsett.organizacion.entity.Organizacion;
import dev.jgunsett.direccion.entity.Pais;
import dev.jgunsett.direccion.entity.Provincia;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    private String telefono;

    @NotBlank
    @Email
    private String email;

    @ManyToOne
    @JoinColumn(name = "organizacion_id")
    private Organizacion organizacion;

    // Direccion
    private String calle;
    private String numero;
    private String ciudad;
    private Pais pais;
    private Provincia provincia;

    private Boolean activo;

}
