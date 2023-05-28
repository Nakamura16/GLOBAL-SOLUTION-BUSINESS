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
import br.com.fiap.globalSolution.models.Terreno;
import br.com.fiap.globalSolution.repository.TerrenoRepository;
import jakarta.validation.Valid;

import java.util.List;

@RestController
public class TerrenoController {

    Logger log = LoggerFactory.getLogger(Terreno.class);

//Injeção de dependencia do telefone
 @Autowired
 TerrenoRepository repository;
    
    @GetMapping("/api/terrenos")
    public List<Terreno> index(){
        return repository.findAll();
    }

    @GetMapping("/api/terrenos/{id}")
    public ResponseEntity<Terreno> show(@PathVariable Integer id){
        log.info("buscando terrenos com id:" + id);
        var  terrenoEncontrado = getTerreno(id);

        return ResponseEntity.ok(terrenoEncontrado);
    }

    @PostMapping("/api/terrenos")
    public ResponseEntity<Terreno> create(@RequestBody @Valid Terreno terreno){
        log.info("cadastrando terrenos: " + terreno);
        repository.save(terreno);
        return ResponseEntity.status(HttpStatus.CREATED).body(terreno);
    }

    @PutMapping("/api/terrenos/{id}")
    public ResponseEntity<Terreno> update(@PathVariable Integer id, @Valid @RequestBody Terreno terreno){
        log.info("atualizando terreno com id:" + id);
        getTerreno(id);
        terreno.setId(id);
        repository.save(terreno);

        return ResponseEntity.status(HttpStatus.OK).body(terreno);
    }

    @DeleteMapping("/api/terrenos/{id}")
        public ResponseEntity<Terreno> destroy(@PathVariable Integer id){
            log.info("apagando terreno com id:" + id);
            var terreno = getTerreno(id);
            repository.delete(terreno);

            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        private Terreno getTerreno(Integer id) {
            return repository.findById(id).orElseThrow(() -> new RestNotFoundException("Terreno não encontrado"));
        }

}