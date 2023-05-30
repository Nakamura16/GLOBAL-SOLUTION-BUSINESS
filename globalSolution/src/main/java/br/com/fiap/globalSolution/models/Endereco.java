package br.com.fiap.globalSolution.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Endereco {
    
    @ManyToOne
    private Terreno terreno;

    @Id
    private Integer idTerreno = terreno.getId();

    @NotBlank @Size(max = 100)
    private String logradouro;

    @NotBlank @Size(max = 10)
    private String numero;

    @NotBlank @Size(max = 2)
    private String regiao;

    public Endereco (Terreno terreno, String logradouro, String numero, String regiao){
        this.terreno = terreno;
        this.logradouro = logradouro;
        this.numero = numero;
        this.regiao = regiao;
    }
}