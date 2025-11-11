package dev.jgunsett.service;

import dev.jgunsett.entity.Organizacion;
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

    public Organizacion crearOrganizacion(Organizacion organizacion){
        return organizacionRepository.save(organizacion);
    }

    public List<Organizacion> listarOrganizaciones(){
        return organizacionRepository.findAll();
    }

    public Optional<Organizacion> buscarOrganizacion(Long id){
        return organizacionRepository.findById(id);
    }
}
