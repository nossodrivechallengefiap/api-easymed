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

import br.com.easymed.apieasymed.model.PessoaJuridicaRepository;
import br.com.easymed.apieasymed.model.dto.DadosAtualizacaoPJuridica;
import br.com.easymed.apieasymed.model.dto.DadosCadastroPJuridica;
import br.com.easymed.apieasymed.model.dto.DadosListagemPJuridica;
import br.com.easymed.apieasymed.model.entity.PessoaJuridica;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuario/pj")
public class PessoaJuridicaController {
	@Autowired
	private PessoaJuridicaRepository repository;
	
	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody @Valid DadosCadastroPJuridica dados) {
		repository.save(new PessoaJuridica(dados));
	}
	
	@GetMapping
	public Page<DadosListagemPJuridica> listar(
			@PageableDefault(size = 3, sort = {"razaoSocial"}) Pageable paginacao){
		return repository.findAll(paginacao).map(DadosListagemPJuridica :: new);
	}
	
	@GetMapping("/{id}")
	public DadosListagemPJuridica obterPorId(@PathVariable Long id) {
	    PessoaJuridica pj = repository.findById(id).orElse(null);

	    if (pj != null) {
	        return new DadosListagemPJuridica(pj);
	    } else {
	        return null;
	    }
	}
	
	@PutMapping
	@Transactional
	public void atualizar(@RequestBody @Valid DadosAtualizacaoPJuridica dados) {
		PessoaJuridica pj = new PessoaJuridica();
		pj = repository.getReferenceById(dados.codigoUsuario());
		pj.atualizar(dados);
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public void excluir(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
