package br.com.easymed.apieasymed.model.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record DadosAtualizacaoPFisica(
		@NotNull
		Long codigoUsuario,
		
		@Size(max = 255)
		String senha,
		
		@Size(max = 255)
		String email,
		
		@Size(max = 255)
		String nome,
		
		@Pattern(regexp = "\\d{3}.\\d{3}.\\d{3}-\\d{2}")
		String cpf) {
}
