package br.com.easymed.apieasymed.model.dto.cadastro;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record DadosCadastroMedicamento(
		@NotBlank
		@Size(max = 255)
		String nome,
		
		@NotBlank
		@Size(max = 255)
		String fabricante
		
		) {

}
