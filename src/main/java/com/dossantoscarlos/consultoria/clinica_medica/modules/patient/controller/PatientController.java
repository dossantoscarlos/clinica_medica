package com.dossantoscarlos.consultoria.clinica_medica.modules.patient.controller;

import com.dossantoscarlos.consultoria.clinica_medica.modules.patient.dto.PatientDTO;
import com.dossantoscarlos.consultoria.clinica_medica.modules.patient.model.Patient;
import com.dossantoscarlos.consultoria.clinica_medica.modules.patient.service.PatientService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value="/api/v1/pacientes", produces = {"application/json"})
@Tag(name="Patient")
public class PatientController {

	@Autowired
	private PatientService service;

	@GetMapping
	public List<Patient> findAll() throws Exception {
		return this.service.findAll();
	}
	
	@GetMapping("/{id}")
	public Patient find(@PathVariable UUID id) throws Exception {
		return this.service.findById(id);
	}
	
	@PostMapping
	public Patient save(@RequestBody PatientDTO patientDTO) {
		return this.service.create(patientDTO);
	}

	@DeleteMapping("/{id}")
	public String delete(@PathVariable UUID id) {
		return this.service.delete(id);
	}
	
}
