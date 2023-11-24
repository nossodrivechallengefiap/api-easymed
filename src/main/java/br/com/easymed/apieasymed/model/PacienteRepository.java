package br.com.easymed.apieasymed.model;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.easymed.apieasymed.model.entity.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long>{

}
