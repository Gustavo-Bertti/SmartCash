package br.com.fiap.smartcash.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.smartcash.model.FluxoDeCaixa;


public interface FluxoDeCaixaRepository extends JpaRepository<FluxoDeCaixa, Long> {

    
    
} 
