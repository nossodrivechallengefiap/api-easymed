package br.com.easymed.apieasymed.model.dto;

import java.math.BigDecimal;

import br.com.easymed.apieasymed.model.entity.MedicamentoLiquido;

public record DadosListagemMedLiquido(
		Long codigoMedicamento,
		String nomeMedicamento,
		BigDecimal volume) {
	
	public DadosListagemMedLiquido(MedicamentoLiquido med) {
		this(
				med.getCodigoMedicamento(),
				med.getNomeMedicamento(),
				med.getVolume()
			);
	}
}