package br.com.easymed.apieasymed.model.entity;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import br.com.easymed.apieasymed.model.dto.DadosAtualizacaoMedicUsuario;
import br.com.easymed.apieasymed.model.dto.DadosCadastroMedicUsuario;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.Valid;

@Entity
@Table(name = "EM_MEDICAMENTOS_USUARIOS")
public class MedicamentosUsuario
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_EM_MEDICAMENTOS_USUARIOS")
	@SequenceGenerator(name = "SQ_EM_MEDICAMENTOS_USUARIOS", sequenceName = "SQ_EM_MEDICAMENTOS_USUARIOS", allocationSize = 1)
	@Column(name = "CODIGO_MEDICAMENTO_USUARIO")
	private Long codigoMedicamentoUsuario;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE,CascadeType.PERSIST})
	@JoinTable(
			name = "EM_MEDICAMENTO_USUARIOS_EM_MEDICAMENTO",
			joinColumns = {
					@JoinColumn(
							name = "USUARIO", 
							referencedColumnName = "CODIGO_MEDICAMENTO_USUARIO",
							foreignKey = @ForeignKey(name = "FK_USUARIOS_MEDICAMENTOS"))
			},
			inverseJoinColumns = {
					@JoinColumn(
							name = "MEDICAMENTO", 
							referencedColumnName = "CODIGO_MEDICAMENTO", 
							foreignKey = @ForeignKey(name = "FK_MEDICAMENTOS_USUARIOS"))
			}
	)
	private Set<Medicamento> medicamento;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(
				name = "CODIGO_USUARIO",
				referencedColumnName = "CODIGO_USUARIO",
				foreignKey = @ForeignKey(name = "FK_USUARIO_MEDICAMENTO")
			)
	private Usuario usuario;
	
	
	// CONSTRUTORES
	public MedicamentosUsuario() {
		medicamento = new LinkedHashSet<>();
	}
	
	public MedicamentosUsuario(DadosCadastroMedicUsuario dados) {
	    this.usuario = new Usuario(dados.usuario());

	    this.medicamento = new LinkedHashSet<>();
	    Medicamento medicamento = new Medicamento(dados.medicamento());
	    this.medicamento.add(medicamento);
	}
	
	public void atualizar(@Valid DadosAtualizacaoMedicUsuario dados) {
		if (dados.usuario() != null) {
			this.usuario.atualizarTpUsuario(dados.usuario());
		}
		
		if (dados.medicamento() != null) {
	        Set<Medicamento> novosMedicamentos = new LinkedHashSet<>();
	        novosMedicamentos.add(new Medicamento(dados.medicamento()));

	        this.medicamento = novosMedicamentos;
	    }
	}

	// GETTERS & SETTERS
	public Long getCodigoMedicamentoUsuario() {
		return codigoMedicamentoUsuario;
	}

	public void setCodigoMedicamentoUsuario(Long codigoMedicamentoUsuario) {
		this.codigoMedicamentoUsuario = codigoMedicamentoUsuario;
	}

	public Set<Medicamento> getMedicamento() {
		return Collections.unmodifiableSet(medicamento);
	}

	public MedicamentosUsuario addMedicamento(Medicamento med) {
		medicamento.add(med);
		return this;
	}
	
	public MedicamentosUsuario removeMedicamento(Medicamento med) {
		medicamento.remove(med);
		return this;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	// TO STRING
	@Override
	public String toString() {
		return "MedicamentosUsuario [codigoMedicamentoUsuario=" + codigoMedicamentoUsuario + ", medicamento="
				+ medicamento + ", usuario=" + usuario + "]" + super.toString();
	}
}
