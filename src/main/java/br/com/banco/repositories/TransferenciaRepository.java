package br.com.banco.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.banco.entity.Conta;
import br.com.banco.entity.Transferencia;

@Repository
public interface TransferenciaRepository extends JpaRepository<Transferencia, Long> {
    List<Transferencia> findByConta(Conta conta);
    List<Transferencia> findByDataTransferenciaBetween(LocalDateTime dataInicio, LocalDateTime dataFim);
    List<Transferencia> findByNomeOperadorTransacao(String nome);
}
