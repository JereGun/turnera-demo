package dev.jgunsett.service;
import dev.jgunsett.dto.UsuarioDTO;
import dev.jgunsett.entity.Usuario;
import dev.jgunsett.exception.ResourceNotFoundException;
import dev.jgunsett.mapper.UsuarioMapper;
import dev.jgunsett.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

/* Service es la capa en donde se aloja la logica de negocios, validaciones y procesos intermedios */

@Service //Marca la clase como un servicio (lógica de negocio). Spring la detecta como un bean.
@RequiredArgsConstructor //Genera un constructor con los campos final automáticamente, para inyección de dependencias (sin necesidad de usar @Autowired).
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;
    private final PasswordEncoder passwordEncoder;
    
    public UsuarioDTO crearUsuario(UsuarioDTO dto) {
        Usuario usuario = usuarioMapper.toEntity(dto);
        // Hashear la contra
        if (dto.getPassword() !=null && !dto.getPassword().isBlank()){
            usuario.setPassword(passwordEncoder.encode(dto.getPassword()));
        }
        usuario = usuarioRepository.save(usuario);
        return usuarioMapper.toDTO(usuario);
    }

    public List<UsuarioDTO> listarTodos() {
        return usuarioRepository.findAll()
                .stream()
                .map(usuarioMapper::toDTO)
                .toList();
    }

    public UsuarioDTO buscarPorId(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado con ID: " + id));
        return usuarioMapper.toDTO(usuario);
    }

    public UsuarioDTO crear(UsuarioDTO dto) {
        if (usuarioRepository.existsByEmail(dto.getEmail())) {
            throw new IllegalArgumentException("Ya existe un usuario con ese correo");
        }
        Usuario usuario = usuarioMapper.toEntity(dto);
        return usuarioMapper.toDTO(usuarioRepository.save(usuario));
    }

    public UsuarioDTO actualizar(Long id, UsuarioDTO dto) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado con ID: " + id));
        usuario.setNombre(dto.getNombre());
        usuario.setEmail(dto.getEmail());
        usuario.setTelefono(dto.getTelefono());
        usuario.setRol(dto.getRol());
        return usuarioMapper.toDTO(usuarioRepository.save(usuario));
    }

    public void eliminar(Long id) {
        if (!usuarioRepository.existsById(id)) {
            throw new ResourceNotFoundException("No existe un usuario con el ID: " + id);
        }
        usuarioRepository.deleteById(id);
    }
}
