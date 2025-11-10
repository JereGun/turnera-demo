package dev.jgunsett.repository;
import dev.jgunsett.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long>{

	//Buscar Paciente por mail
	Optional<Paciente> findByEmail(String email);
	
	Optional<Paciente> findByDocumento(Integer documento);
}
