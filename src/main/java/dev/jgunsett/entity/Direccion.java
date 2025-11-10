package dev.jgunsett.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "direcciones")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Direccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String calle;

    private String numero;

    private String ciudad;

    private String provincia;

    private String pais;
}
