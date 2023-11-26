package br.com.easymed.apieasymed.model.dto.atualizacao;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;

public record DadosAtualizacaoMedico(
		@Size(max = 255)
		String crm,

		@Valid
		DadosAtualizacaoPessoaFisica pessoaFisica) {

}
