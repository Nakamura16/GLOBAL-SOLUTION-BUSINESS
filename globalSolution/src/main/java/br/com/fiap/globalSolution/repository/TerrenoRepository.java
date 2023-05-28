package br.com.fiap.globalSolution.repository;

import br.com.fiap.globalSolution.models.Terreno;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TerrenoRepository extends JpaRepository<Terreno,Integer>{
    
}