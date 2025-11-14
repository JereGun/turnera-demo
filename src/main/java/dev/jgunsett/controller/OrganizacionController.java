package dev.jgunsett.controller;

import dev.jgunsett.dto.OrganizacionDTO;
import dev.jgunsett.service.OrganizacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
