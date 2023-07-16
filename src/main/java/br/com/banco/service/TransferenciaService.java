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

    public List<Transferencia> getAllTransferencesByCountId(Long id){
        Conta conta = new Conta();
        conta.setIdConta(id);
        return transferenciaRepository.findByConta(conta);
    }

    public List<Transferencia> getTransferencesBetweenDates(PeriodoDto peridoDto){
        LocalDateTime dataInicio = peridoDto.getDataInicio();
        LocalDateTime dataFim = peridoDto.getDataFim();
        return transferenciaRepository.findByDataTransferenciaBetween(dataInicio, dataFim);
    }

    public List<Transferencia> getTransferencesByName(PeriodoDto periodoDto){
        String nomeOperadorTransacao = periodoDto.getNomeOperadorTransacao();
        return transferenciaRepository.findByNomeOperadorTransacao(nomeOperadorTransacao);
    }
}
