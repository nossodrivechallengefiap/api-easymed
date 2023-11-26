package br.com.easymed.apieasymed.model.dto.cadastro;

import br.com.easymed.apieasymed.model.entity.PessoaFisica;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record DadosCadastroMedico(
		@NotBlank
		@Size(max = 255)
		String crm,
		
		@NotNull
		@Valid
		PessoaFisica pessoaFisica) {
}
