package br.com.easymed.apieasymed.model.entity;

import br.com.easymed.apieasymed.model.dto.atualizacao.DadosAtualizacaoPaciente;
import br.com.easymed.apieasymed.model.dto.cadastro.DadosCadastroPaciente;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.Valid;

@Entity
@Table(name = "EM_PACIENTES")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_EM_PACIENTES")
    @SequenceGenerator(name = "SQ_EM_PACIENTES", sequenceName = "SQ_EM_PACIENTES", allocationSize = 1)
    @Column(name = "CODIGO_PACIENTE")
    private Long codigoPaciente;

    @Column(name = "ALTURA")
    private Double altura;

    @Column(name = "PESO")
    private Double peso;

    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(
            name = "CODIGO_PESSOA",
            referencedColumnName = "CODIGO_PESSOA",
            foreignKey = @ForeignKey(name = "FK_PACIENTE_PESSOA")
    )
    private PessoaFisica pessoaFisica;

    // CONSTRUTORES
    public Paciente() {
    }

    public Paciente(Double altura, Double peso) {
        this.altura = altura;
        this.peso = peso;
    }
    
    public Paciente(DadosCadastroPaciente dados) {
    	this.altura = dados.altura();
    	this.peso = dados.peso();
    	this.pessoaFisica = new PessoaFisica(dados.pessoaFisica());
    }

    // GETTERS & SETTERS
    public Long getCodigoPaciente() {
		return codigoPaciente;
	}

	public void setCodigoPaciente(Long codigoPaciente) {
		this.codigoPaciente = codigoPaciente;
	}

	public Double getAltura() {
		return altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public PessoaFisica getPessoaFisica() {
		return pessoaFisica;
	}

	public void setPessoaFisica(PessoaFisica pessoaFisica) {
		this.pessoaFisica = pessoaFisica;
	}

    // TO STRING
    @Override
    public String toString() {
        return "Paciente [codigoCuidador=" + codigoPaciente + ", altura=" + altura + ", peso=" + peso + "]" + super.toString();
    }
    
    public void atualizar(@Valid DadosAtualizacaoPaciente dados) {
    	if (dados.altura() != null) {
    		this.altura = dados.altura();
    	}
    	
    	if (dados.peso() != null) {
    		this.peso = dados.peso();
    	}
    	
    	if (dados.pessoaFisica() != null) {
    		this.pessoaFisica.atualizar(dados.pessoaFisica());
    	}    	
    }
}
