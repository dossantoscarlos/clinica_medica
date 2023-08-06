package com.dossantoscarlos.consultoria.clinica_medica.dto.exame;

import jakarta.validation.constraints.NotBlank;

public record ExameDTO(
	@NotBlank String nome,		
	@NotBlank String descricaoCurta,
	@NotBlank String descricaoLonga
) {}

