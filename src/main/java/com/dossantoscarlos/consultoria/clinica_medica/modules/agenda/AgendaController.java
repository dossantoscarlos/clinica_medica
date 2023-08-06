package com.dossantoscarlos.consultoria.clinica_medica.modules.agenda;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/clinica/agenda")
public class AgendaController {

	@Autowired
	AgendaService service;
	
	
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public List<AgendaModel> findAllAgenda() {
		return this.service.repository.findAll(); 
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED )
	public AgendaModel create(@Valid @RequestBody AgendaModel agenda ) {
		return this.service.repository.saveAndFlush(agenda);
	}
	
}
