package com.dossantoscarlos.consultoria.clinica_medica.modules.consulta;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultaRepository extends JpaRepository<Consulta, UUID> {
    
}
