package br.com.easymed.apieasymed.model;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.easymed.apieasymed.model.entity.Medicamento;

public interface MedicamentoRepository extends JpaRepository<Medicamento, Long>{

}
