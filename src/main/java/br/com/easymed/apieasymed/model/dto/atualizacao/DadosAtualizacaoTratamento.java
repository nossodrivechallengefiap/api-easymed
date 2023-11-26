package br.com.easymed.apieasymed.model.dto.atualizacao;

import java.time.LocalDate;

import jakarta.validation.Valid;

public record DadosAtualizacaoTratamento(
		LocalDate inicio,
		
		LocalDate fim,
		
		Long intervalo,
		
		@Valid
		DadosAtualizacaoMedico medico,
		
		@Valid
		DadosAtualizacaoPaciente paciente,
		
		@Valid
		DadosAtualizacaoMedicamento medicamento) {

}
