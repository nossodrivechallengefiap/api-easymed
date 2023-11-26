package br.com.easymed.apieasymed.model.entity;

import br.com.easymed.apieasymed.model.dto.atualizacao.DadosAtualizacaoMedico;
import br.com.easymed.apieasymed.model.dto.cadastro.DadosCadastroMedico;
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
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "EM_MEDICOS", uniqueConstraints = {
    @UniqueConstraint(columnNames = "CRM", name = "UK_EM_MEDICO_CRM")
})
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_EM_MEDICOS")
    @SequenceGenerator(name = "SQ_EM_MEDICOS", sequenceName = "SQ_EM_MEDICOS", allocationSize = 1)
    @Column(name = "CODIGO_MEDICO")
    private Long codigoMedico;

    @Column(name = "CRM", length = 255)
    private String crm;

    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(
            name = "CODIGO_PESSOA",
            referencedColumnName = "CODIGO_PESSOA",
            foreignKey = @ForeignKey(name = "FK_MEDICO_PESSOA")
    )
    private PessoaFisica pessoaFisica;

    // CONSTRUTORES
    public Medico() {
    }

    public Medico(String crm) {
        this.crm = crm;
    }
    
    public Medico(DadosCadastroMedico dados) {
    	this.crm = dados.crm();
    	this.pessoaFisica = dados.pessoaFisica();
    }

    // GETTERS & SETTERS
    public Long getCodigoMedico() {
		return codigoMedico;
	}

	public void setCodigoMedico(Long codigoMedico) {
		this.codigoMedico = codigoMedico;
	}

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
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
        return "Medico [codigoMedico=" + codigoMedico + ", crm=" + crm + "]" + super.toString();
    }
    
    public void atualizar(DadosAtualizacaoMedico dados) {
    	if (dados.crm() != null) {
    		this.crm = dados.crm();
    	}
    	
    	if (dados.pessoaFisica() != null) {
    		this.pessoaFisica.atualizar(dados.pessoaFisica());
    	}
    }
}
