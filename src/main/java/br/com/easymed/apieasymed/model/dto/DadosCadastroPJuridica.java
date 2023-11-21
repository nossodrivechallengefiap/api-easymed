package br.com.easymed.apieasymed.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
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
		@Pattern(regexp = "\\d{2}.\\d{3}.\\d{3}/\\d{4}-\\d{2}")
		String cnpj
		) {

}
