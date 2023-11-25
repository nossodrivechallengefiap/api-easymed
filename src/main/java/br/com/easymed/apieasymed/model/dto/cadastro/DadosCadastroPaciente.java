package br.com.easymed.apieasymed.model.dto.cadastro;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroPaciente(
		@NotNull
		Double altura,
		
		@NotNull
		Double peso,
		
		@NotNull
		@Valid
		DadosCadastroPessoaFisica pessoaFisica) {

}
