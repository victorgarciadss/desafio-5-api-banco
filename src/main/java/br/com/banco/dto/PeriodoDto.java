package br.com.banco.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PeriodoDto {

    private String dataInicio;
    private String dataFim;
    private String nomeOperadorTransacao;

    public LocalDateTime getDataInicio(){
        return LocalDate.parse(dataInicio, DateTimeFormatter.ofPattern("dd/MM/yyyy")).atStartOfDay();
    }

    public LocalDateTime getDataFim(){
        return LocalDate.parse(dataFim, DateTimeFormatter.ofPattern("dd/MM/yyyy"))
            .atStartOfDay().plusDays(1).minusSeconds(1);
    }
}
