package com.dossantoscarlos.consultoria.clinica_medica.modules.consulta.repository;

import java.util.UUID;

import com.dossantoscarlos.consultoria.clinica_medica.modules.consulta.model.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultaRepository extends JpaRepository<Consulta, UUID> {
    
}
