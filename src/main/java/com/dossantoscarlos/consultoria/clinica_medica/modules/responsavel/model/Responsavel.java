package com.dossantoscarlos.consultoria.clinica_medica.modules.responsavel.model;

import java.sql.Date;
import java.util.UUID;

import com.dossantoscarlos.consultoria.clinica_medica.modules.paciente.enums.VinculoEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "responsaveis")
public class Responsavel {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	
	private String nome;
	private String sobrenome;
	
	@Column(columnDefinition = "date")
	private Date dataNascimento;
	
	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "varchar")
	private VinculoEnum vinculo;
	
}
