package com.dossantoscarlos.consultoria.clinica_medica.modules.exame;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@RequestMapping(value = "/exames", produces = {"application/json"})
@Tag(name = "Exame")
public class ExameController {
		
	@Autowired
	private ExameService service;

	@Operation(summary = "Busca dados de profissionais por idade e cargo exercido", method = "GET")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Busca realizada com sucesso"),
			@ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
			@ApiResponse(responseCode = "400", description = "Parametros inválidos"),
			@ApiResponse(responseCode = "500", description = "Erro ao realizar busca dos dados"),
	})
	@GetMapping()
	public List<Exame> findAllExame() {
		return this.service.repository.findAll();
	}
	
	@GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
	public Exame findByIdExame(@PathVariable("id") String  id) {
		UUID uuid = UUID.fromString(id);
		Optional<Exame> find = this.service.repository.findById(uuid);
		return find.orElseThrow();
	}
	
	@PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)  
	public Exame createExame(@RequestBody @Valid ExameDTO exameDTO){
		var exame = new Exame();
		exame.setNome(exameDTO.nome());
		exame.setDescricaoCurta(exameDTO.descricaoCurta());
		exame.setDescricaoLonga(exameDTO.descricaoLonga());
		return this.service.repository.saveAndFlush(exame); 
	}

	@PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
	public Exame updateExame(@RequestBody @Valid Exame exame, @PathVariable UUID id) {
		return this.service.update(exame,id);
	}
	
	@DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
	public String deleteExame(@PathVariable UUID id) {
		return this.service.delete(id);
	}
	
}