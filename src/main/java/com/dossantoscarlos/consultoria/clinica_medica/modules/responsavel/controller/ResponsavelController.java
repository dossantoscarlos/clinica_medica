package com.dossantoscarlos.consultoria.clinica_medica.modules.responsavel.controller;

import java.util.List;
import java.util.UUID;

import com.dossantoscarlos.consultoria.clinica_medica.modules.responsavel.model.Responsavel;
import com.dossantoscarlos.consultoria.clinica_medica.modules.responsavel.service.ResponsavelService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api/v1/responsaveis", produces = {"application/json"})
@Tag(name="Responsavel")
public class ResponsavelController {

	@Autowired
	private ResponsavelService service;
	
	@GetMapping("/")
	public List<Responsavel> findAll(){
		return this.service.repository.findAll();
	}
	
	@GetMapping("/{id}")
	public Responsavel findBy(@PathVariable UUID id){
		return this.service.find(id);
	}
	
	@PostMapping
	public Responsavel create(@Valid @RequestBody Responsavel responsavel) {
		return this.service.repository.saveAndFlush(responsavel);
	}
	
	@PutMapping("/{id}")
	public Responsavel updateAll(@Valid @RequestBody Responsavel responsavel, @PathVariable UUID id)	{
		return this.service.updateAllField(responsavel, id);
	}
	
	@DeleteMapping("/{id}")
	public String deleted(@PathVariable UUID id) {
		return this.service.delete(id);
	}
	
}
