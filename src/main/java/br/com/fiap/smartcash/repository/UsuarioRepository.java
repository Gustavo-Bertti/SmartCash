package br.com.fiap.smartcash.repository;


import org.springframework.data.jpa.repository.JpaRepository;


import br.com.fiap.smartcash.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    
} 