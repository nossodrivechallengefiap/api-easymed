package br.com.easymed.apieasymed.model.dto.listagem;

import java.time.LocalDate;

import br.com.easymed.apieasymed.model.entity.Paciente;

public record DadosListagemPaciente(
		Long codigoPaciente,
		String nome,
		LocalDate nascimento,
		String cpf,
		Double altura,
		Double peso
		) {
	public DadosListagemPaciente(Paciente paciente) {
		this(paciente.getCodigoPaciente(), 
				paciente.getPessoaFisica().getNome(), 
				paciente.getPessoaFisica().getNascimento(),
				paciente.getPessoaFisica().getCpf(), 
				paciente.getAltura(), 
				paciente.getPeso()
			);
	}

}
