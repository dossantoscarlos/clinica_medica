package com.dossantoscarlos.consultoria.clinica_medica.modules.exams.model;

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
public class Exam {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;

	private String nome;
	
	@Column(length = 100 )
	private String descricaoCurta;
	
	@Column(columnDefinition = "text")
	private String descricaoLonga;
		
}
