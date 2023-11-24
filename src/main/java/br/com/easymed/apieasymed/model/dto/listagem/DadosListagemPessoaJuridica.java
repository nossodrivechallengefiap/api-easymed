package br.com.easymed.apieasymed.model.dto.listagem;

import java.time.LocalDate;

import br.com.easymed.apieasymed.model.entity.PessoaJuridica;

public record DadosListagemPessoaJuridica(
		Long codigoPessoa,
		String nome,
		LocalDate nascimento,
		String cnpj) {
	public DadosListagemPessoaJuridica(PessoaJuridica pf) {
		this(
				pf.getCodigoPessoa(),
				pf.getNome(),
				pf.getNascimento(),
				pf.getCnpj()
			);
	}
}