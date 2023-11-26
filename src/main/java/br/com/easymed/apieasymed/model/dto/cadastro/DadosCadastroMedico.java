package br.com.easymed.apieasymed.model.dto.cadastro;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record DadosCadastroMedico(
//		@NotBlank
		@Size(max = 255)
		String crm,
		
		@NotNull
		@Valid
		DadosCadastroPessoaFisica pessoaFisica) {
}
