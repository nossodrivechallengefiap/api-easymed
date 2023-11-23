package br.com.easymed.apieasymed.model.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "EM_PESSOAS")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "TIPO_PESSOA")
public abstract class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_EM_PESSOAS")
    @SequenceGenerator(name = "SQ_EM_PESSOAS", sequenceName = "SQ_EM_PESSOAS", allocationSize = 1)
    @Column(name = "CODIGO_PESSOA")
    private Long codigoPessoa;

    @Column(name = "NOME", length = 255, nullable = false)
    private String nome;

    @Column(name = "NASCIMENTO")
    private LocalDate nascimento;

    // CONSTRUTORES
    public Pessoa() {
    }

    public Pessoa(String nome, LocalDate nascimento) {
        this.nome = nome;
        this.nascimento = nascimento;
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

    // TO STRING
    @Override
    public String toString() {
        return "Pessoa [codigoPessoa=" + codigoPessoa + ", nome=" + nome + ", nascimento=" + nascimento + "]" + super.toString();
    }
}
