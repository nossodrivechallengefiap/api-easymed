package br.com.easymed.apieasymed.model.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record DadosAtualizacaoPJuridica(
		@NotNull
		Long codigoUsuario,
		
		@Size(max = 255)
		String senha,
		
		@Size(max = 255)
		String email,
		
		@Size(max = 255)
		String razaoSocial,
		
		@Pattern(regexp = "\\d{2}.\\d{3}.\\d{3}/\\d{4}-\\d{2}")
		String cnpj) {

}
