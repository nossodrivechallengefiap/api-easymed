package br.com.easymed.apieasymed.model.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "EM_MEDICAMENTO_USUARIO_INTERVALO")
public class MedicamentosUsuarioIntervalo 
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_EM_MEDICAMENTO_USUARIO_INTERVALO")
	@SequenceGenerator(name = "SQ_EM_MEDICAMENTO_USUARIO_INTERVALO", sequenceName = "SQ_EM_MEDICAMENTO_USUARIO_INTERVALO", allocationSize = 1)
	@Column(name = "CODIGO_MEDICAMENTO_USUARIO_INTERVALO")
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(
				name = "CODIGO_MEDICAMENTO_USUARIO",
				referencedColumnName = "CODIGO_MEDICAMENTO_USUARIO",
				foreignKey = @ForeignKey(name = "FK_USUARIO_MEDICAMENTO_INTERVALO")
			)
	private MedicamentosUsuario medicamentosUsuario;
	
	@Column(name = "DATA_INICIO", nullable = false)
	private LocalDate dataInicio;
	
	@Column(name = "DATA_FINAL")
	private LocalDate dataFinal;
	
	@Column(name = "INTERVALO_HORAS", nullable = false)
	private BigDecimal intervaloHoras;
	
	@Column(name = "MEDICAMENTO_ATIVO", nullable = false)
	private Boolean medicamentoAtivo;

	// CONSTRUTOR VAZIO
	public MedicamentosUsuarioIntervalo() {
	}

	// GETTERS & SETTERS
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public MedicamentosUsuario getMedicamentosUsuario() {
		return medicamentosUsuario;
	}

	public void setMedicamentosUsuario(MedicamentosUsuario medicamentosUsuario) {
		this.medicamentosUsuario = medicamentosUsuario;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDate getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(LocalDate dataFinal) {
		this.dataFinal = dataFinal;
	}

	public BigDecimal getIntervaloHoras() {
		return intervaloHoras;
	}

	public void setIntervaloHoras(BigDecimal intervaloHoras) {
		this.intervaloHoras = intervaloHoras;
	}

	public Boolean getMedicamentoAtivo() {
		return medicamentoAtivo;
	}

	public void setMedicamentoAtivo(Boolean medicamentoAtivo) {
		this.medicamentoAtivo = medicamentoAtivo;
	}

	// TO STRING
	@Override
	public String toString() {
		return "MedicamentoUsuarioIntervalo [id=" + id + ", medicamentosUsuario=" + medicamentosUsuario
				+ ", dataInicio=" + dataInicio + ", dataFinal=" + dataFinal + ", intervaloHoras=" + intervaloHoras
				+ ", medicamentoAtivo=" + medicamentoAtivo + "]" + super.toString();
	}
}
