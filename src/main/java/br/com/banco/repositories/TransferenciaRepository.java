package br.com.banco.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.banco.entity.Conta;
import br.com.banco.entity.Transferencia;

@Repository
public interface TransferenciaRepository extends JpaRepository<Transferencia, Long> {
    List<Transferencia> findByConta(Conta conta);
    List<Transferencia> findByDataTransferenciaBetween(LocalDateTime dataInicio, LocalDateTime dataFim);
    List<Transferencia> findByNomeOperadorTransacao(String nome);

    @Query(nativeQuery = true, value = "SELECT * FROM transferencia WHERE data_transferencia BETWEEN :dataInicio AND :dataFim AND nome_operador_transacao = :nome")
    List<Transferencia> findByOperatorNameAndTransferencesBetween(
        @Param("nome") String nome, @Param("dataInicio") LocalDateTime dataInicio, @Param("dataFim") LocalDateTime dataFim)
    ;
}
