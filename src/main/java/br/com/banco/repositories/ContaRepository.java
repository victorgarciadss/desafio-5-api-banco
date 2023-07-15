package br.com.banco.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.banco.entity.Conta;

public interface ContaRepository extends JpaRepository<Conta, Long> {
    
}
