//package br.com.easymed.apieasymed.model.dto.cadastro;
//
//import jakarta.validation.Valid;
//import jakarta.validation.constraints.Email;
//import jakarta.validation.constraints.NotBlank;
//import jakarta.validation.constraints.NotNull;
//import jakarta.validation.constraints.Size;
//
//public record DadosCadastroUsuario(
//		@NotBlank
//		@Size(max = 255)
//		String senha,
//		
//		@NotBlank
//		@Email
//		@Size(max = 255)
//		String email,
//		
//		@Valid
//		@NotNull
//		DadosCadastroPessoa pessoa
//		) {
//
//}

package br.com.easymed.apieasymed.model.dto.cadastro;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record DadosCadastroUsuario(
        @NotBlank
        @Size(max = 255)
        String senha,

        @NotBlank
        @Email
        @Size(max = 255)
        String email,

        @Valid
        @NotNull
        DadosCadastroPessoa pessoa
) {

}
