package br.com.easymed.apieasymed.model.entity;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

import br.com.easymed.apieasymed.model.dto.DadosAtualizacaoPFisica;
import br.com.easymed.apieasymed.model.dto.DadosAtualizacaoPJuridica;
import br.com.easymed.apieasymed.model.dto.DadosAtualizacaoUsuario;
import br.com.easymed.apieasymed.model.dto.DadosAtualizacaoUsuarioSemPk;
import br.com.easymed.apieasymed.model.dto.DadosCadastroUsuario;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OrderBy;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.Valid;

@Entity
@Table(name = "EM_USUARIOS", uniqueConstraints = {
		@UniqueConstraint(columnNames = "EMAIL", name = "UK_EM_USUARIOS_EMAIL")
})
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "TIPO_USUARIO")
public class Usuario 
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_EM_USUARIOS")
	@SequenceGenerator(name = "SQ_EM_USUARIOS", sequenceName = "SQ_EM_USUARIOS", allocationSize = 1)
	@Column(name = "CODIGO_USUARIO")
	private Long codigoUsuario;
	
	@Column(name = "SENHA", length = 255, nullable = false)
	private String senha;
	
	@Column(name = "EMAIL", length = 255, nullable = false)
	private String email;
		
	// CONSTRUTORES
	public Usuario() {
	}
	
	public Usuario(String senha, String email) {
		this.senha = senha;
		this.email = email;
	}

	public Usuario (DadosCadastroUsuario dados) {
		this.senha = dados.senha();
		this.email = dados.email();
	}
	
	
	public void atualizar(@Valid DadosAtualizacaoUsuario dados) {
		if (dados.senha() != null) {
			this.senha = dados.senha();
		}
		
		if (dados.email() != null) {
			this.email = dados.email();
		}
	}
	
	public void atualizarTpUsuario(@Valid DadosAtualizacaoUsuarioSemPk dados) {
		if (dados.senha() != null) {
			this.senha = dados.senha();
		}
		
		if (dados.email() != null) {
			this.email = dados.email();
		}
	}
	
	public void atualizarPf(@Valid DadosAtualizacaoPFisica dados) {
		if (dados.senha() != null) {
			this.senha = dados.senha();
		}
		
		if (dados.email() != null) {
			this.email = dados.email();
		}
	}
	
	public void atualizarPj(@Valid DadosAtualizacaoPJuridica dados) {
		if (dados.senha() != null) {
			this.senha = dados.senha();
		}
		
		if (dados.email() != null) {
			this.email = dados.email();
		}
	}
	
	// GETTERS & SETTERS
	public Long getCodigoUsuario() {
		return codigoUsuario;
	}

	public void setCodigoUsuario(Long codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	// TO STRING
	@Override
	public String toString() {
		return "Usuario [codigoUsuario=" + codigoUsuario + ", senha=" + senha + ", email=" + email + "]" + super.toString();
	}	
}
