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
import br.com.easymed.apieasymed.model.dto.DadosAtualizacaoPFisica;
import br.com.easymed.apieasymed.model.dto.DadosCadastroPFisica;
import br.com.easymed.apieasymed.model.dto.DadosListagemPFisica;
import br.com.easymed.apieasymed.model.entity.PessoaFisica;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuario/pf")
public class PessoaFisicaController {
	@Autowired
	private PessoaFisicaRepository repository;
	
	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody @Valid DadosCadastroPFisica dados) {
		repository.save(new PessoaFisica(dados));
	}
	
	@GetMapping
	public Page<DadosListagemPFisica> listar(
			@PageableDefault(size = 3, sort = {"nome"}) Pageable paginacao){
		return repository.findAll(paginacao).map(DadosListagemPFisica :: new);
	}
	
	@GetMapping("/{id}")
	public DadosListagemPFisica obterPorId(@PathVariable Long id) {
	    PessoaFisica pf = repository.findById(id).orElse(null);

	    if (pf != null) {
	        return new DadosListagemPFisica(pf);
	    } else {
	        return null;
	    }
	}
	
	@PutMapping
	@Transactional
	public void atualizar(@RequestBody @Valid DadosAtualizacaoPFisica dados) {
		PessoaFisica pf = new PessoaFisica();
		pf = repository.getReferenceById(dados.codigoUsuario());
		pf.atualizar(dados);
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public void excluir(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
