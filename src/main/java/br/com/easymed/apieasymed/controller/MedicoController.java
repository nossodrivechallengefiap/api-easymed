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

import br.com.easymed.apieasymed.model.MedicoRepository;
import br.com.easymed.apieasymed.model.dto.atualizacao.DadosAtualizacaoMedico;
import br.com.easymed.apieasymed.model.dto.cadastro.DadosCadastroMedico;
import br.com.easymed.apieasymed.model.dto.listagem.DadosListagemMedico;
import br.com.easymed.apieasymed.model.entity.Medico;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/medico")
public class MedicoController 
{
	@Autowired
	private MedicoRepository repository;
	
	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados) {
		repository.save(new Medico(dados));
	}

	@GetMapping
	public Page<DadosListagemMedico> listar(
			@PageableDefault(size = 3, sort = { "pessoaFisica.nome" }) Pageable paginacao) {
		return repository.findAll(paginacao).map(DadosListagemMedico :: new);
	}

	@GetMapping("/{id}")
	public DadosListagemMedico obterPorId(@PathVariable Long id) {
		Medico medi = repository.findById(id).orElse(null);

		if (medi != null) {
			return new DadosListagemMedico(medi);
		} else {
			return null;
		}
	}
	
	@PutMapping("/{id}")
	@Transactional
	public void atualizar(@PathVariable Long id, @RequestBody @Valid DadosAtualizacaoMedico dados) {
		Medico medi = new Medico();
		medi = repository.getReferenceById(id);
		medi.atualizar(dados);
	}

	@DeleteMapping("/{id}")
	@Transactional
	public void excluir(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
