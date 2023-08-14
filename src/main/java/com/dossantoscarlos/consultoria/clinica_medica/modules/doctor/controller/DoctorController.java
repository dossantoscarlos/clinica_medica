package com.dossantoscarlos.consultoria.clinica_medica.modules.doctor.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.dossantoscarlos.consultoria.clinica_medica.modules.doctor.model.Doctor;
import com.dossantoscarlos.consultoria.clinica_medica.modules.doctor.service.DoctorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
@Tag(name="Doctor")
@RequestMapping("/doctors")
public class DoctorController {
	
	@Autowired
	private DoctorService doctorService;

	@Operation(summary = "Lista todos os medicos", method = "GET")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Busca realizada com sucesso"),
			@ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
			@ApiResponse(responseCode = "400", description = "Parametros inválidos"),
			@ApiResponse(responseCode = "500", description = "Erro ao realizar busca dos dados"),
	})
	@GetMapping()
	public List<Doctor> findAll() {
		return this.doctorService.repository.findAll();
	}

	@Operation(summary = "Lista doctor especifico", method = "GET")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Busca realizada com sucesso"),
			@ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
			@ApiResponse(responseCode = "400", description = "Parametros inválidos"),
			@ApiResponse(responseCode = "500", description = "Erro ao realizar busca dos dados"),
	})
	@GetMapping("/{id}")
	public Doctor find(@PathVariable UUID id) {
		 Optional<Doctor> findExame = this.doctorService.repository.findById(id);
        return findExame.orElseThrow();
	}

	@Operation(summary = "Cadastra novo doctor", method = "POST")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Busca realizada com sucesso"),
			@ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
			@ApiResponse(responseCode = "400", description = "Parametros inválidos"),
			@ApiResponse(responseCode = "500", description = "Erro ao realizar busca dos dados"),
	})
	@PostMapping()
	public Doctor create (@Valid @RequestBody Doctor doctor) {
		return this.doctorService.repository.saveAndFlush(doctor);
	}

	@Operation(summary = "Atualiza os dados do doctor", method = "PUT")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "204", description = "Busca realizada com sucesso"),
			@ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
			@ApiResponse(responseCode = "400", description = "Parametros inválidos"),
			@ApiResponse(responseCode = "500", description = "Erro ao realizar busca dos dados"),
	})
	@PutMapping("/{id}")
	public Doctor update (@RequestBody Doctor doctor, @PathVariable UUID id) {
		return this.doctorService.update(doctor, id);
	}

	@Operation(summary = "Deleta doctor", method = "DELETE")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Busca realizada com sucesso"),
			@ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
			@ApiResponse(responseCode = "400", description = "Parametros inválidos"),
			@ApiResponse(responseCode = "500", description = "Erro ao realizar busca dos dados"),
	})
	@DeleteMapping("/{id}")
	public String delete(@PathVariable UUID id) {
		return this.doctorService.delete(id);
	}
	
}
