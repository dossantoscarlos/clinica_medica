package com.dossantoscarlos.consultoria.clinica_medica.modules.paciente;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<PacienteModel, UUID>{
	
}
