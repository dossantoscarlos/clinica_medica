package com.dossantoscarlos.consultoria.clinica_medica.modules.responsavel;

import java.sql.Date;
import java.util.UUID;

import com.dossantoscarlos.consultoria.clinica_medica.enums.VinculoEnum;

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
	
	@Column(length=100)
	private String nome;
	
	@Column(length=255)
	private String sobrenome;
	
	@Column(columnDefinition = "date")
	private Date dataNascimento;
	
	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "varchar", length = 255)
	private VinculoEnum vinculo;
	
}
