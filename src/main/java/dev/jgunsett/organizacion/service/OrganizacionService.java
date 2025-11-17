package dev.jgunsett.organizacion.service;

import dev.jgunsett.organizacion.dto.OrganizacionDTO;
import dev.jgunsett.organizacion.entity.Organizacion;
import dev.jgunsett.direccion.entity.Pais;
import dev.jgunsett.direccion.entity.Provincia;
import dev.jgunsett.exception.ResourceNotFoundException;
import dev.jgunsett.organizacion.mapper.OrganizacionMapper;
import dev.jgunsett.organizacion.repository.OrganizacionRepository;
import dev.jgunsett.direccion.repository.PaisRepository;
import dev.jgunsett.direccion.repository.ProvinciaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrganizacionService {

    private final OrganizacionRepository organizacionRepository;
    private final OrganizacionMapper organizacionMapper;
    private final PaisRepository paisRepository;
    private final ProvinciaRepository provinciaRepository;

    public OrganizacionDTO crearOrganizacion(OrganizacionDTO dto, Long paisId, Long provinciaId) {
        Pais pais = paisRepository.findById(paisId)
                .orElseThrow(() -> new ResourceNotFoundException("Pais no encontrado con ID: " + paisId));

        Provincia provincia = provinciaRepository.findById(provinciaId)
                .orElseThrow(() -> new ResourceNotFoundException("Provincia no encontrado con ID: " + provinciaId));

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

    public OrganizacionDTO actualizarOrganizacion(Long id, OrganizacionDTO dto, Long paisId, Long provinciaId) {
        //Buscamos si la Organizacion existe
        Organizacion organizacion = organizacionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Organizacion no encontrada con ID: " + id));

        //Actualización de campos basicos
        organizacion.setRazonSocial(dto.getRazonSocial());
        organizacion.setNombreFantasia(dto.getNombreFantasia());
        organizacion.setEmail(dto.getEmail());
        organizacion.setTelefono(dto.getTelefono());
        organizacion.setActiva(dto.getActiva());
        organizacion.setCalle(dto.getCalle());
        organizacion.setNumero(dto.getNumero());
        organizacion.setCiudad(dto.getCiudad());

        //Buscar y actualizar pais y provincia
        Pais pais = paisRepository.findById(paisId)
                .orElseThrow(() -> new ResourceNotFoundException("Pais no encontrado con ID: " + paisId));

        Provincia provincia = provinciaRepository.findById(provinciaId)
                .orElseThrow(() -> new ResourceNotFoundException("Provincia no encontrado con ID: " + provinciaId));

        organizacion.setPais(pais);
        organizacion.setProvincia(provincia);

        //Guardar cambios
        organizacion = organizacionRepository.save(organizacion);

        //Devolver DTO actualizado
        return organizacionMapper.toDTO(organizacion);
    }

    public void eliminar(Long id) {
        if (!organizacionRepository.existsById(id)){
            throw new ResourceNotFoundException("No existe la organización con el ID: " + id);
        }
        organizacionRepository.deleteById(id);
    }
}
