package br.com.easymed.apieasymed.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.easymed.apieasymed.model.PessoaRepository;
import br.com.easymed.apieasymed.model.UsuarioRepository;
import br.com.easymed.apieasymed.model.dto.TipoPessoa;
import br.com.easymed.apieasymed.model.dto.atualizacao.DadosAtualizacaoUsuario;
import br.com.easymed.apieasymed.model.dto.cadastro.DadosCadastroUsuario;
import br.com.easymed.apieasymed.model.dto.listagem.DadosListagemUsuario;
import br.com.easymed.apieasymed.model.entity.Pessoa;
import br.com.easymed.apieasymed.model.entity.PessoaFisica;
import br.com.easymed.apieasymed.model.entity.PessoaJuridica;
import br.com.easymed.apieasymed.model.entity.Usuario;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository repository;
	
	@Autowired
    private PessoaRepository pessoaRepository;

	
	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody @Valid DadosCadastroUsuario dados) {
	    Pessoa novaPessoa;

	    if (dados.pessoa().tipo() == TipoPessoa.PF) {
	        novaPessoa = new PessoaFisica(dados.pessoa());
	    } else if (dados.pessoa().tipo() == TipoPessoa.PJ) {
	        novaPessoa = new PessoaJuridica(dados.pessoa());
	    } else {
	        return;
	    }

	    Usuario novoUsuario = new Usuario(dados);
	    novoUsuario.setPessoa(novaPessoa);

	    pessoaRepository.save(novaPessoa);
	    repository.save(novoUsuario);
	}


	@GetMapping
	public Page<DadosListagemUsuario> listar(
			@PageableDefault(size = 3, sort = { "email" }) Pageable paginacao) {
		return repository.findAll(paginacao).map(DadosListagemUsuario :: new);
	}
	

	@GetMapping("/{id}")
	public DadosListagemUsuario obterPorId(@PathVariable Long id) {
		Usuario usuario = repository.findById(id).orElse(null);

		if (usuario != null) {
			return new DadosListagemUsuario(usuario);
		} else {
			return null;
		}
	}
	
	@PutMapping("/{id}")
	@Transactional
	public void atualizar(@PathVariable Long id, @RequestBody @Valid DadosAtualizacaoUsuario dados) {
	    Optional<Usuario> optionalUsuario = repository.findById(id);

	    if (optionalUsuario.isPresent()) {
	        Usuario usuario = optionalUsuario.get();
	        usuario.atualizar(dados);

	        if (usuario.getPessoa() instanceof PessoaFisica) {
	            ((PessoaFisica) usuario.getPessoa()).atualizar(dados.pessoa());
	        } else if (usuario.getPessoa() instanceof PessoaJuridica) {
	            ((PessoaJuridica) usuario.getPessoa()).atualizar(dados.pessoa());
	        }

	        repository.save(usuario);
	    }
	}

	@DeleteMapping("/{id}")
	@Transactional
	public void excluir(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
