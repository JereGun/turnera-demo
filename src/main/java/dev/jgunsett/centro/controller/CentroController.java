package dev.jgunsett.centro.controller;

import dev.jgunsett.centro.dto.CentroDTO;
import dev.jgunsett.centro.service.CentroService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/centros")
@RequiredArgsConstructor
public class CentroController {

    private final CentroService centroService;

    @GetMapping
    public ResponseEntity<List<CentroDTO>> listar() {
        return ResponseEntity.ok(centroService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CentroDTO> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(centroService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<CentroDTO> crear(@Valid @RequestBody CentroDTO dto, Long paisId, Long provinciaId) {
        return new ResponseEntity<>(centroService.crear(dto, paisId, provinciaId), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CentroDTO> actualizar(@PathVariable Long id, @Valid @RequestBody CentroDTO dto, Long paisId, Long provinciaId) {
        return ResponseEntity.ok(centroService.actualizar(id, dto, paisId, provinciaId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
        centroService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
