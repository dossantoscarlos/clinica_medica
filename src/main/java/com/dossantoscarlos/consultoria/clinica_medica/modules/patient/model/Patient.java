package com.dossantoscarlos.consultoria.clinica_medica.modules.patient.model;

import java.util.Date;
import java.util.UUID;

import com.dossantoscarlos.consultoria.clinica_medica.modules.consulta.model.Consulta;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name ="patients")
public class Patient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	
	private String name;
	
	private Date dataNascimento;
	
	private String rg;
	
	private String cpf;
	
	private String sexoBiologico;

	@ManyToOne
	private Consulta consulta;
}
