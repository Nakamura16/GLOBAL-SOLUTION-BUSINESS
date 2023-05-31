package br.com.fiap.globalSolution.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.globalSolution.models.Hortalica;

public interface HortalicaRepository extends JpaRepository<Hortalica,Integer>{

    Page<Hortalica> findByNomeContaining(String nome,Pageable pageable);
    
}
