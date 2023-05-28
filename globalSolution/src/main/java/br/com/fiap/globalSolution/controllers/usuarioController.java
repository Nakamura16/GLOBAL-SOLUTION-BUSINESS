package br.com.fiap.globalSolution.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.globalSolution.models.Usuario;

import java.util.ArrayList;
import java.util.List;

@RestController
public class usuarioController {

    Logger log = LoggerFactory.getLogger(Usuario.class);

    List<Usuario> usuarios = new ArrayList<>();
    
    @GetMapping("/api/usuarios")
    public List<Usuario> index(){
        return usuarios;
    }

    @GetMapping("/api/usuarios/{id}")
    public ResponseEntity<Usuario> show(@PathVariable int id){
        log.info("buscando usuario com id:" + id);
        var usuarioEncontrado = usuarios.stream().filter(d -> d.getId().equals(id)).findFirst();

        if (usuarioEncontrado.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return ResponseEntity.ok(usuarioEncontrado.get());
    }

    @PostMapping("/api/usuarios")
    public ResponseEntity<Usuario> create(@RequestBody Usuario usuario){
        log.info("cadastrando usuario: " + usuario);
        usuario.setId(usuarios.size() + 1);
        usuarios.add(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }

    @PutMapping("/api/usuarios/{id}")
    public ResponseEntity<Usuario> update(@PathVariable Integer id, @RequestBody Usuario usuario){
        log.info("atualizando usuario com id:" + id);
        var usuarioEncontrado = usuarios.stream().filter(d -> d.getId().equals(id)).findFirst();

        if (usuarioEncontrado.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        usuarios.remove(usuarioEncontrado.get());
        usuario.setId(id);
        usuarios.add(usuario);

        return ResponseEntity.status(HttpStatus.OK).body(usuario);
    }

    @DeleteMapping("/api/usuarios/{id}")
        public ResponseEntity<Usuario> destroy(@PathVariable Integer id){
            log.info("apagando usuario com id:" + id);
            var usuarioEncontrado = usuarios.stream().filter(d -> d.getId().equals(id)).findFirst();

            if (usuarioEncontrado.isEmpty())
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

            usuarios.remove(usuarioEncontrado.get());

            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
}
