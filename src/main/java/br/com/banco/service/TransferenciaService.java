package br.com.banco.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
