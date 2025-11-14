package dev.jgunsett.mapper;

import dev.jgunsett.dto.OrganizacionDTO;
import dev.jgunsett.entity.Direccion;
import dev.jgunsett.entity.Organizacion;
import dev.jgunsett.entity.Pais;
import dev.jgunsett.entity.Provincia;
import org.springframework.stereotype.Component;

@Component
public class OrganizacionMapper {
    /**
    * Convierte un DTO en una entidad Organizacion completa
    * @param dto El DTO recibido (por ejemplo, desde el frontend)
    * @param pais Entidad Pais ya recuperada de la BD
    * @param provincia Entidad Provincia ya recuperada de la BD
    * @return Entidad Organizacion lista para guardar
    */
    public Organizacion toEntity(OrganizacionDTO dto, Pais pais, Provincia provincia) {
        Direccion direccion = Direccion.builder()
                .calle(dto.getDireccionCalle())
                .numero(dto.getDireccionNumero())
                .ciudad(dto.getDireccionCiudad())
                .provincia(provincia)
                .pais(pais)
                .build();

        return Organizacion.builder()
                .id(dto.getId())
                .razonSocial(dto.getRazonSocial())
                .nombreFantasia(dto.getNombreFantasia())
                .email(dto.getEmail())
                .telefono(dto.getTelefono())
                .direccion(direccion)
                .activa(dto.getActiva())
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
                .direccionCalle(entity.getDireccion().getCalle())
                .direccionNumero(entity.getDireccion().getNumero())
                .direccionCiudad(entity.getDireccion().getCiudad())
                .provinciaId(entity.getDireccion().getId())
                .paisId(entity.getDireccion().getId())
                .build();
    }
}
