package com.dossantoscarlos.consultoria.clinica_medica.modules.patient.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;

public record PatientDTO(
		@NotBlank @JsonProperty(value = "nome") String nome,
		@NotBlank @JsonProperty(value = "Data nascimento") Date dataNascimento,
		@NotBlank @JsonProperty(value = "RG") String rg,
		@NotBlank @JsonProperty(value = "CPF") String cpf,
		@NotBlank @JsonProperty(value = "sexo") String sexoBiologico
) {}
