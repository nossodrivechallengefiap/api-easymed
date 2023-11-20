package br.com.easymed.apieasymed.model.dto;

import jakarta.validation.constraints.Size;

public record DadosAtualizacaoUsuarioSemPk(
		@Size(max = 255)
		String senha, 
		
		@Size(max = 255)
		String email) {

}
