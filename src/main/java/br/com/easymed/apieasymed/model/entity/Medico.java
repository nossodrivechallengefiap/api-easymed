package br.com.easymed.apieasymed.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "EM_MEDICOS", uniqueConstraints = {
    @UniqueConstraint(columnNames = "CRM", name = "UK_EM_MEDICO_CRM")
})
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_EM_MEDICOS")
    @SequenceGenerator(name = "SQ_EM_MEDICOS", sequenceName = "SQ_EM_MEDICOS", allocationSize = 1)
    @Column(name = "CODIGO_MEDICO")
    private Long codigoMedico;

    @Column(name = "CRM", length = 255)
    private String crm;

    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(
            name = "CODIGO_PESSOA",
            referencedColumnName = "CODIGO_PESSOA",
            foreignKey = @ForeignKey(name = "FK_MEDICO_PESSOA")
    )
    private Pessoa pessoa;

    // CONSTRUTORES
    public Medico() {
    }

    public Medico(String crm) {
        this.crm = crm;
    }

    // GETTERS & SETTERS
    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    // TO STRING
    @Override
    public String toString() {
        return "Medico [codigoMedico=" + codigoMedico + ", crm=" + crm + "]" + super.toString();
    }
}
