package br.com.easymed.apieasymed.model.dto.cadastro;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record DadosCadastroPessoaJuridica(@NotBlank
		@Size(max = 255)
		String nome,
		
		@NotNull
		LocalDate nascimento,
		
		@NotBlank
		@Pattern(regexp = "\\d{2}.\\d{3}.\\d{3}/\\d{4}-\\d{2}")
		String cnpj
		) {

}
