package br.com.easymed.apieasymed.model.dto.atualizacao;

import java.time.LocalDate;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record DadosAtualizacaoPessoaFisica(
		@Size(max = 255)
        String nome,
        
        LocalDate nascimento,
        
        @Pattern(regexp = "\\d{3}.\\d{3}.\\d{3}-\\d{2}")
        String cpf
) {
}
