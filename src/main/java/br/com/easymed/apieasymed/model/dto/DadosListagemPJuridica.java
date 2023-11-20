package br.com.easymed.apieasymed.model.dto;

import br.com.easymed.apieasymed.model.entity.PessoaJuridica;

public record DadosListagemPJuridica(
		Long codigoUsuario,
		String razaoSocial,
		String senha,
		String email,
		String cnpj) {
	public DadosListagemPJuridica(PessoaJuridica pj) {
		this(
				pj.getCodigoUsuario(),
				pj.getRazaoSocial(),
				pj.getSenha(),
				pj.getEmail(),
				pj.getCnpj()
			);
	}
}
