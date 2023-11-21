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
	@Column(name = "VOLUME", nullable = false)
	private BigDecimal volume;

	// CONSTRUTOR VAZIO
	public MedicamentoLiquido() {
	}
	
	public MedicamentoLiquido(DadosCadastroMedLiquido dados) {
		super(dados.nomeMedicamento());
		this.volume = dados.volume();
	}
	
	public void atualizar(@Valid DadosAtualizacaoMedLiquido dados) {
		super.atualizarMedLiquido(dados);
		
		if (dados.volume() != null) {
			this.volume = dados.volume();
		}
	}
	
	// GETTERS & SETTERS
	public BigDecimal getVolume() {
		return volume;
	}

	public void setVolume(BigDecimal volume) {
		this.volume = volume;
	}

	// TO STRING
	@Override
	public String toString() {
		return "MedicamentoLiquido [volume=" + volume + "]" + super.toString();
	}
}
