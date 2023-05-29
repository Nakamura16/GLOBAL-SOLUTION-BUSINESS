package br.com.fiap.globalSolution.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.fiap.globalSolution.models.Usuario;
import br.com.fiap.globalSolution.repository.UsuarioRepository;

import java.util.List;

@Configuration
public class DataBaseSeeder implements CommandLineRunner {

    @Autowired
    UsuarioRepository userRepository; 

    @Override
    public void run(String... args) throws Exception{
        userRepository.saveAll(List.of(
            new Usuario(1,"carlos","Carlis","vida"),
            new Usuario(2,"carlos","Carlis","vida"),
            new Usuario(3,"carlos","Carlis","vida")
        ));
    }
    
}
