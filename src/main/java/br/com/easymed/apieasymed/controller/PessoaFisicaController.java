package br.com.easymed.apieasymed.controller;

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

import br.com.easymed.apieasymed.model.PessoaFisicaRepository;
import br.com.easymed.apieasymed.model.dto.atualizacao.DadosAtualizacaoPessoaFisica;
import br.com.easymed.apieasymed.model.dto.cadastro.DadosCadastroPessoaFisica;
import br.com.easymed.apieasymed.model.dto.listagem.DadosListagemPessoaFisica;
import br.com.easymed.apieasymed.model.entity.PessoaFisica;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/pessoa/pf")
public class PessoaFisicaController {
	
	@Autowired
	private PessoaFisicaRepository repository;
	
	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody @Valid DadosCadastroPessoaFisica dados) {
		repository.save(new PessoaFisica(dados));
	}

	@GetMapping
	public Page<DadosListagemPessoaFisica> listar(
			@PageableDefault(size = 3, sort = { "nome" }) Pageable paginacao) {
		return repository.findAll(paginacao).map(DadosListagemPessoaFisica :: new);
	}

	@GetMapping("/{id}")
	public DadosListagemPessoaFisica obterPorId(@PathVariable Long id) {
		PessoaFisica pf = repository.findById(id).orElse(null);

		if (pf != null) {
			return new DadosListagemPessoaFisica(pf);
		} else {
			return null;
		}
	}
	
	@PutMapping("/{id}")
	@Transactional
	public void atualizar(@PathVariable Long id, @RequestBody @Valid DadosAtualizacaoPessoaFisica dados) {
		PessoaFisica pf = new PessoaFisica();
		pf = repository.getReferenceById(id);
		pf.atualizar(dados);
	}

	@DeleteMapping("/{id}")
	@Transactional
	public void excluir(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
