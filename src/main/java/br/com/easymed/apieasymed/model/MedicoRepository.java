package br.com.easymed.apieasymed.model;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.easymed.apieasymed.model.entity.Medico;

public interface MedicoRepository extends JpaRepository<Medico, Long>{

}
