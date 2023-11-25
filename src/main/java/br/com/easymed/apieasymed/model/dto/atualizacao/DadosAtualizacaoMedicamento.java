package br.com.easymed.apieasymed.model.dto.atualizacao;

import jakarta.validation.constraints.Size;

public record DadosAtualizacaoMedicamento(
		@Size(max = 255)
		String nome,
		
		@Size(max = 255)
		String fabricante) {

}
