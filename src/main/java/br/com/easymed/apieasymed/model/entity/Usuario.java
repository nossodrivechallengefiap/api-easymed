package br.com.easymed.apieasymed.model.entity;

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
@Table(name = "EM_USUARIOS", uniqueConstraints = {
		@UniqueConstraint(columnNames = "EMAIL", name = "UK_EM_USUARIOS_EMAIL")
})
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

	@OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(
			name = "CODIGO_PESSOA",
			referencedColumnName = "CODIGO_PESSOA",
			foreignKey = @ForeignKey(name = "FK_USUARIO_PESSOA")
	)
	private Pessoa pessoa;
		
	// CONSTRUTORES
	public Usuario() {
	}
	
	public Usuario(String senha, String email) {
		this.senha = senha;
		this.email = email;
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
