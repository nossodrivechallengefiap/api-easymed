package br.com.easymed.apieasymed.model.entity;

import br.com.easymed.apieasymed.model.dto.DadosAtualizacaoMedLiquido;
import br.com.easymed.apieasymed.model.dto.DadosAtualizacaoMedSolido;
import br.com.easymed.apieasymed.model.dto.DadosAtualizacaoMedicamento;
import br.com.easymed.apieasymed.model.dto.DadosCadastroMedicamento;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.Valid;

@Entity
@Table(name = "EM_MEDICAMENTOS")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "TIPO_MEDICAMENTO")
public class Medicamento
{	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_EM_MEDICAMENTOS")
	@SequenceGenerator(name = "SQ_EM_MEDICAMENTOS", sequenceName = "SQ_EM_MEDICAMENTOS", allocationSize = 1)
	@Column(name = "CODIGO_MEDICAMENTO")
	private Long codigoMedicamento;
	
	@Column(name = "NOME_MEDICAMENTO", length = 255, nullable = false)
	private String nomeMedicamento;

	// CONSTRUTOR VAZIO
	public Medicamento() {
	}
	
	public Medicamento(String nomeMedicamento) {
		this.nomeMedicamento = nomeMedicamento;
	}

	public Medicamento(DadosCadastroMedicamento dados) {
		this.nomeMedicamento = dados.nomeMedicamento();
	}
	
	public void atualizar(@Valid DadosAtualizacaoMedicamento dados) {
		if (dados.nomeMedicamento() != null) {
			this.nomeMedicamento = dados.nomeMedicamento();
		}
	}
	
	public void atualizarMedLiquido(@Valid DadosAtualizacaoMedLiquido dados) {
		if (dados.nomeMedicamento() != null) {
			this.nomeMedicamento = dados.nomeMedicamento();
		}
	}
	
	public void atualizarMedSolido(@Valid DadosAtualizacaoMedSolido dados) {
		if (dados.nomeMedicamento() != null) {
			this.nomeMedicamento = dados.nomeMedicamento();
		}
	}
	
	
	// GETTERS & SETTERS
	public Long getCodigoMedicamento() {
		return codigoMedicamento;
	}

	public void setCodigoMedicamento(Long codigoMedicamento) {
		this.codigoMedicamento = codigoMedicamento;
	}

	public String getNomeMedicamento() {
		return nomeMedicamento;
	}

	public void setNomeMedicamento(String nomeMedicamento) {
		this.nomeMedicamento = nomeMedicamento;
	}

	// TO STRING
	@Override
	public String toString() {
		return "Medicamento [codigoMedicamento=" + codigoMedicamento + ", nomeMedicamento=" + nomeMedicamento + "]" + super.toString();
	}
}
