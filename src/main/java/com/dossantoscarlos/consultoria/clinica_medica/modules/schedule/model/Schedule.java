package com.dossantoscarlos.consultoria.clinica_medica.modules.schedule.model;

import java.util.UUID;

import com.dossantoscarlos.consultoria.clinica_medica.modules.consulta.model.Consulta;
import com.dossantoscarlos.consultoria.clinica_medica.modules.doctor.model.Doctor;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "schedules")
public class Schedule {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	
	@ManyToOne
	private Doctor doctor;

	@ManyToOne
	private Consulta consulta;
	
}
