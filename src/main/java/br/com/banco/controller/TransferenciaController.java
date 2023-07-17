package br.com.banco.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.banco.dto.PeriodoDto;
import br.com.banco.entity.Transferencia;
import br.com.banco.service.TransferenciaService;

@RestController
@RequestMapping("/transferencias")
public class TransferenciaController {
    
    @Autowired
    private TransferenciaService transferenciaService;

    @GetMapping
    public List<Transferencia> gettAllTransferences(){
        return transferenciaService.getAllTransferences();
    }

    @GetMapping("/conta/{id}")
    public ResponseEntity<List<Transferencia>> getAllTransferencesByCountId(@PathVariable Long id){
        List<Transferencia> transferencias = transferenciaService.getAllTransferencesByCountId(id);
        return ResponseEntity.ok(transferencias);
    }

    @PostMapping("/nome")
    public ResponseEntity<List<Transferencia>> getAllTransferencesBetweenDates(@RequestBody PeriodoDto periodoDto){
        List<Transferencia> transferencias = transferenciaService.getTransferencesByOperatorName(periodoDto);
        return ResponseEntity.ok(transferencias);
    }

    @PostMapping("/periodo")
    public ResponseEntity<List<Transferencia>> getAllTransferencesWithFilters(@RequestBody PeriodoDto periodoDto){
        List<Transferencia> transferencias = transferenciaService.getTransferencesWithDatesFilter(periodoDto);
        return ResponseEntity.status(200).body(transferencias);
    }
}
