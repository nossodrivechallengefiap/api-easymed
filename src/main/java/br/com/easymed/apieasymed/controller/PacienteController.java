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

import br.com.easymed.apieasymed.model.PacienteRepository;
import br.com.easymed.apieasymed.model.dto.atualizacao.DadosAtualizacaoPaciente;
import br.com.easymed.apieasymed.model.dto.cadastro.DadosCadastroPaciente;
import br.com.easymed.apieasymed.model.dto.listagem.DadosListagemPaciente;
import br.com.easymed.apieasymed.model.entity.Paciente;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/paciente")
public class PacienteController 
{
	@Autowired
	private PacienteRepository repository;
	
	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody @Valid DadosCadastroPaciente dados) {
		repository.save(new Paciente(dados));
	}

	@GetMapping
	public Page<DadosListagemPaciente> listar(
			@PageableDefault(size = 3, sort = { "altura" }) Pageable paginacao) {
		return repository.findAll(paginacao).map(DadosListagemPaciente :: new);
	}

	@GetMapping("/{id}")
	public DadosListagemPaciente obterPorId(@PathVariable Long id) {
		Paciente pa = repository.findById(id).orElse(null);

		if (pa != null) {
			return new DadosListagemPaciente(pa);
		} else {
			return null;
		}
	}
	
	@PutMapping("/{id}")
	@Transactional
	public void atualizar(@PathVariable Long id, @RequestBody @Valid DadosAtualizacaoPaciente dados) {
		Paciente pa = new Paciente();
		pa = repository.getReferenceById(id);
		pa.atualizar(dados);
	}

	@DeleteMapping("/{id}")
	@Transactional
	public void excluir(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
