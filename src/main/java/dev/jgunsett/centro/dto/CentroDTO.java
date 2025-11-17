package dev.jgunsett.centro.dto;

import dev.jgunsett.organizacion.entity.Organizacion;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CentroDTO {
    private Long id;

    @NotBlank
    private String nombre;

    private String telefono;

    @NotBlank
    @Email
    private String email;

    private Organizacion organizacion;

    // Direccion
    private String calle;
    private String numero;
    private String ciudad;
    private Long paisId;
    private Long provinciaId;

    private Boolean activo;
}
