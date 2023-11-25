package br.com.easymed.apieasymed.model.dto.atualizacao;

import jakarta.validation.Valid;

public record DadosAtualizacaoPaciente(		
		Double altura,

		Double peso,
		
		@Valid
		DadosAtualizacaoPessoaFisica pessoaFisica) {

}
