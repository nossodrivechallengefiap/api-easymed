package br.com.easymed.apieasymed.model.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroMedIntervalo(
		@NotNull
		@Valid
		DadosCadastroMedicamento medicamento,
		
		@NotNull
		@Valid
		DadosCadastroUsuario usuario,
		
		@NotNull
		LocalDate dataInicio,
		
		LocalDate dataFinal,
		
		@NotNull
		BigDecimal intervaloHoras,
		
		@NotNull
		Boolean medicamentoAtivo) {

}
