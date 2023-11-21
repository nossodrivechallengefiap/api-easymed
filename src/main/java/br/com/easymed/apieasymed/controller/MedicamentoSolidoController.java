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

import br.com.easymed.apieasymed.model.MedicamentoSolidoRepository;
import br.com.easymed.apieasymed.model.dto.DadosAtualizacaoMedSolido;
import br.com.easymed.apieasymed.model.dto.DadosCadastroMedSolido;
import br.com.easymed.apieasymed.model.dto.DadosListagemMedSolido;
import br.com.easymed.apieasymed.model.entity.MedicamentoSolido;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/medicamento/solido")
public class MedicamentoSolidoController 
{
	@Autowired
	private MedicamentoSolidoRepository repository;
	
	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody @Valid DadosCadastroMedSolido dados) {
		repository.save(new MedicamentoSolido(dados));
	}
	
	@GetMapping
	public Page<DadosListagemMedSolido> listar(
			@PageableDefault(size = 3, sort = {"nomeMedicamento"}) Pageable paginacao){
		return repository.findAll(paginacao).map(DadosListagemMedSolido :: new);
	}
	
	@GetMapping("/{id}")
	public DadosListagemMedSolido obterPorId(@PathVariable Long id) {
	    MedicamentoSolido mds = repository.findById(id).orElse(null);

	    if (mds != null) {
	        return new DadosListagemMedSolido(mds);
	    } else {
	        return null;
	    }
	}
	
	@PutMapping
	@Transactional
	public void atualizar(@RequestBody @Valid DadosAtualizacaoMedSolido dados) {
		MedicamentoSolido mds = new MedicamentoSolido();
		mds = repository.getReferenceById(dados.codigoMedicamento());
		mds.atualizar(dados);
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public void excluir(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
