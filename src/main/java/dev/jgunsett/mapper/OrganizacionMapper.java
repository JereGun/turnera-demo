package dev.jgunsett.mapper;

import dev.jgunsett.dto.OrganizacionDTO;
import dev.jgunsett.entity.Organizacion;
import org.springframework.stereotype.Component;

@Component
public class OrganizacionMapper {
    public Organizacion toEntity(OrganizacionDTO dto) {
        Organizacion organizacion = new Organizacion();
        organizacion.setId(dto.getId());
        organizacion.setRazonSocial(dto.getRazonSocial());
        organizacion.setNombreFantasia(dto.getNombreFantasia());
        organizacion.setEmail(dto.getEmail());
        organizacion.setTelefono(dto.getTelefono());
        organizacion.setDireccion(dto.getDireccion());

        return organizacion;
    }
    public OrganizacionDTO toDTO(Organizacion organizacion) {
        OrganizacionDTO dto = new OrganizacionDTO();
        dto.setId(organizacion.getId());

        return dto;
    }
}
