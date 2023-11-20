package br.com.easymed.apieasymed.model.entity;

import br.com.easymed.apieasymed.model.dto.DadosAtualizacaoTpUsuario;
import br.com.easymed.apieasymed.model.dto.DadosCadastroTpUsuario;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.Valid;

@Entity
@Table(name = "EM_TIPO_USUARIO")
public class TipoUsuario 
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_EM_TIPO_USUARIO")
	@SequenceGenerator(name = "SQ_EM_TIPO_USUARIO", sequenceName = "SQ_EM_TIPO_USUARIO", allocationSize = 1)
	@Column(name = "CODIGO_TIPO_USUARIO")
	private Long codigoTipoUsuario;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(
				name = "CODIGO_USUARIO",
				referencedColumnName = "CODIGO_USUARIO",
				foreignKey = @ForeignKey(name = "FK_TIPO_USUARIO_USUARIO")
			)
	private Usuario usuario;
	
	@Column(name = "TIPO_USUARIO", nullable = false)
	private String tipoUsuario;

	// CONSTRUTORES
	public TipoUsuario() {
	}
	
	public TipoUsuario(DadosCadastroTpUsuario dados) {
		this.usuario = new Usuario(dados.usuario());
		this.tipoUsuario = dados.tipoUsuario();
	}
	
	public void atualizar(@Valid DadosAtualizacaoTpUsuario dados) {
		if (dados.usuario() != null) {
			this.usuario.atualizarSemPk(dados.usuario());
		}
		
		if (dados.tipoUsuario() != null) {
			this.tipoUsuario = dados.tipoUsuario();
		}
	}

	// GETTERS & SETTERS
	public Long getCodigoTipoUsuario() {
		return codigoTipoUsuario;
	}

	public void setCodigoTipoUsuario(Long codigoTipoUsuario) {
		this.codigoTipoUsuario = codigoTipoUsuario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	// TO STRING
	@Override
	public String toString() {
		return "TipoUsuario [codigoTipoUsuario=" + codigoTipoUsuario + ", usuario=" + usuario + ", tipoUsuario="
				+ tipoUsuario + "]" + super.toString();
	}
}
