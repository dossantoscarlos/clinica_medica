package com.dossantoscarlos.consultoria.clinica_medica.dto.paciente;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;

public record PacienteDTO(
		@NotBlank String nome,
		@NotBlank Date dataNascimento,
		@NotBlank String rg,
		@NotBlank String cpf,
		@NotBlank String sexoBiologico
) {}
