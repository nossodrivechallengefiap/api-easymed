package br.com.easymed.apieasymed.model.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "EM_TRATAMENTOS")
public class Tratamento {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_EM_TRATAMENTOS")
    @SequenceGenerator(name = "SQ_EM_TRATAMENTOS", sequenceName = "SQ_EM_TRATAMENTOS", allocationSize = 1)
    @Column(name = "CODIGO_TRATAMENTO")
    private Long codigoTratamento;

    @Column(name = "DT_INICIO")
    LocalDate inicio;

    @Column(name = "DT_FIM")
    LocalDate fim;

    @Column(name = "INTERVALO")
    int intervalo;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(
            name = "CODIGO_MEDICO",
            referencedColumnName = "CODIGO_MEDICO",
            foreignKey = @ForeignKey(name = "FK_TRATAMENTO_MEDICO")
    )
    private Medico medico;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(
            name = "CODIGO_PACIENTE",
            referencedColumnName = "CODIGO_PACIENTE",
            foreignKey = @ForeignKey(name = "FK_TRATAMENTO_PACIENTE")
    )
    private Paciente paciente;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(
            name = "CODIGO_MEDICAMENTO",
            referencedColumnName = "CODIGO_MEDICAMENTO",
            foreignKey = @ForeignKey(name = "FK_TRATAMENTO_MEDICAMENTO")
    )
    private Medicamento medicamento;


    // CONSTRUTORES
    public Tratamento() {
    }

    public Tratamento(LocalDate inicio, LocalDate fim, int intervalo) {
        this.inicio = inicio;
        this.fim = fim;
        this.intervalo = intervalo;
    }

    // GETTERS & SETTERS
    public Long getCodigoTratamento() {
        return codigoTratamento;
    }

    public void setCodigoTratamento(Long codigoTratamento) {
        this.codigoTratamento = codigoTratamento;
    }

    public LocalDate getInicio() {
        return inicio;
    }

    public void setInicio(LocalDate inicio) {
        this.inicio = inicio;
    }

    public LocalDate getFim() {
        return fim;
    }

    public void setFim(LocalDate fim) {
        this.fim = fim;
    }

    public int getIntervalo() {
        return intervalo;
    }

    public void setIntervalo(int intervalo) {
        this.intervalo = intervalo;
    }

    // TO STRING

    @Override
    public String toString() {
        return "Tratamento{" +
                "codigoTratamento=" + codigoTratamento +
                ", inicio=" + inicio +
                ", fim=" + fim +
                ", intervalo=" + intervalo +
                ", medico=" + medico +
                ", paciente=" + paciente +
                ", medicamento=" + medicamento +
                '}';
    }
}
