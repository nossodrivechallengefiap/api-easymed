package br.com.easymed.apieasymed.model.dto.listagem;

import br.com.easymed.apieasymed.model.entity.Medicamento;

public record DadosListagemMedicamento(
		Long codigoMedicamento, 
		String nome, 
		String fabricante) {
	
	public DadosListagemMedicamento(Medicamento medicamento) {
		this(
				medicamento.getCodigoMedicamento(), 
				medicamento.getNome(), 
				medicamento.getFabricante()
			);
	}

}
