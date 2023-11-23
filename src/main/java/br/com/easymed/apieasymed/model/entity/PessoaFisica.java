package br.com.easymed.apieasymed.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "EM_PESSOA_FISICA", uniqueConstraints = {
    @UniqueConstraint(columnNames = "CPF", name = "UK_EM_PESSOA_FISICA_CPF")
})
@DiscriminatorValue("PF")
public class PessoaFisica extends Pessoa {

    @Column(name = "CPF", length = 255)
    private String cpf;

    // CONSTRUTORES
    public PessoaFisica() {
    }

    public PessoaFisica(String cpf) {
        this.cpf = cpf;
    }

    // GETTERS & SETTERS
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    // TO STRING
    @Override
    public String toString() {
        return "PessoaFisica{" +
                "cpf='" + cpf + '\'' +
                '}';
    }
}
