package com.dossantoscarlos.consultoria.clinica_medica.modules.responsavel;

import java.util.List;
import java.util.UUID;

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
@RequestMapping
public class ResponsavelController {

	@Autowired
	private ResponsavelService service;
	
	@GetMapping
	public List<ResponsavelModel> findAll(){
		return this.service.repository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponsavelModel findBy(@PathVariable UUID id){
		return this.service.find(id);
	}
	
	@PostMapping
	public ResponsavelModel create(@Valid @RequestBody ResponsavelModel responsavel) {
		return this.service.repository.saveAndFlush(responsavel);
	}
	
	@PutMapping("/{id}")
	public ResponsavelModel updateAll(@Valid @RequestBody ResponsavelModel responsavel, @PathVariable UUID id)	{
		return this.service.updateAllField(responsavel, id);
	}
	
	@DeleteMapping("/{id}")
	public String deleted(@PathVariable UUID id) {
		return this.service.delete(id);
	}
	
}
