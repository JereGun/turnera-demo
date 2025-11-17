package dev.jgunsett.usuario.controller;

import dev.jgunsett.usuario.dto.UsuarioDTO;
import dev.jgunsett.usuario.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/* Controller es la capa de presentacion (API REST)
* Es la puerta de entrada HTTP de la aplicacion. Define los endpoints y traduce los request/responses a DTOs*/

@RestController //Indica que esta clase es un controlador REST (Spring devuelve JSON automáticamente).
@RequestMapping("/api/usuarios") //Define la URL base para todos los endpoints del controlador.
@RequiredArgsConstructor //
public class UsuarioController {

    private final UsuarioService usuarioService;

    // ResponseEntity permite devolver tanto datos como el código de estado HTTP (200, 201, 204, etc.).
    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> listar() {

        return ResponseEntity.ok(usuarioService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(usuarioService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> crear(@Valid @RequestBody UsuarioDTO dto) {
        return new ResponseEntity<>(usuarioService.crear(dto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDTO> actualizar(@PathVariable Long id, @Valid @RequestBody UsuarioDTO dto) {
        return ResponseEntity.ok(usuarioService.actualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        usuarioService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}