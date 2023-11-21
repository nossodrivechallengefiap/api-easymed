package br.com.easymed.apieasymed.model.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoMedicUsuario(
        @NotNull 
        Long codigoMedicamentoUsuario,
        
        @Valid 
        DadosAtualizacaoUsuarioSemPk usuario,
        
        @Valid 
        DadosCadastroMedicamento medicamento) {

    
}
