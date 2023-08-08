package com.dossantoscarlos.consultoria.clinica_medica.modules.medico;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@RequestMapping(value="/medicos", produces = {"application/json"})
@Tag(name="Medico")
public class MedicoController {
	
	@Autowired
	private MedicoService medicoService;

	@Operation(summary = "Lista todos os medicos", method = "GET")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Busca realizada com sucesso"),
			@ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
			@ApiResponse(responseCode = "400", description = "Parametros inválidos"),
			@ApiResponse(responseCode = "500", description = "Erro ao realizar busca dos dados"),
	})
	@GetMapping()
	@ResponseStatus(code = HttpStatus.OK)
	public List<Medico> findAll() {
		return this.medicoService.repository.findAll();
	}

	@Operation(summary = "Lista medico especifico", method = "GET")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Busca realizada com sucesso"),
			@ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
			@ApiResponse(responseCode = "400", description = "Parametros inválidos"),
			@ApiResponse(responseCode = "500", description = "Erro ao realizar busca dos dados"),
	})
	@GetMapping("/{id}")
	public Medico find(@PathVariable UUID id) {
		 Optional<Medico> findExame = this.medicoService.repository.findById(id);
		 Medico medico = findExame.orElseThrow();
		 return medico;
	}

	@Operation(summary = "Cadastra novo medico", method = "GET")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Busca realizada com sucesso"),
			@ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
			@ApiResponse(responseCode = "400", description = "Parametros inválidos"),
			@ApiResponse(responseCode = "500", description = "Erro ao realizar busca dos dados"),
	})
	@PostMapping()
	public Medico create (@Valid @RequestBody Medico medico) {
		return this.medicoService.repository.saveAndFlush(medico);
	}

	@Operation(summary = "Atualiza os dados do medico", method = "GET")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "204", description = "Busca realizada com sucesso"),
			@ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
			@ApiResponse(responseCode = "400", description = "Parametros inválidos"),
			@ApiResponse(responseCode = "500", description = "Erro ao realizar busca dos dados"),
	})
	@PutMapping("/{id}")
	public Medico update (@RequestBody Medico medico, @PathVariable UUID id) {
		return this.medicoService.update( medico, id);
	}

	@Operation(summary = "Deleta medico", method = "GET")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Busca realizada com sucesso"),
			@ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
			@ApiResponse(responseCode = "400", description = "Parametros inválidos"),
			@ApiResponse(responseCode = "500", description = "Erro ao realizar busca dos dados"),
	})
	@DeleteMapping("/{id}")
	public String delete(@PathVariable UUID id) {
		return this.medicoService.deleteMedico(id);
	}
	
}
