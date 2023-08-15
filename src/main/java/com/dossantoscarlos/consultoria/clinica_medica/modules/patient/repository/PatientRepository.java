package com.dossantoscarlos.consultoria.clinica_medica.modules.patient.repository;

import java.util.UUID;

import com.dossantoscarlos.consultoria.clinica_medica.modules.patient.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, UUID>{
	
}
