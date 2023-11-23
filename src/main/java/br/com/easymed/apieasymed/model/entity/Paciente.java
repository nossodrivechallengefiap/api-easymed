package br.com.easymed.apieasymed.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "EM_PACIENTES")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_EM_PACIENTES")
    @SequenceGenerator(name = "SQ_EM_PACIENTES", sequenceName = "SQ_EM_PACIENTES", allocationSize = 1)
    @Column(name = "CODIGO_PACIENTE")
    private Long codigoPaciente;

    @Column(name = "ALTURA")
    private Double altura;

    @Column(name = "PESO")
    private Double peso;

    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(
            name = "CODIGO_PESSOA",
            referencedColumnName = "CODIGO_PESSOA",
            foreignKey = @ForeignKey(name = "FK_PACIENTE_PESSOA")
    )
    private PessoaFisica pessoaFisica;

    // CONSTRUTORES
    public Paciente() {
    }

    public Paciente(Double altura, Double peso) {
        this.altura = altura;
        this.peso = peso;
    }

    // GETTERS & SETTERS
    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    // TO STRING
    @Override
    public String toString() {
        return "Paciente [codigoCuidador=" + codigoPaciente + ", altura=" + altura + ", peso=" + peso + "]" + super.toString();
    }
}
