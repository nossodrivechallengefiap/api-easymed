package br.com.easymed.apieasymed.model.dto;

import br.com.easymed.apieasymed.model.entity.Usuario;

public record DadosListagemUsuario(Long codigoUsuario, String senha, String email) {
	public DadosListagemUsuario(Usuario usuario) {
		this(usuario.getCodigoUsuario(), usuario.getSenha(), usuario.getEmail());
	}
}
