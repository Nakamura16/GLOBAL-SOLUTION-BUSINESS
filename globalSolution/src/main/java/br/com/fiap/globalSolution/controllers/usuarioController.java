package br.com.fiap.globalSolution.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.globalSolution.exception.RestNotFoundException;
import br.com.fiap.globalSolution.models.Usuario;
import br.com.fiap.globalSolution.repository.UsuarioRepository;
import jakarta.validation.Valid;

@RestController
public class UsuarioController {

    Logger log = LoggerFactory.getLogger(Usuario.class);

    @Autowired
    UsuarioRepository repository; 

    // @Autowired
    // AuthenticationManager manager;

    // @Autowired
    // PasswordEncoder encoder;
    
    @GetMapping("/api/usuarios")
    public Page<Usuario> index(@PageableDefault(size= 100,sort = {"nome"}) Pageable pageable){
        return repository.findAll(pageable);
    }

    @GetMapping("/api/usuarios/{id}")
    public ResponseEntity<Usuario> show(@PathVariable int id){
        log.info("buscando usuario com id:" + id);
        var usuarioEncontrado = getUsuario(id);
        return ResponseEntity.ok(usuarioEncontrado);
    }

    // @PostMapping("/api/usuarios")
    // public ResponseEntity<Usuario> registrar(@RequestBody @Valid Usuario usuario){
    //     usuario.setSenha(encoder.encode(usuario.getSenha()));
    //     log.info("cadastrando usuario: " + usuario);

    //     repository.save(usuario);

    //     return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    // }
    
    // @PostMapping("/api/login")
    // public ResponseEntity<Object> login(@RequestBody @Valid Credencial credencial){
    //     manager.authenticate(credencial.toAuthentication());
    //     return ResponseEntity.ok().build();
    // }

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
        return repository.findById(id).orElseThrow(() -> new RestNotFoundException("Usuario não encontrada"));
    }
}
