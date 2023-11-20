package br.com.easymed.apieasymed.model.dto;

import br.com.easymed.apieasymed.model.entity.PessoaFisica;

public record DadosListagemPFisica(
		Long codigoUsuario,
		String nome,
		String senha,
		String email,
		String cpf) {
	public DadosListagemPFisica(PessoaFisica pf) {
		this(
				pf.getCodigoUsuario(),
				pf.getNome(),
				pf.getSenha(),
				pf.getEmail(),
				pf.getCpf()
			);
	}
}
