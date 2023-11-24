package br.com.easymed.apieasymed.model;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.easymed.apieasymed.model.entity.Tratamento;

public interface TratamentoRepository extends JpaRepository<Tratamento, Long>{

}
