package br.com.easymed.apieasymed.model;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.easymed.apieasymed.model.entity.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

}
