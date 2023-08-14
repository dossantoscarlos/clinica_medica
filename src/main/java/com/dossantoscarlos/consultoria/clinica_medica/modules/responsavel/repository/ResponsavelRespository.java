package com.dossantoscarlos.consultoria.clinica_medica.modules.responsavel.repository;

import java.util.UUID;

import com.dossantoscarlos.consultoria.clinica_medica.modules.responsavel.model.Responsavel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResponsavelRespository extends JpaRepository<Responsavel, UUID> {}
