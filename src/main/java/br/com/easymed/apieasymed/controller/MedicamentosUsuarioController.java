//package br.com.easymed.apieasymed.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.web.PageableDefault;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import br.com.easymed.apieasymed.model.MedicamentosUsuarioRepository;
//import br.com.easymed.apieasymed.model.dto.DadosAtualizacaoMedicUsuario;
//import br.com.easymed.apieasymed.model.dto.DadosCadastroMedicUsuario;
//import br.com.easymed.apieasymed.model.dto.DadosListagemMedicUsuario;
//import br.com.easymed.apieasymed.model.entity.MedicamentosUsuario;
//import jakarta.transaction.Transactional;
//import jakarta.validation.Valid;
//
//@RestController
//@RequestMapping("/medusuario")
//public class MedicamentosUsuarioController
//{
//	@Autowired
//	private MedicamentosUsuarioRepository repository;
//	
//	@PostMapping
//	@Transactional
//	public void cadastrar(@RequestBody @Valid DadosCadastroMedicUsuario dados) {
//		repository.save(new MedicamentosUsuario(dados));
//	}
//	
//	@GetMapping
//	public Page<DadosListagemMedicUsuario> listar(
//			@PageableDefault(size = 3, sort = {"usuario.email"}) Pageable paginacao){
//		return repository.findAll(paginacao).map(DadosListagemMedicUsuario :: new);
//	}
//	
//	@GetMapping("/{id}")
//	public DadosListagemMedicUsuario obterPorId(@PathVariable Long id) {
//	    MedicamentosUsuario medusu = repository.findById(id).orElse(null);
//
//	    if (medusu != null) {
//	        return new DadosListagemMedicUsuario(medusu);
//	    } else {
//	        return null;
//	    }
//	}
//	
//	@PutMapping
//	@Transactional
//	public void atualizar(@RequestBody @Valid DadosAtualizacaoMedicUsuario dados) {
//		MedicamentosUsuario medusu = new MedicamentosUsuario();
//		medusu = repository.getReferenceById(dados.codigoMedicamentoUsuario());
//		medusu.atualizar(dados);
//	}
//	
//	@DeleteMapping("/{id}")
//	@Transactional
//	public void excluir(@PathVariable Long id) {
//		repository.deleteById(id);
//	}
//}
