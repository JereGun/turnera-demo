package dev.jgunsett.mapper;

import dev.jgunsett.dto.UsuarioDTO;
import dev.jgunsett.entity.Usuario;
import org.springframework.stereotype.Component;

/* Es una clase encargada de convertir entre la entidad y el DTO*/
@Component //Le dice a Spring que esta clase debe ser un bean gestionado (puede ser inyectada en otras clases con @Autowired o @RequiredArgsConstructor).
public class UsuarioMapper {
	
    public Usuario toEntity(UsuarioDTO dto) {
        return Usuario.builder()
                .id(dto.getId())
                .nombre(dto.getNombre())
                .apellido(dto.getApellido())
                .email(dto.getEmail())
                .telefono(dto.getTelefono())
                .rol(dto.getRol())
                .password(dto.getPassword())
                .build();
    }

    public UsuarioDTO toDTO(Usuario entity) {
        return UsuarioDTO.builder()
                .id(entity.getId())
                .nombre(entity.getNombre())
                .apellido(entity.getApellido())
                .email(entity.getEmail())
                .telefono(entity.getTelefono())
                .rol(entity.getRol())
                // nota: no psw en la respuesta
                .build();
    }

}
