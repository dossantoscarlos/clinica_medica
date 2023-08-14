package com.dossantoscarlos.consultoria.clinica_medica.modules.paciente.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;

public record PacienteDTO(
		@NotBlank @JsonProperty(value = "nome") String nome,
		@NotBlank @JsonProperty(value = "Data nascimento") Date dataNascimento,
		@NotBlank @JsonProperty(value = "RG") String rg,
		@NotBlank @JsonProperty(value = "CPF") String cpf,
		@NotBlank @JsonProperty(value = "sexo") String sexoBiologico
) {}
