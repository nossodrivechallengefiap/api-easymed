package br.com.easymed.apieasymed.model.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record DadosAtualizacaoUsuario(
		@NotNull
		Long codigoUsuario,
		
		@Size(max = 255)
		String senha, 
		
		@Size(max = 255)
		String email) {

}
