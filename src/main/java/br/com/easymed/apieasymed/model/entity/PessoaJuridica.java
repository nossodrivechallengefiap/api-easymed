package br.com.easymed.apieasymed.model.entity;

import br.com.easymed.apieasymed.model.dto.atualizacao.DadosAtualizacaoPessoaJuridica;
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
    }

    public PessoaJuridica(String cnpj) {
        this.cnpj = cnpj;
    }
    
    public PessoaJuridica(DadosCadastroPessoaJuridica dados) {
    	super(dados.nome(), dados.nascimento());
    	this.cnpj = dados.cnpj();
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
}
