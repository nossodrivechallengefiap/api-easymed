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

import br.com.easymed.apieasymed.model.MedicamentoUsuarioIntervaloRepository;
import br.com.easymed.apieasymed.model.dto.DadosAtualizacaoMedIntervalo;
import br.com.easymed.apieasymed.model.dto.DadosCadastroMedIntervalo;
import br.com.easymed.apieasymed.model.dto.DadosListagemMedIntervalo;
import br.com.easymed.apieasymed.model.entity.MedicamentoUsuarioIntervalo;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/medintervalo")
public class MedicamentoUsuarioIntervaloController 
{
	@Autowired
	private MedicamentoUsuarioIntervaloRepository repository;
	
	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody @Valid DadosCadastroMedIntervalo dados) {
		repository.save(new MedicamentoUsuarioIntervalo(dados));
	}
	
	@GetMapping
	public Page<DadosListagemMedIntervalo> listar(
			@PageableDefault(size = 3, sort = {"medicamento.nomeMedicamento"}) Pageable paginacao){
		return repository.findAll(paginacao).map(DadosListagemMedIntervalo :: new);
	}
	
	@GetMapping("/{id}")
	public DadosListagemMedIntervalo obterPorId(@PathVariable Long id) {
	    MedicamentoUsuarioIntervalo md = repository.findById(id).orElse(null);

	    if (md != null) {
	        return new DadosListagemMedIntervalo(md);
	    } else {
	        return null;
	    }
	}
	
	@PutMapping
	@Transactional
	public void atualizar(@RequestBody @Valid DadosAtualizacaoMedIntervalo dados) {
		MedicamentoUsuarioIntervalo md = new MedicamentoUsuarioIntervalo();
		md = repository.getReferenceById(dados.id());
		md.atualizar(dados);
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public void excluir(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
