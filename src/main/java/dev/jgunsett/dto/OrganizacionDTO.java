package dev.jgunsett.dto;

import dev.jgunsett.entity.Direccion;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class OrganizacionDTO {
    private Long id;
    private String razonSocial;
    private String nombreFantasia;
    private String email;
    private String telefono;
    private Direccion direccion;
    private Boolean activa;
}
