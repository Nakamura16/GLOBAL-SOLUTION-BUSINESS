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

import br.com.fiap.globalSolution.exception.RestNotFoundException;
import br.com.fiap.globalSolution.models.Telefone;
import br.com.fiap.globalSolution.repository.TelefoneRepository;
import jakarta.validation.Valid;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TelefoneController {

    Logger log = LoggerFactory.getLogger(Telefone.class);

//Injeção de dependencia do telefone
 @Autowired
 TelefoneRepository repository;
    
    @GetMapping("/api/telefones")
    public List<Telefone> index(){
         return repository.findAll();
    }

    @GetMapping("/api/telefones/{id}")
    public ResponseEntity<Telefone> show(@PathVariable Integer id){
        log.info("buscando telefone com id:" + id);
        var  telefoneEncontrado = getTelefone(id);

        return ResponseEntity.ok(telefoneEncontrado);
    }

    @PostMapping("/api/telefones")
    public ResponseEntity<Telefone> create(@RequestBody @Valid Telefone telefone){
        log.info("cadastrando telefone: " + telefone);
        repository.save(telefone);
        return ResponseEntity.status(HttpStatus.CREATED).body(telefone);
    }

    @PutMapping("/api/telefones/{id}")
    public ResponseEntity<Telefone> update(@PathVariable Integer id, @Valid @RequestBody Telefone telefone){
        log.info("atualizando telefone com id:" + id);

        telefone.setId(id);
        getTelefone(id);
        repository.save(telefone);

        return ResponseEntity.status(HttpStatus.OK).body(telefone);
    }

    @DeleteMapping("/api/telefones/{id}")
        public ResponseEntity<Telefone> destroy(@PathVariable Integer id){
            log.info("apagando telefone com id:" + id);
            var telefone = getTelefone(id);
            repository.delete(telefone);

            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        private Telefone getTelefone(Integer id) {
            return repository.findById(id).orElseThrow(() -> new RestNotFoundException("Telefone não encontrado"));
        }

}