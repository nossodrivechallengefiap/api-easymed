package br.com.easymed.apieasymed.model.dto.listagem;

import java.time.LocalDate;

import br.com.easymed.apieasymed.model.entity.Pessoa;
import br.com.easymed.apieasymed.model.entity.PessoaFisica;
import br.com.easymed.apieasymed.model.entity.PessoaJuridica;
import br.com.easymed.apieasymed.model.entity.Usuario;

public record DadosListagemUsuario(
		Long codigoUsuario,
		String email,
		String senha,
		String cpfOuCnpj,
		String nome,
		LocalDate nascimento
		) {
	
    public DadosListagemUsuario(Usuario usuario) {
        this(usuario.getCodigoUsuario(), usuario.getEmail(), usuario.getSenha(), getFormattedCpfOuCnpj(usuario.getPessoa()), usuario.getPessoa().getNome(), usuario.getPessoa().getNascimento());
    }

    private static String getFormattedCpfOuCnpj(Pessoa pessoa) {
        if (pessoa instanceof PessoaFisica) {
            return ((PessoaFisica) pessoa).getCpf();
        } else if (pessoa instanceof PessoaJuridica) {
            return ((PessoaJuridica) pessoa).getCnpj();
        } else {
            return null;
        }
    }
}