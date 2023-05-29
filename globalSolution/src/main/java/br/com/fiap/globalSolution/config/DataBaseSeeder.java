package br.com.fiap.globalSolution.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.fiap.globalSolution.models.Telefone;
import br.com.fiap.globalSolution.models.Usuario;
import br.com.fiap.globalSolution.repository.TelefoneRepository;
import br.com.fiap.globalSolution.repository.UsuarioRepository;

import java.util.List;

@Configuration
public class DataBaseSeeder implements CommandLineRunner {

    @Autowired
    UsuarioRepository userRepository; 

    @Autowired
    TelefoneRepository telefoneRepository; 

    @Override
    public void run(String... args) throws Exception{
        Usuario usuario = new Usuario(1,"Carlos","carlitos", "alo");
        userRepository.saveAll(List.of(usuario));

        telefoneRepository.saveAll(List.of(
            Telefone.builder().id(1).telefone("111111111").ddd("123").ddi("555555").usuario(usuario).build(),
            Telefone.builder().id(2).telefone("222222").ddd("13").ddi("784").usuario(usuario).build()
        ));
    }
}
