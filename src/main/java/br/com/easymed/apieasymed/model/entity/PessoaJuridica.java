package br.com.easymed.apieasymed.model.entity;

import br.com.easymed.apieasymed.model.TipoPessoa;
import br.com.easymed.apieasymed.model.dto.atualizacao.DadosAtualizacaoPessoa;
import br.com.easymed.apieasymed.model.dto.atualizacao.DadosAtualizacaoPessoaJuridica;
import br.com.easymed.apieasymed.model.dto.cadastro.DadosCadastroPessoa;
import br.com.easymed.apieasymed.model.dto.cadastro.DadosCadastroPessoaJuridica;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.Valid;

@Entity
@Table(name = "EM_PESSOA_JURIDICA", uniqueConstraints = {
    @UniqueConstraint(columnNames = "CNPJ", name = "UK_EM_PESSOA_JURIDICA_CNPJ")
})
@DiscriminatorValue("PJ")
public class PessoaJuridica extends Pessoa {

    @Column(name = "CNPJ", length = 255)
    private String cnpj;

    // CONSTRUTORES
    public PessoaJuridica() {
    	super(TipoPessoa.PJ);
    }

    public PessoaJuridica(String cnpj) {
    	super(TipoPessoa.PJ);
        this.cnpj = cnpj;
    }
    
    public PessoaJuridica(DadosCadastroPessoaJuridica dados) {
    	super(dados.nome(), dados.nascimento(), dados.tipo());
    	this.cnpj = dados.cnpj();
    }
    
    public PessoaJuridica(DadosCadastroPessoa dados) {
    	super(dados.nome(), dados.nascimento(), dados.tipo());
    	
    	if (dados.tipo() == TipoPessoa.PJ) {
            this.cnpj = dados.documento();
        } else {
            this.cnpj = null;
        }
    }

    // GETTERS & SETTERS
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    // TO STRING
    @Override
    public String toString() {
        return "PessoaJuridica{" +
                "cnpj='" + cnpj + '\'' +
                '}' + super.toString();
    }
    
    // ATUALIZAR
    public void atualizar(@Valid DadosAtualizacaoPessoaJuridica dados) {
		if (dados.nome() != null) {
			this.setNome(dados.nome());
		}
		
		if (dados.nascimento() != null) {
	        this.setNascimento(dados.nascimento());
	    }
		
		if (dados.cnpj() != null) {
			this.cnpj = dados.cnpj();
		}
	}
    
    public void atualizar(@Valid DadosAtualizacaoPessoa dados) {
		if (dados.nome() != null) {
			this.setNome(dados.nome());
		}
		
		if (dados.nascimento() != null) {
	        this.setNascimento(dados.nascimento());
	    }
		
		if (dados.documento() != null) {
			this.cnpj = dados.documento();
		}
	}
}
