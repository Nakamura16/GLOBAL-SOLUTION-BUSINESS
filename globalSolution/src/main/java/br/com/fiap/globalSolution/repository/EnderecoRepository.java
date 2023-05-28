package br.com.fiap.globalSolution.repository;

import br.com.fiap.globalSolution.models.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco,Integer>{
    
}