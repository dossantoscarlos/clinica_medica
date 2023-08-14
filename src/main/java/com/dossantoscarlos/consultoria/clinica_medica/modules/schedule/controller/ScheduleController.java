package com.dossantoscarlos.consultoria.clinica_medica.modules.schedule.controller;

import java.util.List;

import com.dossantoscarlos.consultoria.clinica_medica.modules.schedule.model.Schedule;
import com.dossantoscarlos.consultoria.clinica_medica.modules.schedule.service.ScheduleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value="/schedules", produces = {"application/json"})
@Tag(name = "Schedule")
public class ScheduleController {

	@Autowired
	private ScheduleService service;

	@GetMapping("/")
	@Operation(summary = "Busca dados de profissionais por idade e cargo exercido", method = "GET")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Busca realizada com sucesso"),
			@ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
			@ApiResponse(responseCode = "400", description = "Parametros inválidos"),
			@ApiResponse(responseCode = "500", description = "Erro ao realizar busca dos dados"),
	})
	public List<Schedule> findAllAgenda() {
		return this.service.repository.findAll();
	}

	@PostMapping
	@Operation(summary = "Busca dados de profissionais por idade e cargo exercido", method = "POST")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Busca realizada com sucesso"),
			@ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
			@ApiResponse(responseCode = "400", description = "Parametros inválidos"),
			@ApiResponse(responseCode = "500", description = "Erro ao realizar busca dos dados"),
	})
	public Schedule create(@Valid @RequestBody Schedule schedule ) {
		return this.service.repository.saveAndFlush(schedule);
	}


}
