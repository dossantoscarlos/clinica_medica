package com.dossantoscarlos.consultoria.clinica_medica.modules.exame;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
@Table(name = "exames")
public class ExameModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;

	@Column
	@NotBlank
	private String nome;
	
	@Column(length = 100 )
	@NotBlank
	private String descricaoCurta;
	
	@Column(columnDefinition = "text")
	@NotBlank
	private String descricaoLonga;
		
}
