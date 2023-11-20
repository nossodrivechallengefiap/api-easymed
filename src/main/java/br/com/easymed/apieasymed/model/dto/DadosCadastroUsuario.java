package br.com.easymed.apieasymed.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record DadosCadastroUsuario(
		@NotBlank
		@Size(max = 255)
		String senha, 
		
		@NotBlank
		@Size(max = 255)
		String email
		) {

}
