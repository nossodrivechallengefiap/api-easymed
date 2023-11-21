package br.com.easymed.apieasymed.model.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record DadosAtualizacaoMedSolido(
		@NotNull
		Long codigoMedicamento,
		
		@Size(max = 255)
		String nomeMedicamento,
		
		BigDecimal quantidade) {

}
