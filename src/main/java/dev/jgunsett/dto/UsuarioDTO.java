package dev.jgunsett.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.*;

/*DTO (Data Transfer Object) se usa para comunicar datos entre el backend y el frontend (o API), sin exponer la entidad directamente.
* En vez de usar la entidad se usa su controlador.*/

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsuarioDTO {
	
	private Long id;
	
    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @NotBlank(message = "El apellido es obligatorio")
    private String apellido;

    @Email(message = "El correo debe tener un formato válido")
    @NotBlank(message = "El correo es obligatorio")
    private String email;

    @Pattern(regexp = "\\d{10,15}", message = "El teléfono debe tener entre 10 y 15 dígitos")
    private String telefono;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @NotBlank(message = "El rol es obligatorio")
    private String rol;

}
