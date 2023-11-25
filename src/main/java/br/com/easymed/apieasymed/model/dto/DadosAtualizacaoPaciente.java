package br.com.easymed.apieasymed.model.dto;

import br.com.easymed.apieasymed.model.dto.atualizacao.DadosAtualizacaoPessoaFisica;
import jakarta.validation.Valid;

public record DadosAtualizacaoPaciente(		
		Double altura,

		Double peso,
		
		@Valid
		DadosAtualizacaoPessoaFisica pessoaFisica) {

}
