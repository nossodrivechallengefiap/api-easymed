package br.com.easymed.apieasymed.model.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record DadosCadastroMedLiquido(
		@NotBlank
		@Size(max = 255)
		String nomeMedicamento,
		
		@NotNull
		BigDecimal volume
		) {

}
