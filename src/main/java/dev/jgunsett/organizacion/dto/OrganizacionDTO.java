package dev.jgunsett.organizacion.dto;

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
public class OrganizacionDTO {

    private Long id;

    @NotBlank(message = "La razon social es obligatoria")
    private String razonSocial;

    private String nombreFantasia;

    @Email(message = "El correo debe tener un formato valido")
    @NotBlank(message = "El correo es obligatorio")
    private String email;

    private String telefono;

    private Boolean activa;

    private String calle;
    private String numero;
    private String ciudad;
    private Long provinciaId;
    private Long paisId;
}
