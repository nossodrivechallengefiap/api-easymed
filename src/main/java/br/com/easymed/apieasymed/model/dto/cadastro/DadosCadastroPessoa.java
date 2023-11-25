package br.com.easymed.apieasymed.model.dto.cadastro;

import java.time.LocalDate;

import br.com.easymed.apieasymed.model.dto.TipoPessoa;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record DadosCadastroPessoa(
		@NotBlank
		@Size(max = 255)
		String nome, 
		
		@NotNull
		LocalDate nascimento, 
		
		@NotNull
		@Valid
		TipoPessoa tipo,
		
		String documento) {

}
