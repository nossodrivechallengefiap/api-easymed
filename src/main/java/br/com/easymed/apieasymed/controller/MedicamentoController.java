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

import br.com.easymed.apieasymed.model.MedicamentoRepository;
import br.com.easymed.apieasymed.model.dto.DadosAtualizacaoMedicamento;
import br.com.easymed.apieasymed.model.dto.DadosCadastroMedicamento;
import br.com.easymed.apieasymed.model.dto.DadosListagemMedicamento;
import br.com.easymed.apieasymed.model.entity.Medicamento;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/medicamento")
public class MedicamentoController 
{
	@Autowired
	private MedicamentoRepository repository;
	
	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody @Valid DadosCadastroMedicamento dados) {
		repository.save(new Medicamento(dados));
	}
	
	@GetMapping
	public Page<DadosListagemMedicamento> listar(
			@PageableDefault(size = 3, sort = {"nomeMedicamento"}) Pageable paginacao){
		return repository.findAll(paginacao).map(DadosListagemMedicamento :: new);
	}
	
	@GetMapping("/{id}")
	public DadosListagemMedicamento obterPorId(@PathVariable Long id) {
	    Medicamento md = repository.findById(id).orElse(null);

	    if (md != null) {
	        return new DadosListagemMedicamento(md);
	    } else {
	        return null;
	    }
	}
	
	@PutMapping
	@Transactional
	public void atualizar(@RequestBody @Valid DadosAtualizacaoMedicamento dados) {
		Medicamento md = new Medicamento();
		md = repository.getReferenceById(dados.codigoMedicamento());
		md.atualizar(dados);
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public void excluir(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
