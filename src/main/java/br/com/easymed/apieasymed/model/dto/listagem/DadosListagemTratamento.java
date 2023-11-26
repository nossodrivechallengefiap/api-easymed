package br.com.easymed.apieasymed.model.dto.listagem;

import java.time.LocalDate;

import br.com.easymed.apieasymed.model.entity.Tratamento;

public record DadosListagemTratamento(
		Long codigoTratamento,
		
		LocalDate inicioTratamento,
		
		LocalDate fimTratamento,
		
		Long intervaloMedicamento,
		
		// MEDICO
//		Long codigoMedico, 
		String nomeMedico,
		LocalDate nascimentoMedico,
		String cpfMedico,
		String crmMedico,
		
		// PACIENTE
//		Long codigoPaciente,
		String nomePaciente,
		LocalDate nascimentoPaciente,
		String cpfPaciente,
		Double alturaPaciente,
		Double pesoPaciente,
		
		// MEDICAMENTO
//		Long codigoMedicamento, 
		String nomeMedicamento, 
		String fabricanteMedicamento) {
	
	public DadosListagemTratamento(Tratamento tra) {
		this(
				tra.getCodigoTratamento(),
				tra.getInicio(),
				tra.getFim(),
				tra.getIntervalo(),
				
//				tra.getMedico().getCodigoMedico(),
				tra.getMedico().getPessoaFisica().getNome(),
				tra.getMedico().getPessoaFisica().getNascimento(),
				tra.getMedico().getPessoaFisica().getCpf(),
				tra.getMedico().getCrm(),
				
//				tra.getPaciente().getCodigoPaciente(),
				tra.getPaciente().getPessoaFisica().getNome(),
				tra.getPaciente().getPessoaFisica().getNascimento(),
				tra.getPaciente().getPessoaFisica().getCpf(),
				tra.getPaciente().getAltura(),
				tra.getPaciente().getPeso(),
				
//				tra.getMedicamento().getCodigoMedicamento(),
				tra.getMedicamento().getNome(),
				tra.getMedicamento().getFabricante()
			);
	}

}
