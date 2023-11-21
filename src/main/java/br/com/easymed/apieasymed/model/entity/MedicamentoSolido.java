package br.com.easymed.apieasymed.model.entity;

import java.math.BigDecimal;

import br.com.easymed.apieasymed.model.dto.DadosAtualizacaoMedSolido;
import br.com.easymed.apieasymed.model.dto.DadosCadastroMedSolido;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.Valid;

@Entity
@Table(name = "EM_MEDICAMENTO_SOLIDO")
@DiscriminatorValue("SOLIDO")
public class MedicamentoSolido extends Medicamento 
{	
	@Column(name = "QUANTIDADE", nullable = false)
	private BigDecimal quantidade;

	// CONSTRUTORES
	public MedicamentoSolido() {
	}

	public MedicamentoSolido(DadosCadastroMedSolido dados) {
		super(dados.nomeMedicamento());
		this.quantidade = dados.quantidade();
	}
	
	public void atualizar(@Valid DadosAtualizacaoMedSolido dados) {
		super.atualizarMedSolido(dados);
		
		if (dados.quantidade() != null) {
			this.quantidade = dados.quantidade();
		}
	}	

	// GETTERS & SETTERS
	public BigDecimal getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(BigDecimal quantidade) {
		this.quantidade = quantidade;
	}

	// TO STRING
	@Override
	public String toString() {
		return "MedicamentoSolido [quantidade=" + quantidade + "]" + super.toString();
	}
}
