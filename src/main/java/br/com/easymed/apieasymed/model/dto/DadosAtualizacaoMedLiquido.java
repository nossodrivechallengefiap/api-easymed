package br.com.easymed.apieasymed.model.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record DadosAtualizacaoMedLiquido(
		@NotNull
		Long codigoMedicamento,
		
		@Size(max = 255)
		String nomeMedicamento,
		
		BigDecimal volume) {
}
