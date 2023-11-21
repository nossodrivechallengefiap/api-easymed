package br.com.easymed.apieasymed.model.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroMedicUsuario(
		@Valid
		@NotNull
		DadosCadastroUsuario usuario,
		
		@Valid
		@NotNull
		DadosCadastroMedicamento medicamento
		) {
	
}
