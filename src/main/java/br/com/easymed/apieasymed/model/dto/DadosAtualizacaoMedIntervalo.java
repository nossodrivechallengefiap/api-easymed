package br.com.easymed.apieasymed.model.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoMedIntervalo(
		@NotNull
		Long id,
		
		@Valid
		DadosAtualizacaoMedicamentoSemPk medicamento,
		
		@Valid
		DadosAtualizacaoUsuarioSemPk usuario,
		
		LocalDate dataInicio,
		
		LocalDate dataFinal,
		
		BigDecimal intervaloHoras,
		
		Boolean medicamentoAtivo) {

}
