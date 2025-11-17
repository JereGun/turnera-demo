package dev.jgunsett.centro.mapper;

import dev.jgunsett.centro.dto.CentroDTO;
import dev.jgunsett.centro.entity.Centro;
import dev.jgunsett.direccion.entity.Pais;
import dev.jgunsett.direccion.entity.Provincia;
import org.springframework.stereotype.Component;

@Component
public class CentroMapper {
    /**
     * Convierte un DTO en una entidad Centro completa (para CREAR)
     *
     * @param dto       El DTO recibido (por ejemplo, desde el frontend)
     * @param pais      Entidad Pais ya recuperada de la BD
     * @param provincia Entidad Provincia ya recuperada de la BD
     * @return Entidad Centro lista para guardar
     */
    public Centro toEntity(CentroDTO dto, Pais pais, Provincia provincia) {

        return Centro.builder()
                .id(dto.getId())
                .nombre(dto.getNombre())
                .email(dto.getEmail())
                .telefono(dto.getTelefono())
                .activo(dto.getActivo())
                .calle(dto.getCalle())
                .numero(dto.getNumero())
                .ciudad(dto.getCiudad())
                .pais(pais)
                .provincia(provincia)
                .build();
    }

    /**
     * Convierte una entidad Centro a un DTO.
     *
     * @param entity Entidad Centro (por ejemplo, obtenida de la BD)
     * @return DTO con los datos planos
     */
    public CentroDTO toDTO(Centro entity) {
        return CentroDTO.builder()
                .id(entity.getId())
                .nombre(entity.getNombre())
                .email(entity.getEmail())
                .telefono(entity.getTelefono())
                .activo(entity.getActivo())
                .calle(entity.getCalle())
                .numero(entity.getNumero())
                .ciudad(entity.getCiudad())
                .paisId(entity.getPais() != null ? entity.getPais().getId() : null)
                .provinciaId(entity.getProvincia() != null ? entity.getProvincia().getId() : null)
                .build();
    }
}