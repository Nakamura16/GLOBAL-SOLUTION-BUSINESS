package br.com.fiap.globalSolution.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.globalSolution.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,Integer>{
    
}
