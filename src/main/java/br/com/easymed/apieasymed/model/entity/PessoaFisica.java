package br.com.easymed.apieasymed.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "EM_PESSOA_FISICA", uniqueConstraints = {
		@UniqueConstraint(name = "UK_PF_CPF", columnNames = "CPF")
})
@DiscriminatorValue("PF")
public class PessoaFisica extends Usuario
{
	@Column(name = "NOME", nullable = false, length = 255)
	private String nome;
	
	@Column(name = "CPF", nullable = false, length = 14)
	private String cpf;

	// CONSTRUTORES
	public PessoaFisica() {
	}

	// GETTERS & SETTERS
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	// TO STRING
	@Override
	public String toString() {
		return "PessoaFisica [nome=" + nome + ", cpf=" + cpf + "]" + super.toString();
	}
}
