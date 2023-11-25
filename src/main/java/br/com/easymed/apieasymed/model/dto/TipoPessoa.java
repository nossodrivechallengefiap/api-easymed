package br.com.easymed.apieasymed.model.dto;

public enum TipoPessoa {

    PF( "PF", "Pessoa Física" ),
    PJ( "PJ", "Pessoa Jurídica" );

    private String sigla;

    private String nome;

    TipoPessoa(String sigla, String nome) {
        this.sigla = sigla;
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return sigla.toUpperCase();
    }
}