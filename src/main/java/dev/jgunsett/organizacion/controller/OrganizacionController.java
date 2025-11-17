package dev.jgunsett.organizacion.controller;

import dev.jgunsett.organizacion.dto.OrganizacionDTO;
import dev.jgunsett.organizacion.service.OrganizacionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/organizaciones")
@RequiredArgsConstructor
public class OrganizacionController {

    private final OrganizacionService organizacionService;

    @GetMapping
    public ResponseEntity<List<OrganizacionDTO>> listar() {
        return ResponseEntity.ok(organizacionService.listarOrganizaciones());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrganizacionDTO> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(organizacionService.buscarOrganizacion(id));
    }

    @PostMapping
    public ResponseEntity<OrganizacionDTO> crear(@Valid @RequestBody OrganizacionDTO dto, Long paisId, Long provinciaId){
        return new ResponseEntity<>(organizacionService.crearOrganizacion(dto, paisId, provinciaId), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrganizacionDTO> actualizar(@PathVariable Long id, @Valid @RequestBody OrganizacionDTO dto, Long paisId, Long provinciaId){
        return ResponseEntity.ok(organizacionService.actualizarOrganizacion(id, dto, paisId, provinciaId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
        organizacionService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
