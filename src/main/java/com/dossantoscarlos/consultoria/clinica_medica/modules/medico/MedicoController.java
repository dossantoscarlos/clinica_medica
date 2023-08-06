package com.dossantoscarlos.consultoria.clinica_medica.modules.medico;

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

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/clinica/medico")
public class MedicoController {
	
	@Autowired
	private MedicoService medicoService;
	
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public List<MedicoModel> findAll() {
		return this.medicoService.repository.findAll();
	}

	@GetMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public MedicoModel find(@PathVariable UUID id) {
		 Optional<MedicoModel> findExame = this.medicoService.repository.findById(id);
		 MedicoModel medico = findExame.orElseThrow();
		 return medico;
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public MedicoModel create (@Valid @RequestBody MedicoModel medico) {
		return this.medicoService.repository.saveAndFlush(medico);
	}

	@PutMapping("/{id}")
	@ResponseStatus(code=HttpStatus.NO_CONTENT)
	public MedicoModel update (@RequestBody MedicoModel medico, @PathVariable UUID id) {
		return this.medicoService.update( medico, id);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public String delete(@PathVariable UUID id) {	
		return this.medicoService.deleteMedico(id);
	}
	
}
