package com.dossantoscarlos.consultoria.clinica_medica.modules.exams.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;

public record ExamDTO(
	@NotBlank()
	@JsonProperty(value="nome")
	String nome,

	@NotBlank
	@JsonProperty(value = "descricao curta")
	String descricaoCurta,

	@NotBlank
	@JsonProperty(value = "descricao longa")
	String descricaoLonga
){}

