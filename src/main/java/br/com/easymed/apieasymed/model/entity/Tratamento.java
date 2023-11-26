package br.com.easymed.apieasymed.model.entity;

import java.time.LocalDate;

import br.com.easymed.apieasymed.model.dto.atualizacao.DadosAtualizacaoTratamento;
import br.com.easymed.apieasymed.model.dto.cadastro.DadosCadastroTratamento;
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
@Table(name = "EM_TRATAMENTOS")
public class Tratamento {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_EM_TRATAMENTOS")
    @SequenceGenerator(name = "SQ_EM_TRATAMENTOS", sequenceName = "SQ_EM_TRATAMENTOS", allocationSize = 1)
    @Column(name = "CODIGO_TRATAMENTO")
    private Long codigoTratamento;

    @Column(name = "DT_INICIO")
    private LocalDate inicio;

    @Column(name = "DT_FIM")
    private LocalDate fim;

    @Column(name = "INTERVALO")
    private Long intervalo;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(
            name = "CODIGO_MEDICO",
            referencedColumnName = "CODIGO_MEDICO",
            foreignKey = @ForeignKey(name = "FK_TRATAMENTO_MEDICO")
    )
    private Medico medico;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(
            name = "CODIGO_PACIENTE",
            referencedColumnName = "CODIGO_PACIENTE",
            foreignKey = @ForeignKey(name = "FK_TRATAMENTO_PACIENTE")
    )
    private Paciente paciente;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(
            name = "CODIGO_MEDICAMENTO",
            referencedColumnName = "CODIGO_MEDICAMENTO",
            foreignKey = @ForeignKey(name = "FK_TRATAMENTO_MEDICAMENTO")
    )
    private Medicamento medicamento;


    // CONSTRUTORES
    public Tratamento() {
    }

    public Tratamento(LocalDate inicio, LocalDate fim, Long intervalo) {
        this.inicio = inicio;
        this.fim = fim;
        this.intervalo = intervalo;
    }
    
    public Tratamento(DadosCadastroTratamento dados) {
    	this.inicio = dados.inicio();
    	this.fim = dados.fim();
    	this.intervalo = dados.intervalo();
    	this.medico = new Medico(dados.medico());
    	this.paciente = new Paciente(dados.paciente());
    	this.medicamento = new Medicamento(dados.medicamento());
    }

    // GETTERS & SETTERS
    public Long getCodigoTratamento() {
		return codigoTratamento;
	}

	public void setCodigoTratamento(Long codigoTratamento) {
		this.codigoTratamento = codigoTratamento;
	}

	public LocalDate getInicio() {
		return inicio;
	}

	public void setInicio(LocalDate inicio) {
		this.inicio = inicio;
	}

	public LocalDate getFim() {
		return fim;
	}

	public void setFim(LocalDate fim) {
		this.fim = fim;
	}

	public Long getIntervalo() {
		return intervalo;
	}

	public void setIntervalo(Long intervalo) {
		this.intervalo = intervalo;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Medicamento getMedicamento() {
		return medicamento;
	}

	public void setMedicamento(Medicamento medicamento) {
		this.medicamento = medicamento;
	}

    // TO STRING
    @Override
    public String toString() {
        return "Tratamento{" +
                "codigoTratamento=" + codigoTratamento +
                ", inicio=" + inicio +
                ", fim=" + fim +
                ", intervalo=" + intervalo +
                ", medico=" + medico +
                ", paciente=" + paciente +
                ", medicamento=" + medicamento +
                '}';
    }

	public void atualizar(@Valid DadosAtualizacaoTratamento dados) {
		if (dados.inicio() != null) {
			this.inicio = dados.inicio(); 
		}
		
		if (dados.fim() != null) {
			this.fim = dados.fim();
		}
		
		if (dados.intervalo() != null) {
		    this.intervalo = dados.intervalo();
		}
		
		if (dados.medico() != null) {
			this.medico.atualizar(dados.medico());
		}
		
		if (dados.paciente() != null) {
			this.paciente.atualizar(dados.paciente());
		}
		
		if (dados.medicamento() != null) {
			this.medicamento.atualizar(dados.medicamento());
		}
	}
}
