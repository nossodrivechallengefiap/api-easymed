package br.com.easymed.apieasymed.model.entity;

import br.com.easymed.apieasymed.model.dto.atualizacao.DadosAtualizacaoUsuario;
import br.com.easymed.apieasymed.model.dto.cadastro.DadosCadastroUsuario;
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
import jakarta.validation.Valid;

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
	
	public Usuario(String senha, String email, Pessoa pessoa) {
		this.senha = senha;
		this.email = email;
		this.pessoa = pessoa;
	}
	
	public Usuario(DadosCadastroUsuario dados) {
		this.senha = dados.senha();
		this.email = dados.email();
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

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	// TO STRING
	@Override
	public String toString() {
		return "Usuario [codigoUsuario=" + codigoUsuario + ", senha=" + senha + ", email=" + email + "]" + super.toString();
	}
	
	// ATUALIZAR
	public void atualizar(@Valid DadosAtualizacaoUsuario dados) {
		if (dados.email() != null) {
			this.email = dados.email();
		}
		
		if (dados.senha() != null) {
			this.senha = dados.senha();
		}
	}
}
