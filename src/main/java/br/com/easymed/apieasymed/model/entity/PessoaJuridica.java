package br.com.easymed.apieasymed.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "EM_PESSOA_JURIDICA", uniqueConstraints = {
    @UniqueConstraint(columnNames = "CNPJ", name = "UK_EM_PESSOA_JURIDICA_CNPJ")
})
@DiscriminatorValue("PJ")
public class PessoaJuridica extends Pessoa {

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_EM_PESSOA_JURIDICA")
    @SequenceGenerator(name = "SQ_EM_PESSOA_JURIDICA", sequenceName = "SQ_EM_PESSOA_JURIDICA", allocationSize = 1)
    @Column(name = "CODIGO_PESSOA_JURIDICA")
    private Long codigoPessoaJuridica;

    @Column(name = "CNPJ", length = 255)
    private String cnpj;

    // CONSTRUTORES
    public PessoaJuridica() {
    }

    public PessoaJuridica(String cnpj) {
        this.cnpj = cnpj;
    }

    // GETTERS & SETTERS
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Long getCodigoPessoaJuridica() {
        return codigoPessoaJuridica;
    }

    public void setCodigoPessoaJuridica(Long codigoPessoaJuridica) {
        this.codigoPessoaJuridica = codigoPessoaJuridica;
    }

    // TO STRING
    @Override
    public String toString() {
        return "PessoaJuridica [codigoPessoaJuridica=" + codigoPessoaJuridica + ", cnpj=" + cnpj + "]" + super.toString();
    }
}
