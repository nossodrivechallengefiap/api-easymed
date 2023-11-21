package br.com.easymed.apieasymed.model.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record DadosAtualizacaoMedicamento(
		@NotNull
		Long codigoMedicamento,
		
		@Size(max = 255)
		String nomeMedicamento) {
	
}
