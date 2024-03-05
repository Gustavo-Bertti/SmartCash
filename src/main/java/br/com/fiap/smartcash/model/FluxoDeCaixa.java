package br.com.fiap.smartcash.model;
import java.util.Random;

public record FluxoDeCaixa(Long id,String tipo, double valor, String descricao, String data) {

    public FluxoDeCaixa(Long id,String tipo, double valor, String descricao, String data){
        var key = (id != null) ? id : Math.abs( new Random(10).nextLong());
        this.id = key;
        this.tipo = tipo;
        this.valor = valor;
        this.descricao = descricao;
        this.data = data;
    }
    
}  
