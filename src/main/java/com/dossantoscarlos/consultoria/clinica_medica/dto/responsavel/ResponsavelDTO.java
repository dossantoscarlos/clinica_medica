package com.dossantoscarlos.consultoria.clinica_medica.dto.responsavel;

import java.sql.Date;

import com.dossantoscarlos.consultoria.clinica_medica.enums.VinculoEnum;

import jakarta.validation.constraints.NotBlank;

public record ResponsavelDTO(
	@NotBlank String nome,
	@NotBlank String sobrenome,
	@NotBlank Date dataNascimento,
	@NotBlank VinculoEnum vinculo
) {

}
