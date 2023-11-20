package br.com.easymed.apieasymed.model.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record DadosCadastroTpUsuario(
		@Valid
		@NotNull
		DadosCadastroUsuario usuario,
		
		@NotBlank
		@Size(max = 255)
		String tipoUsuario
		) {

}
