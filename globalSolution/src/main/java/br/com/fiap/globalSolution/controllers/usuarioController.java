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
import br.com.fiap.globalSolution.models.Usuario;
import br.com.fiap.globalSolution.repository.UsuarioRepository;
import jakarta.validation.Valid;

import java.util.List;

@RestController
public class UsuarioController {

    Logger log = LoggerFactory.getLogger(Usuario.class);

    @Autowired
    UsuarioRepository repository; 
    
    @GetMapping("/api/usuarios")
    public List<Usuario> index(){
        return repository.findAll();
    }

    @GetMapping("/api/usuarios/{id}")
    public ResponseEntity<Usuario> show(@PathVariable int id){
        log.info("buscando usuario com id:" + id);
        var usuarioEncontrado = getUsuario(id);
        return ResponseEntity.ok(usuarioEncontrado);
    }

    @PostMapping("/api/usuarios")
    public ResponseEntity<Usuario> create(@RequestBody @Valid Usuario usuario){
        log.info("cadastrando usuario: " + usuario);

        repository.save(usuario);

        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }

    @PutMapping("/api/usuarios/{id}")
    public ResponseEntity<Usuario> update(@PathVariable Integer id, @RequestBody @Valid Usuario usuario){
        log.info("atualizando usuario com id:" + id);
        getUsuario(id);

        usuario.setId(id);
        repository.save(usuario);
        return ResponseEntity.ok(usuario);
    }

    @DeleteMapping("/api/usuarios/{id}")
        public ResponseEntity<Usuario> destroy(@PathVariable Integer id){
            log.info("apagando usuario com id:" + id);
            var usuario = getUsuario(id);
            repository.delete(usuario);
            return ResponseEntity.noContent().build();
        }

    
    private Usuario getUsuario(int id) {
        return repository.findById(id).orElseThrow(() -> new RestNotFoundException("despesa não encontrada"));
    }
}
