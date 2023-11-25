package br.com.easymed.apieasymed.model.dto.cadastro;

import java.time.LocalDate;

import br.com.easymed.apieasymed.model.TipoPessoa;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record DadosCadastroPessoaFisica(
		@NotBlank
		@Size(max = 255)
		String nome,
		
		@NotNull
		LocalDate nascimento,
		
		@NotBlank
		@Pattern(regexp = "\\d{3}.\\d{3}.\\d{3}-\\d{2}")
		String cpf,
		
		@Valid
		@NotNull
		TipoPessoa tipo
		) {

}
