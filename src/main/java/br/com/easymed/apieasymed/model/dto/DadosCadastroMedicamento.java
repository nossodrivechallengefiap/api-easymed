package br.com.easymed.apieasymed.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record DadosCadastroMedicamento(
		@NotBlank
		@Size(max = 255)
		String nomeMedicamento	
		) {

}
