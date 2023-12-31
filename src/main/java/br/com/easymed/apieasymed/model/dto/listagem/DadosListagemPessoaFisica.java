package br.com.easymed.apieasymed.model.dto.listagem;

import java.time.LocalDate;

import br.com.easymed.apieasymed.model.dto.TipoPessoa;
import br.com.easymed.apieasymed.model.entity.PessoaFisica;

public record DadosListagemPessoaFisica(
		Long codigoPessoa,
		String nome,
		LocalDate nascimento,
		String cpf,
		TipoPessoa tipo) {
	public DadosListagemPessoaFisica(PessoaFisica pf) {
		this(
				pf.getCodigoPessoa(),
				pf.getNome(),
				pf.getNascimento(),
				pf.getCpf(),
				pf.getTipo()
			);
	}
}
