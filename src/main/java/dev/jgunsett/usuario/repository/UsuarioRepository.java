package dev.jgunsett.usuario.repository;

import dev.jgunsett.usuario.entity.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/* Una Intrerfaz que extiende JpaRepository o CrudRepository.
Y esto es para que Spring genere automaticamente la implementacion en tiempo real*/

@Repository //Indica que es un componente de acceso a datos. Spring lo reconoce como un bean que puede lanzar excepciones específicas de BD.
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);
    boolean existsByEmail(String email);
}
