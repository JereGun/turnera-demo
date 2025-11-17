package dev.jgunsett.organizacion.mapper;

import dev.jgunsett.organizacion.dto.OrganizacionDTO;
import dev.jgunsett.organizacion.entity.Organizacion;
import dev.jgunsett.direccion.entity.Pais;
import dev.jgunsett.direccion.entity.Provincia;
import org.springframework.stereotype.Component;

@Component
public class OrganizacionMapper {
    /**
    * Convierte un DTO en una entidad Organizacion completa (para CREAR)
    * @param dto El DTO recibido (por ejemplo, desde el frontend)
    * @param pais Entidad Pais ya recuperada de la BD
    * @param provincia Entidad Provincia ya recuperada de la BD
    * @return Entidad Organizacion lista para guardar
    */
    public Organizacion toEntity(OrganizacionDTO dto, Pais pais, Provincia provincia) {

        return Organizacion.builder()
                .id(dto.getId())
                .razonSocial(dto.getRazonSocial())
                .nombreFantasia(dto.getNombreFantasia())
                .email(dto.getEmail())
                .telefono(dto.getTelefono())
                .activa(dto.getActiva())
                .calle(dto.getCalle())
                .numero(dto.getNumero())
                .ciudad(dto.getCiudad())
                .pais(pais)
                .provincia(provincia)
                .build();
    }
    /**
     * Convierte una entidad Organizacion a un DTO.
     *
     * @param entity Entidad Organizacion (por ejemplo, obtenida de la BD)
     * @return DTO con los datos planos
     */
    public OrganizacionDTO toDTO(Organizacion entity) {
        return OrganizacionDTO.builder()
                .id(entity.getId())
                .razonSocial(entity.getRazonSocial())
                .nombreFantasia(entity.getNombreFantasia())
                .email(entity.getEmail())
                .telefono(entity.getTelefono())
                .activa(entity.getActiva())
                .calle(entity.getCalle())
                .numero(entity.getNumero())
                .ciudad(entity.getCiudad())
                .paisId(entity.getPais() != null ? entity.getPais().getId() : null)
                .provinciaId(entity.getProvincia() != null ? entity.getProvincia().getId() : null)
                .build();
    }
}
