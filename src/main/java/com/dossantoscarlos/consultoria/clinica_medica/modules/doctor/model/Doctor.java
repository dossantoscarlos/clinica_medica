package com.dossantoscarlos.consultoria.clinica_medica.modules.doctor.model;

import java.util.List;
import java.util.UUID;

import com.dossantoscarlos.consultoria.clinica_medica.modules.schedule.model.Schedule;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "medicos")
public class Doctor {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;

	private String nome;
	private String sobrenome;
	private String crm;
	private String rg;
	private String cpf;
	
	@OneToMany
	private List<Schedule> schedules;
	
}
