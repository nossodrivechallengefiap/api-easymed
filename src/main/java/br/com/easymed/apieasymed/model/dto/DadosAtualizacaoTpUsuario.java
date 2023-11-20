package br.com.easymed.apieasymed.model.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record DadosAtualizacaoTpUsuario(
		@NotNull
		Long codigoTipoUsuario,

		@Valid
		DadosAtualizacaoUsuarioSemPk usuario,
		
		@Size(max = 255)
		String tipoUsuario
		) {

}
