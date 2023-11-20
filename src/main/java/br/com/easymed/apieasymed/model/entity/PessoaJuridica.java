package br.com.easymed.apieasymed.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "EM_PESSOA_JURIDICA", uniqueConstraints = {
		@UniqueConstraint(columnNames = "CNPJ", name = "UK_PJ_CNPJ")
})
@DiscriminatorValue("PJ")
public class PessoaJuridica extends Usuario
{
	@Column(name = "RAZAO_SOCIAL", nullable = false, length = 255)
	private String razaoSocial;
	
	@Column(name = "CNPJ", nullable = false, length = 18)
	private String cnpj;

	// CONSTRUTORES
	public PessoaJuridica() {
	}

	// GETTERS & SETTERS
	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	// TO STRING
	@Override
	public String toString() {
		return "PessoaJuridica [razaoSocial=" + razaoSocial + ", cnpj=" + cnpj + "]" + super.toString();
	}
}
