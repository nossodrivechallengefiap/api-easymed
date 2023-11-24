package br.com.easymed.apieasymed.model.entity;

import br.com.easymed.apieasymed.model.dto.atualizacao.DadosAtualizacaoPessoaFisica;
import br.com.easymed.apieasymed.model.dto.cadastro.DadosCadastroPessoaFisica;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.Valid;

@Entity
@Table(name = "EM_PESSOA_FISICA", uniqueConstraints = {
    @UniqueConstraint(columnNames = "CPF", name = "UK_EM_PESSOA_FISICA_CPF")
})
@DiscriminatorValue("PF")
public class PessoaFisica extends Pessoa {

    @Column(name = "CPF", length = 14)
    private String cpf;

    // CONSTRUTORES
    public PessoaFisica() {
    }

    public PessoaFisica(String cpf) {
        this.cpf = cpf;
    }
    
    public PessoaFisica(DadosCadastroPessoaFisica dados) {
    	super(dados.nome(), dados.nascimento());
    	this.cpf = dados.cpf();
    }
    
    // GETTERS & SETTERS
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    // TO STRING
    @Override
    public String toString() {
        return "PessoaFisica{" +
                "cpf='" + cpf + '\'' +
                '}' + super.toString();
    }
    
    // ATUALIZAR
    public void atualizar(@Valid DadosAtualizacaoPessoaFisica dados) {
		if (dados.nome() != null) {
			this.setNome(dados.nome());
		}
		
		if (dados.nascimento() != null) {
	        this.setNascimento(dados.nascimento());
	    }
		
		if (dados.cpf() != null) {
			this.cpf = dados.cpf();
		}
	}
}
