package br.com.easymed.apieasymed.model;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.easymed.apieasymed.model.entity.MedicamentosUsuario;

public interface MedicamentosUsuarioRepository extends JpaRepository<MedicamentosUsuario, Long>{

}
