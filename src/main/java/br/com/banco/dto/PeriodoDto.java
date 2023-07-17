package br.com.banco.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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

    public LocalDateTime getDataInicio() {
        LocalDate date = LocalDate.parse(dataInicio, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        return date.atStartOfDay();
    }

    public LocalDateTime getDataFim() {
        LocalDate date = LocalDate.parse(dataFim, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        return date.atTime(LocalTime.MAX);
    }
}
