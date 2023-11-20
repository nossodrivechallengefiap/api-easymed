package br.com.easymed.apieasymed.model.entity;

import java.math.BigDecimal;

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
@Table(name = "EM_MEDICAMENTO_LIQUIDO")
@PrimaryKeyJoinColumn(name = "CODIGO_MEDICAMENTO_LIQUIDO")
public class MedicamentoLiquido extends Medicamento 
{
	@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(
				name = "CODIGO_MEDICAMENTO",
				referencedColumnName = "CODIGO_MEDICAMENTO",
				foreignKey = @ForeignKey(name = "FK_MEDICAMENTO_LIQUIDO_MEDICAMENTO"),
				nullable = false
			)
	private Medicamento medicamento;
	
	@Column(name = "VOLUME", nullable = false)
	private BigDecimal volume;

	// CONSTRUTOR VAZIO
	public MedicamentoLiquido() {
	}
	
//	public MedicamentoLiquido(Long codigoMedicamento, String nomeMedicamento, Double volume) {
//		super(codigoMedicamento, nomeMedicamento);
//		this.volume = volume;
//	}
	
	// GETTERS & SETTERS
	public Medicamento getMedicamento() {
		return medicamento;
	}

	public void setMedicamento(Medicamento medicamento) {
		this.medicamento = medicamento;
	}

	public BigDecimal getVolume() {
		return volume;
	}

	public void setVolume(BigDecimal volume) {
		this.volume = volume;
	}

	// TO STRING
	@Override
	public String toString() {
		return "MedicamentoLiquido [medicamento=" + medicamento + ", volume=" + volume + "]" + super.toString();
	}
}
