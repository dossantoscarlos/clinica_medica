package com.dossantoscarlos.consultoria.clinica_medica.modules.paciente.service;

import com.dossantoscarlos.consultoria.clinica_medica.modules.paciente.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacienteService {
	
	@Autowired
    public PacienteRepository repository;

}
