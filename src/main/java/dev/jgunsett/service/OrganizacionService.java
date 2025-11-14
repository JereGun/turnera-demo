package dev.jgunsett.service;

import dev.jgunsett.dto.OrganizacionDTO;
import dev.jgunsett.entity.Organizacion;
import dev.jgunsett.entity.Pais;
import dev.jgunsett.entity.Provincia;
import dev.jgunsett.exception.ResourceNotFoundException;
import dev.jgunsett.mapper.OrganizacionMapper;
import dev.jgunsett.repository.OrganizacionRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrganizacionService {

    private final OrganizacionRepository organizacionRepository;
    private final OrganizacionMapper organizacionMapper;

    public OrganizacionDTO crearOrganizacion(OrganizacionDTO dto, Pais pais, Provincia provincia) {
        Organizacion organizacion = organizacionMapper.toEntity(dto, pais, provincia);
        organizacion = organizacionRepository.save(organizacion);
        return organizacionMapper.toDTO(organizacion);
    }

    public List<OrganizacionDTO> listarOrganizaciones(){

        return organizacionRepository.findAll()
                .stream()
                .map(organizacionMapper::toDTO)
                .toList();
    }

    public OrganizacionDTO buscarOrganizacion(Long id){
        Organizacion organizacion = organizacionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Organizacion con ID: " + id + "no ecnotrada"));
        return organizacionMapper.toDTO(organizacion);
    }

    public OrganizacionDTO actualizarOrganizacion(Long id, OrganizacionDTO dto) {
        Organizacion organizacion = organizacionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Organizacion no encontrada con ID: " + id));
        organizacion.setRazonSocial(dto.getRazonSocial());
        organizacion.setNombreFantasia(dto.getNombreFantasia());
        organizacion.setEmail(dto.getEmail());
        organizacion.setTelefono(dto.getTelefono());
        organizacion.setActiva(dto.getActiva());
        organizacion.

    }
}
