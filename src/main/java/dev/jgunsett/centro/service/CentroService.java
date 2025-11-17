package dev.jgunsett.centro.service;

import dev.jgunsett.centro.dto.CentroDTO;
import dev.jgunsett.centro.entity.Centro;
import dev.jgunsett.direccion.entity.Pais;
import dev.jgunsett.direccion.entity.Provincia;
import dev.jgunsett.exception.ResourceNotFoundException;
import dev.jgunsett.centro.mapper.CentroMapper;
import dev.jgunsett.centro.repository.CentroRepository;
import dev.jgunsett.direccion.repository.PaisRepository;
import dev.jgunsett.direccion.repository.ProvinciaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CentroService {

    private final CentroRepository centroRepository;
    private final CentroMapper centroMapper;
    private final PaisRepository paisRepository;
    private final ProvinciaRepository provinciaRepository;

    public CentroDTO crear(CentroDTO dto, Long paisId, Long provinciaId){
        Pais pais = paisRepository.findById(paisId)
                .orElseThrow(() -> new ResourceNotFoundException("Pais no encontrado con el ID: " + paisId));

        Provincia provincia = provinciaRepository.findById(provinciaId)
                .orElseThrow(() -> new ResourceNotFoundException("Provincia no encontrada con ID: " + provinciaId));

        Centro centro = centroMapper.toEntity(dto, pais, provincia);
        centro = centroRepository.save(centro);
        return centroMapper.toDTO(centro);
    }

    public List<CentroDTO> listar() {
        return centroRepository.findAll()
                .stream()
                .map(centroMapper::toDTO)
                .toList();
    }

    public CentroDTO buscarPorId(Long id){
        Centro centro = centroRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontró Centro con el ID: " + id));
        return centroMapper.toDTO(centro);
    }

    public CentroDTO actualizar(Long id, CentroDTO dto, Long paisId, Long provinciaId){
        Centro centro = centroRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontró Centro con el ID: " + id));

        centro.setNombre(dto.getNombre());
        centro.setTelefono(dto.getTelefono());
        centro.setEmail(dto.getEmail());
        centro.setCalle(dto.getCalle());
        centro.setNumero(dto.getNumero());
        centro.setCiudad(dto.getCiudad());

        Pais pais = paisRepository.findById(paisId)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontró Pais con el ID: " + paisId));

        Provincia provincia = provinciaRepository.findById(provinciaId)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontró Provincia con el ID: " + provinciaId));

        centro.setPais(pais);
        centro.setProvincia(provincia);

        centro = centroRepository.save(centro);

        return centroMapper.toDTO(centro);
    }

    public void eliminar(Long id){
        if (!centroRepository.existsById(id)){
            throw new ResourceNotFoundException("No existe el Centro con el ID: " + id);
        }
        centroRepository.deleteById(id);
    }
}
