package br.com.easymed.apieasymed.model.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.easymed.apieasymed.model.entity.MedicamentoUsuarioIntervalo;

public record DadosListagemMedIntervalo(Long id, String email, String senha, String nomeMedicamento, LocalDate dataInicio,
		LocalDate dataFinal, BigDecimal intervaloHoras, Boolean medicamentoAtivo) 
{
	public DadosListagemMedIntervalo(MedicamentoUsuarioIntervalo med) {
		this(
				med.getId(),
				med.getUsuario().getEmail(), 
				med.getUsuario().getSenha(),
				med.getMedicamento().getNomeMedicamento(),
				med.getDataInicio(), 
				med.getDataFinal(),
				med.getIntervaloHoras(), 
				med.getMedicamentoAtivo()
			);
	}
} 
