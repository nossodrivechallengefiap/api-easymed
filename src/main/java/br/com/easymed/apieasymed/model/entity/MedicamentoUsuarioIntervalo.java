package br.com.easymed.apieasymed.model.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.easymed.apieasymed.model.dto.DadosAtualizacaoMedIntervalo;
import br.com.easymed.apieasymed.model.dto.DadosCadastroMedIntervalo;
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
import jakarta.validation.Valid;

@Entity
@Table(name = "EM_MEDICAMENTO_USUARIO_INTERVALO")
public class MedicamentoUsuarioIntervalo 
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_EM_MEDICAMENTO_USUARIO_INTERVALO")
	@SequenceGenerator(name = "SQ_EM_MEDICAMENTO_USUARIO_INTERVALO", sequenceName = "SQ_EM_MEDICAMENTO_USUARIO_INTERVALO", allocationSize = 1)
	@Column(name = "CODIGO_MEDICAMENTO_USUARIO_INTERVALO")
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(
				name = "CODIGO_MEDICAMENTO",
				referencedColumnName = "CODIGO_MEDICAMENTO",
				foreignKey = @ForeignKey(name = "FK_USUARIO_INTERVALO_MEDICAMENTO")
			)
	private Medicamento medicamento;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(
				name = "CODIGO_USUARIO",
				referencedColumnName = "CODIGO_USUARIO",
				foreignKey = @ForeignKey(name = "FK_MEDICAMENTO_USUARIO_INTERVALO")
			)
	private Usuario usuario;
	
	
	@Column(name = "DATA_INICIO", nullable = false)
	private LocalDate dataInicio;
	
	@Column(name = "DATA_FINAL")
	private LocalDate dataFinal;
	
	@Column(name = "INTERVALO_HORAS", nullable = false)
	private BigDecimal intervaloHoras;
	
	@Column(name = "MEDICAMENTO_ATIVO", nullable = false)
	private Boolean medicamentoAtivo;

	// CONSTRUTOR VAZIO
	public MedicamentoUsuarioIntervalo() {
	}

	public MedicamentoUsuarioIntervalo(DadosCadastroMedIntervalo dados) {
		this.medicamento = new Medicamento(dados.medicamento());
		this.usuario = new Usuario(dados.usuario());
		this.dataInicio = dados.dataInicio();
		this.dataFinal = dados.dataFinal();
		this.intervaloHoras = dados.intervaloHoras();
		this.medicamentoAtivo = dados.medicamentoAtivo();
	}
	
	public void atualizar(@Valid DadosAtualizacaoMedIntervalo dados) {
		if (dados.medicamento() != null) {
			this.medicamento.atualizarSemPk(dados.medicamento());
		}
		
		if (dados.usuario() != null) {
			this.usuario.atualizarTpUsuario(dados.usuario());
		}
		
		if (dados.dataInicio() != null) {
			this.dataInicio = dados.dataInicio();
		}
		
		if (dados.dataFinal() != null) {
			this.dataFinal = dados.dataFinal();
		}
		
		if (dados.intervaloHoras() != null) {
			this.intervaloHoras = dados.intervaloHoras();
		}
		
		if (dados.medicamentoAtivo() != null) {
			this.medicamentoAtivo = dados.medicamentoAtivo();
		}
	}
	
	// GETTERS & SETTERS
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Medicamento getMedicamento() {
		return medicamento;
	}

	public void setMedicamento(Medicamento medicamento) {
		this.medicamento = medicamento;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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
		return "MedicamentosUsuarioIntervalo [id=" + id + ", medicamento=" + medicamento + ", usuario=" + usuario
				+ ", dataInicio=" + dataInicio + ", dataFinal=" + dataFinal + ", intervaloHoras=" + intervaloHoras
				+ ", medicamentoAtivo=" + medicamentoAtivo + "]" + super.toString();
	}
}
