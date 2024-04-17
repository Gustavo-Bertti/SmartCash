package br.com.fiap.smartcash.model;

import java.time.LocalDate;

import br.com.fiap.smartcash.validation.Tipo;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class FluxoDeCaixa{

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Tipo
    private String tipo;

    @Positive
    private double valor;

    @NotBlank @Size(min = 3, max = 250)
    private String descricao;
    
    private LocalDate dataInclusao;
    
}  
