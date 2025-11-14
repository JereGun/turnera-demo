package dev.jgunsett.entity;

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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "direccion_id", referencedColumnName = "id")
    private Direccion direccion;

    private Boolean activa;

    @OneToMany(mappedBy = "organizacion", cascade = CascadeType.ALL)
    private List<Centro> centros = new ArrayList<>();
}
