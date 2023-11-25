package br.com.easymed.apieasymed.model.entity;

import java.time.LocalDate;

import br.com.easymed.apieasymed.model.dto.TipoPessoa;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "EM_PESSOAS")
@Inheritance(strategy = InheritanceType.JOINED)
//@DiscriminatorColumn(name = "TIPO_PESSOA")
public class Pessoa implements Comparable<Pessoa>{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_EM_PESSOAS")
    @SequenceGenerator(name = "SQ_EM_PESSOAS", sequenceName = "SQ_EM_PESSOAS", allocationSize = 1)
    @Column(name = "CODIGO_PESSOA")
    private Long codigoPessoa;

    @Column(name = "NOME", length = 255, nullable = false)
    private String nome;

    @Column(name = "NASCIMENTO")
    private LocalDate nascimento;

    @Enumerated(EnumType.STRING)
    @Column(name = "TP_PESSOA")
    private TipoPessoa tipo;
    

    // CONSTRUTORES
    public Pessoa() {
    }
    
	public Pessoa(TipoPessoa tipo) {
    	this.tipo = tipo;
    }

    public Pessoa(String nome, LocalDate nascimento, TipoPessoa tipo) {
        this.nome = nome;
        this.nascimento = nascimento;
        this.tipo = tipo;
    }
    
    // GETTERS & SETTERS
    public Long getCodigoPessoa() {
        return codigoPessoa;
    }

    public void setCodigoPessoa(Long codigoPessoa) {
        this.codigoPessoa = codigoPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }
    
    public TipoPessoa getTipo() {
		return tipo;
	}

	public void setTipo(TipoPessoa tipo) {
		this.tipo = tipo;
	}

	// TO STRING
	@Override
	public String toString() {
		return "Pessoa [codigoPessoa=" + codigoPessoa + ", nome=" + nome + ", nascimento=" + nascimento + ", tipo="
				+ tipo + "]" + super.toString();
	}

	@Override
    public int compareTo(Pessoa o) {
        return (int) (this.getCodigoPessoa() - o.getCodigoPessoa());
    }
}
