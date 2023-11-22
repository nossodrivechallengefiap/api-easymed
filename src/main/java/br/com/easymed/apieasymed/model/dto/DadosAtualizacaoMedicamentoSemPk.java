package br.com.easymed.apieasymed.model.dto;

import jakarta.validation.constraints.Size;

public record DadosAtualizacaoMedicamentoSemPk(
		@Size(max = 255)
		String nomeMedicamento) {
	
}
