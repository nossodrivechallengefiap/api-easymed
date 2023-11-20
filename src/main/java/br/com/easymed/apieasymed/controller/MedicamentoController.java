package br.com.easymed.apieasymed.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.easymed.apieasymed.model.MedicamentoRepository;

@RestController
@RequestMapping("/medicamento")
public class MedicamentoController 
{
	@Autowired
	private MedicamentoRepository repository;
	
}
