package br.com.senai.crudmysqlspring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senai.crudmysqlspring.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> { 
    Optional<Usuario> findByEmail(String email);
    void deleteByEmail(String email);
}
    
