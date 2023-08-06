package com.dossantoscarlos.consultoria.clinica_medica.modules.exame;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dossantoscarlos.consultoria.clinica_medica.dto.exame.ExameDTO;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/clinica/exame")
public class ExameController {
		
	@Autowired
	private ExameService service;
	
	@GetMapping
    @ResponseStatus(code = HttpStatus.OK)
	public List<ExameModel> findAllExame() {
		return this.service.repository.findAll();
	}
	
	@GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
	public ExameModel findByIdExame(@PathVariable UUID id) {
		Optional<ExameModel> find = this.service.repository.findById(id);
		ExameModel exame = find.orElseThrow();
		return exame;
	}
	
	@PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)  
	public ExameModel createExame(@RequestBody @Valid ExameDTO exameDTO){
		var exame = new ExameModel();
		exame.setNome(exameDTO.nome());
		exame.setDescricaoCurta(exameDTO.descricaoCurta());
		exame.setDescricaoLonga(exameDTO.descricaoLonga());
		return this.service.repository.saveAndFlush(exame); 
	}

	@PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
	public ExameModel updateExame(@RequestBody @Valid ExameModel exame, @PathVariable UUID id) {
		return this.service.update(exame,id);
	}
	
	@DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
	public String deleteExame(@PathVariable UUID id) {
		return this.service.delete(id);
	}
	
}