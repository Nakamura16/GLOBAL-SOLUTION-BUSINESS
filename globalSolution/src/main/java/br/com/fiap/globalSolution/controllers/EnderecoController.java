package br.com.fiap.globalSolution.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import br.com.fiap.globalSolution.exception.RestNotFoundException;
import br.com.fiap.globalSolution.models.Endereco;
import br.com.fiap.globalSolution.repository.EnderecoRepository;
import jakarta.validation.Valid;

@RestController
public class EnderecoController {

 Logger log = LoggerFactory.getLogger(Endereco.class);

//Injeção de dependencia
 @Autowired
 EnderecoRepository repository;
    
    @GetMapping("/api/enderecos")
    public List<Endereco> index(){
        return repository.findAll();
    }

    @GetMapping("/api/enderecos/{id}")
    public ResponseEntity<Endereco> show(@PathVariable Integer id){
        log.info("buscando usuario com id:" + id);
        var enderecoEncontrado = getEndereco(id);

        return ResponseEntity.ok(enderecoEncontrado);
    }

    @PostMapping("/api/enderecos")
    public ResponseEntity<Endereco> create(@RequestBody @Valid Endereco endereco){
        log.info("cadastrando endereco: " + endereco);
        repository.save(endereco);
        return ResponseEntity.status(HttpStatus.CREATED).body(endereco);
    }

    @PutMapping("/api/enderecos/{id}")
    public ResponseEntity<Endereco> update(@PathVariable Integer id, @Valid @RequestBody Endereco endereco){
        log.info("atualizando endereco com id:" + id);

        endereco.setIdTerreno(endereco.getTerreno().getId());
        getEndereco(id);
        repository.save(endereco);

        return ResponseEntity.status(HttpStatus.OK).body(endereco);
    }

    @DeleteMapping("/api/enderecos/{id}")
        public ResponseEntity<Endereco> destroy(@PathVariable Integer id){
            log.info("apagando usuario com id:" + id);
            var endereco = getEndereco(id);
            repository.delete(endereco);

            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        private Endereco getEndereco(Integer id) {
            return repository.findById(id).orElseThrow(() -> new RestNotFoundException("Endereco não encontrado"));
        }
}