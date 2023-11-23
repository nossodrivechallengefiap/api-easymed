package br.com.easymed.apieasymed.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "EM_PESSOA_JURIDICA", uniqueConstraints = {
    @UniqueConstraint(columnNames = "CNPJ", name = "UK_EM_PESSOA_JURIDICA_CNPJ")
})
@DiscriminatorValue("PJ")
public class PessoaJuridica extends Pessoa {

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


    // TO STRING

    @Override
    public String toString() {
        return "PessoaJuridica{" +
                "cnpj='" + cnpj + '\'' +
                '}';
    }
}
