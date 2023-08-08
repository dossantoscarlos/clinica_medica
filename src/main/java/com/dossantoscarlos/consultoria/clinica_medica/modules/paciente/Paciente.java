package com.dossantoscarlos.consultoria.clinica_medica.modules.paciente;

import java.util.Date;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name ="pacientes")
public class Paciente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	
	@Column()
	private String nome;
	
	@Column()
	private Date dataNascimento;
	
	@Column()
	private String rg;
	
	@Column()
	private String cpf;
	
	@Column()
	private String sexoBiologico;
	
}
