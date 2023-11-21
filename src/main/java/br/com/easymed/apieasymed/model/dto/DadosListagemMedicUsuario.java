//package br.com.easymed.apieasymed.model.dto;
//
//import java.util.Set;
//import java.util.stream.Collectors;
//
//import br.com.easymed.apieasymed.model.entity.Medicamento;
//import br.com.easymed.apieasymed.model.entity.MedicamentosUsuario;
//
//public record DadosListagemMedicUsuario(Long codigoMedicamentoUsuario, String email, String senha, Set<String> nomeMedicamentos) {
//	public DadosListagemMedicUsuario(MedicamentosUsuario med) {
//        this(
//        		med.getCodigoMedicamentoUsuario(),
//                med.getUsuario().getEmail(),
//                med.getUsuario().getSenha(),
//                med.getMedicamento().stream()
//                        .map(Medicamento::getNomeMedicamento)
//                        .collect(Collectors.toSet())
//        );
//    }
//}
