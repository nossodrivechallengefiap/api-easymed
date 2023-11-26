package br.com.easymed.apieasymed.model.dto.cadastro;

import java.time.LocalDate;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroTratamento(
		@NotNull
		LocalDate inicio,
		
		LocalDate fim,
		
		@NotNull
		Long intervalo,
		
		@Valid
		DadosCadastroMedico medico,
		
		@Valid
		@NotNull
		DadosCadastroPaciente paciente,
		
		@Valid
		@NotNull
		DadosCadastroMedicamento medicamento
		
		) {

}
