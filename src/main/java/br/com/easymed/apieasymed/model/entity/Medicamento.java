package br.com.easymed.apieasymed.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "EM_MEDICAMENTOS", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"NOME", "FABRICANTE"}, name = "UK_EM_MEDICAMENTO_NOME_FABRICANTE")
})
public class Medicamento {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_EM_MEDICAMENTOS")
    @SequenceGenerator(name = "SQ_EM_MEDICAMENTOS", sequenceName = "SQ_EM_MEDICAMENTOS", allocationSize = 1)
    @Column(name = "CODIGO_MEDICAMENTO")
    private Long codigoMedicamento;

    @Column(name = "NOME", length = 255)
    private String nome;

    @Column(name = "FABRICANTE", length = 255)
    private String fabricante;

    // CONSTRUTORES
    public Medicamento() {
    }

    public Medicamento(Long codigoMedicamento, String nome, String fabricante) {
        this.codigoMedicamento = codigoMedicamento;
        this.nome = nome;
        this.fabricante = fabricante;
    }

    // GETTERS & SETTERS
    public Long getCodigoMedicamento() {
        return codigoMedicamento;
    }

    public void setCodigoMedicamento(Long codigoMedicamento) {
        this.codigoMedicamento = codigoMedicamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    @Override
    public String toString() {
        return "Medicamento{" +
                "codigoMedicamento=" + codigoMedicamento +
                ", nome='" + nome + '\'' +
                ", fabricante='" + fabricante + '\'' +
                '}';
    }
}
