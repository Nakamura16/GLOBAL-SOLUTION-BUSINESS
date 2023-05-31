package br.com.fiap.globalSolution.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.globalSolution.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,Integer>{

    Optional<Usuario> findByNome(String nome);

}
