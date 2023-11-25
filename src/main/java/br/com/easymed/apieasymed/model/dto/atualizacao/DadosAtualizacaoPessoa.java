package br.com.easymed.apieasymed.model.dto.atualizacao;

import java.time.LocalDate;

import br.com.easymed.apieasymed.model.TipoPessoa;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record DadosAtualizacaoPessoa(@NotBlank
		@Size(max = 255)
		String nome, 
		
		LocalDate nascimento, 
		
		@Valid
		TipoPessoa tipo,
		
		String documento) {

}
