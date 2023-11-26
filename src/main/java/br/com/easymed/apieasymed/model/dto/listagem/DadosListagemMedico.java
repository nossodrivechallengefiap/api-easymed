package br.com.easymed.apieasymed.model.dto.listagem;

import java.time.LocalDate;

import br.com.easymed.apieasymed.model.entity.Medico;

public record DadosListagemMedico(
		Long codigoMedico, 
		String nome,
		LocalDate nascimento,
		String cpf,
		String crm) {
	public DadosListagemMedico(Medico medico) {
		this(medico.getCodigoMedico(),
				medico.getPessoaFisica().getNome(),
				medico.getPessoaFisica().getNascimento(),
				medico.getPessoaFisica().getCpf(),
				medico.getCrm());
	}
}
