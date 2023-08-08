package com.dossantoscarlos.consultoria.clinica_medica.modules.agenda;

import java.util.List;

import io.swagger.v3.oas.annotations.tags.Tag;
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
@RequestMapping(value="/agendas", produces = {"application/json"})
@Tag(name="Agenda")
public class AgendaController {

	@Autowired
	AgendaService service;

	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public List<Agenda> findAllAgenda() {
		return service.repository.findAll();
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED )
	public Agenda create(@Valid @RequestBody Agenda agenda ) {
		return service.repository.saveAndFlush(agenda);
	}
	
}
