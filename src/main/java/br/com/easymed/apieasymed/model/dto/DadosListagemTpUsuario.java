package br.com.easymed.apieasymed.model.dto;

import br.com.easymed.apieasymed.model.entity.TipoUsuario;

public record DadosListagemTpUsuario(
		Long codigoTipoUsuario, String email, String senha, String tipoUsuario) {
	
	public DadosListagemTpUsuario(TipoUsuario tipo) {
		this(
				tipo.getCodigoTipoUsuario(),
				tipo.getUsuario().getEmail(),
				tipo.getUsuario().getSenha(),
				tipo.getTipoUsuario()
			);
	}

}
