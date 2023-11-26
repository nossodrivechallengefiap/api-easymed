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

import br.com.easymed.apieasymed.model.TratamentoRepository;
import br.com.easymed.apieasymed.model.dto.atualizacao.DadosAtualizacaoTratamento;
import br.com.easymed.apieasymed.model.dto.cadastro.DadosCadastroTratamento;
import br.com.easymed.apieasymed.model.dto.listagem.DadosListagemTratamento;
import br.com.easymed.apieasymed.model.entity.Tratamento;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/tratamento")
public class TratamentoController {
	@Autowired
	private TratamentoRepository repository;
	
	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody @Valid DadosCadastroTratamento dados) {
		repository.save(new Tratamento(dados));
	}

	@GetMapping
	public Page<DadosListagemTratamento> listar(
			@PageableDefault(size = 3, sort = { "paciente.pessoaFisica.nome" }) Pageable paginacao) {
		return repository.findAll(paginacao).map(DadosListagemTratamento :: new);
	}

	@GetMapping("/{id}")
	public DadosListagemTratamento obterPorId(@PathVariable Long id) {
		Tratamento tra = repository.findById(id).orElse(null);

		if (tra != null) {
			return new DadosListagemTratamento(tra);
		} else {
			return null;
		}
	}
	
	@PutMapping("/{id}")
	@Transactional
	public void atualizar(@PathVariable Long id, @RequestBody @Valid DadosAtualizacaoTratamento dados) {
		Tratamento tra = new Tratamento();
		tra = repository.getReferenceById(id);
		tra.atualizar(dados);
	}

	@DeleteMapping("/{id}")
	@Transactional
	public void excluir(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
