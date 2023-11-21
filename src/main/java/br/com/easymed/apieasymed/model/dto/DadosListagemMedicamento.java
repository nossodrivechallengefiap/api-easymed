package br.com.easymed.apieasymed.model.dto;

import br.com.easymed.apieasymed.model.entity.Medicamento;

public record DadosListagemMedicamento(
		Long codigoMedicamento,
		String nomeMedicamento) {
	public DadosListagemMedicamento(Medicamento medicamento) {
		this(medicamento.getCodigoMedicamento(), medicamento.getNomeMedicamento());	
	}
}
