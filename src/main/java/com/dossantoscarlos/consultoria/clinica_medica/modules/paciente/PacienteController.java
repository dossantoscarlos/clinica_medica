package com.dossantoscarlos.consultoria.clinica_medica.modules.paciente;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/clinica/paciente")
public class PacienteController {
	
	@GetMapping
	public String findAll() {
		return "paciente all";
	}
	
	@GetMapping("/{id}")
	public String find(@PathVariable String id) {
		return "paciente".concat(id);
	}
	
	@PostMapping
	public String save(@RequestBody PacienteModel paciente ) {
		return " paciente Save";
	}

	@DeleteMapping("/{id}")
	public String delete(@PathVariable String id) {
		return  "paciennte ".concat(id);
	}
	
}
