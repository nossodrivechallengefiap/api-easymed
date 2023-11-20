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

import br.com.easymed.apieasymed.model.TipoUsuarioRepository;
import br.com.easymed.apieasymed.model.dto.DadosAtualizacaoTpUsuario;
import br.com.easymed.apieasymed.model.dto.DadosCadastroTpUsuario;
import br.com.easymed.apieasymed.model.dto.DadosListagemTpUsuario;
import br.com.easymed.apieasymed.model.entity.TipoUsuario;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/tpusuario")
public class TipoUsuarioController {
	@Autowired
	private TipoUsuarioRepository repository;
	
	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody @Valid DadosCadastroTpUsuario dados) {
		repository.save(new TipoUsuario(dados));
	}
	
	@GetMapping
	public Page<DadosListagemTpUsuario> listar(
			@PageableDefault(size = 3, sort = {"usuario.email"}) Pageable paginacao){
		return repository.findAll(paginacao).map(DadosListagemTpUsuario :: new);
	}
	
	@GetMapping("/{id}")
	public DadosListagemTpUsuario obterPorId(@PathVariable Long id) {
	    TipoUsuario tp = repository.findById(id).orElse(null);

	    if (tp != null) {
	        return new DadosListagemTpUsuario(tp);
	    } else {
	        return null;
	    }
	}
	
	@PutMapping
	@Transactional
	public void atualizar(@RequestBody @Valid DadosAtualizacaoTpUsuario dados) {
		TipoUsuario tp = new TipoUsuario();
		tp = repository.getReferenceById(dados.codigoTipoUsuario());
		tp.atualizar(dados);
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public void excluir(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
