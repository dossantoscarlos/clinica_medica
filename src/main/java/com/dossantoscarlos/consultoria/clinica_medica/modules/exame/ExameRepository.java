package com.dossantoscarlos.consultoria.clinica_medica.modules.exame;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ExameRepository extends JpaRepository<ExameModel, UUID> {

}
