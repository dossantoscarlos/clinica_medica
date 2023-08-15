package com.dossantoscarlos.consultoria.clinica_medica.modules.exams.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.dossantoscarlos.consultoria.clinica_medica.modules.exams.dto.ExamDTO;
import com.dossantoscarlos.consultoria.clinica_medica.modules.exams.dto.ExamUpdateDTO;
import com.dossantoscarlos.consultoria.clinica_medica.modules.exams.model.Exam;
import com.dossantoscarlos.consultoria.clinica_medica.modules.exams.service.ExamService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api/v1/exames", produces = {"application/json"})
@Tag(name = "Exam")
public class ExamController {
		
	@Autowired
	private ExamService service;

	@Operation(summary = "Busca dados de profissionais por idade e cargo exercido", method = "GET")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Busca realizada com sucesso"),
			@ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
			@ApiResponse(responseCode = "400", description = "Parametros inválidos"),
			@ApiResponse(responseCode = "500", description = "Erro ao realizar busca dos dados"),
	})
	@GetMapping()
	public List<Exam> findAllExame() {
		return this.service.findAll();
	}
	
	@GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
	public Exam findByIdExame(@PathVariable UUID id) {
		return this.service.findById(id);
	}
	
	@PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)  
	public Exam createExame(@RequestBody @Valid ExamDTO examDTO){
		return this.service.save(examDTO);
	}

	@PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
	public Exam updateExame(@RequestBody @Valid ExamUpdateDTO exameDTO, @PathVariable UUID id) {
		return this.service.update(exameDTO,id);
	}
	
	@DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
	public String deleteExame(@PathVariable("id") UUID id) {
		return this.service.delete(id);
	}
	
}