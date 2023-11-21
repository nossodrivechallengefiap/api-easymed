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

import br.com.easymed.apieasymed.model.MedicamentoLiquidoRepository;
import br.com.easymed.apieasymed.model.dto.DadosAtualizacaoMedLiquido;
import br.com.easymed.apieasymed.model.dto.DadosCadastroMedLiquido;
import br.com.easymed.apieasymed.model.dto.DadosListagemMedLiquido;
import br.com.easymed.apieasymed.model.entity.MedicamentoLiquido;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/medicamento/liquido")
public class MedicamentoLiquidoController 
{
	@Autowired
	private MedicamentoLiquidoRepository repository;
	
	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody @Valid DadosCadastroMedLiquido dados) {
		repository.save(new MedicamentoLiquido(dados));
	}
	
	@GetMapping
	public Page<DadosListagemMedLiquido> listar(
			@PageableDefault(size = 3, sort = {"nomeMedicamento"}) Pageable paginacao){
		return repository.findAll(paginacao).map(DadosListagemMedLiquido :: new);
	}
	
	@GetMapping("/{id}")
	public DadosListagemMedLiquido obterPorId(@PathVariable Long id) {
	    MedicamentoLiquido mdl = repository.findById(id).orElse(null);

	    if (mdl != null) {
	        return new DadosListagemMedLiquido(mdl);
	    } else {
	        return null;
	    }
	}
	
	@PutMapping
	@Transactional
	public void atualizar(@RequestBody @Valid DadosAtualizacaoMedLiquido dados) {
		MedicamentoLiquido mdl = new MedicamentoLiquido();
		mdl = repository.getReferenceById(dados.codigoMedicamento());
		mdl.atualizar(dados);
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public void excluir(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
