package com.dossantoscarlos.consultoria.clinica_medica.modules.paciente.repository;

import java.util.UUID;

import com.dossantoscarlos.consultoria.clinica_medica.modules.paciente.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, UUID>{
	
}
