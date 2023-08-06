package com.dossantoscarlos.consultoria.clinica_medica.modules.medico;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<MedicoModel, UUID>{

}
