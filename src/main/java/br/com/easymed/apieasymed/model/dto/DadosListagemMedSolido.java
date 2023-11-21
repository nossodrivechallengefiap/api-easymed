package br.com.easymed.apieasymed.model.dto;

import java.math.BigDecimal;

import br.com.easymed.apieasymed.model.entity.MedicamentoSolido;

public record DadosListagemMedSolido(
		Long codigoMedicamento,
		String nomeMedicamento,
		BigDecimal quantidade) {
	
	public DadosListagemMedSolido(MedicamentoSolido med) {
		this(
				med.getCodigoMedicamento(),
				med.getNomeMedicamento(),
				med.getQuantidade()
			);
	}
}
