package br.com.banco.service;


import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.banco.dto.PeriodoDto;
import br.com.banco.entity.Conta;
import br.com.banco.entity.Transferencia;
import br.com.banco.repositories.TransferenciaRepository;

@Service
public class TransferenciaService {
    
    @Autowired
    private TransferenciaRepository transferenciaRepository;

    public List<Transferencia> getAllTransferences(){
        return transferenciaRepository.findAll();
    }

    public Double getTotalBalance(){
        return transferenciaRepository.getTotalBalance();
    }

    public Double getBalanceaByTime(PeriodoDto periodoDto){
        LocalDateTime dataInicio = periodoDto.getDataInicio();
        LocalDateTime dataFim = periodoDto.getDataFim();
        return transferenciaRepository.getBalanceByTime(dataInicio, dataFim);
    }

    public List<Transferencia> getAllTransferencesByCountId(Long id){
        Conta conta = new Conta();
        conta.setIdConta(id);
        return transferenciaRepository.findByConta(conta);
    }

    public List<Transferencia> getTransferencesByOperatorName(PeriodoDto peridoDto){
        String nomeOperadorTransferencia = peridoDto.getNomeOperadorTransacao();

        return transferenciaRepository.findByNomeOperadorTransacao(nomeOperadorTransferencia); 
    }

    public List<Transferencia> getTransferencesWithDatesFilter(PeriodoDto periodoDto){
        LocalDateTime dataInicio = periodoDto.getDataInicio();
        LocalDateTime dataFim = periodoDto.getDataFim();
        String nomeOperadorTransferencia = periodoDto.getNomeOperadorTransacao();

        if(dataInicio != null && dataFim != null && nomeOperadorTransferencia != ""){
            return transferenciaRepository
            .findByOperatorNameAndTransferencesBetween(nomeOperadorTransferencia, dataInicio, dataFim);
        }

        return transferenciaRepository.findByDataTransferenciaBetween(dataInicio, dataFim);
        
    }

}
