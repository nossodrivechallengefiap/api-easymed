package br.com.easymed.apieasymed.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record DadosCadastroPJuridica(
		@NotBlank
		@Size(max = 255)
		String senha,
		
		@NotBlank
		@Size(max = 255)
		String email,
		
		@NotBlank
		@Size(max = 255)
		String razaoSocial,
		
		@NotBlank
		@Size(max = 18)
		String cnpj
		) {

}
