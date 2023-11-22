package br.com.easymed.apieasymed.model.entity;

import java.math.BigDecimal;

import br.com.easymed.apieasymed.model.dto.DadosAtualizacaoMedLiquido;
import br.com.easymed.apieasymed.model.dto.DadosCadastroMedLiquido;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.Valid;

@Entity
@Table(name = "EM_MEDICAMENTO_LIQUIDO")
//@PrimaryKeyJoinColumn(name = "CODIGO_MEDICAMENTO_LIQUIDO")
@DiscriminatorValue("LIQUIDO")
public class MedicamentoLiquido extends Medicamento 
{	
	@Column(name = "VOLUME_ML", nullable = false)
	private BigDecimal volumeMl;

	// CONSTRUTOR VAZIO
	public MedicamentoLiquido() {
	}
	
	public MedicamentoLiquido(DadosCadastroMedLiquido dados) {
		super(dados.nomeMedicamento());
		this.volumeMl = dados.volumeMl();
	}
	
	public void atualizar(@Valid DadosAtualizacaoMedLiquido dados) {
		super.atualizarMedLiquido(dados);
		
		if (dados.volumeMl() != null) {
			this.volumeMl = dados.volumeMl();
		}
	}
	
	// GETTERS & SETTERS
	public BigDecimal getVolumeMl() {
		return volumeMl;
	}

	public void setVolumeMl(BigDecimal volumeMl) {
		this.volumeMl = volumeMl;
	}

	// TO STRING
	@Override
	public String toString() {
		return "MedicamentoLiquido [volumeMl=" + volumeMl + "]" + super.toString();
	}
}
