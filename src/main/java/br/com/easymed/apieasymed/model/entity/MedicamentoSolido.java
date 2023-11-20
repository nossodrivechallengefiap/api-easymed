package br.com.easymed.apieasymed.model.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "EM_MEDICAMENTO_SOLIDO")
@PrimaryKeyJoinColumn(name = "CODIGO_MEDICAMENTO_SOLIDO")
public class MedicamentoSolido extends Medicamento 
{
	@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(
				name = "CODIGO_MEDICAMENTO",
				referencedColumnName = "CODIGO_MEDICAMENTO",
				foreignKey = @ForeignKey(name = "FK_MEDICAMENTO_SOLIDO_MEDICAMENTO"),
				nullable = false
			)
	private Medicamento medicamento;
	
	@Column(name = "QUANTIDADE", nullable = false)
	private Long quantidade;

	// CONSTRUTORES
	public MedicamentoSolido() {
	}

//	public MedicamentoSolido(Long codigoMedicamento, String nomeMedicamento, Long quantidade) {
//		super(codigoMedicamento, nomeMedicamento);
//		this.quantidade = quantidade;
//	}

	// GETTERS & SETTERS
	public Medicamento getMedicamento() {
		return medicamento;
	}

	public void setMedicamento(Medicamento medicamento) {
		this.medicamento = medicamento;
	}

	public Long getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}

	// TO STRING
	@Override
	public String toString() {
		return "MedicamentoSolido [medicamento=" + medicamento + ", quantidade=" + quantidade + "]" + super.toString();
	}
}
