package com.dossantoscarlos.consultoria.clinica_medica.modules.exams.dto;

import jakarta.validation.constraints.NotBlank;

public record ExamUpdateDTO(
		@NotBlank String nome,
		@NotBlank String descricaoCurta,
		@NotBlank String descricaoLonga) {}
