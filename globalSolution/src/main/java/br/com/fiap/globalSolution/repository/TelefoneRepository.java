package br.com.fiap.globalSolution.repository;

import br.com.fiap.globalSolution.models.Telefone;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TelefoneRepository extends JpaRepository<Telefone,Integer>{
    
}