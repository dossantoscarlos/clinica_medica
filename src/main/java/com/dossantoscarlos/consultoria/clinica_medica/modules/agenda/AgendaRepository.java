package com.dossantoscarlos.consultoria.clinica_medica.modules.agenda;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendaRepository extends JpaRepository<AgendaModel, UUID>{

}
