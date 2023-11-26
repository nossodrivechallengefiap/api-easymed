package br.com.easymed.apieasymed.model.dto.atualizacao;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public record DadosAtualizacaoUsuario(
        @Size(max = 255)
        String senha,

        @Email
        @Size(max = 255)
        String email,

        @Valid
        DadosAtualizacaoPessoa pessoa
) {

}
