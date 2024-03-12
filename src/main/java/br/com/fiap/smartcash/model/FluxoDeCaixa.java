package br.com.fiap.smartcash.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class FluxoDeCaixa{

    @Id
    private Long id;
    private String tipo;
    private double valor;
    private String descricao;
    private String data;
    
}  
