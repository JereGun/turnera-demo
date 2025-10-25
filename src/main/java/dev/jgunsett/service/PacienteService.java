package dev.jgunsett.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import dev.jgunsett.entity.Paciente;
import dev.jgunsett.repository.PacienteRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor //Genera COnstructor con repositorios finales
public class PacienteService {

	private final PacienteRepository pacienteRepository;
	
	//Crear Paciente
	public Paciente crearPaciente(Paciente paciente) {
		return pacienteRepository.save(paciente);
	}
	
	public List<Paciente> ListarPacientes(){
		return pacienteRepository.findAll();
	}
	
	public Optional<Paciente> obtenerPaciente(Long id) {
		return pacienteRepository.findById(id);
	}
}
