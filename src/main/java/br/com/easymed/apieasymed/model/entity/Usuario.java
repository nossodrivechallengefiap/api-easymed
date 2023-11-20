package br.com.easymed.apieasymed.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "EM_USUARIOS", uniqueConstraints = {
		@UniqueConstraint(columnNames = "EMAIL", name = "UK_EM_USUARIOS_EMAIL")
})
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "TP_USUARIO")
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

	// CONSTRUTOR VAZIO
	public Usuario() {
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
