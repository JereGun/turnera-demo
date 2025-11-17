package dev.jgunsett.organizacion.entity;

import dev.jgunsett.centro.entity.Centro;
import dev.jgunsett.direccion.entity.Pais;
import dev.jgunsett.direccion.entity.Provincia;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="organizaciones")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Organizacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String razonSocial;

    private String nombreFantasia;

    @Email
    @NotBlank
    private String email;

    private String telefono;

    private Boolean activa;

    @OneToMany(mappedBy = "organizacion", cascade = CascadeType.ALL)
    private List<Centro> centros = new ArrayList<>();

    // Direccion
    private String calle;
    private String numero;
    private String ciudad;
    private Pais pais;
    private Provincia provincia;

}
