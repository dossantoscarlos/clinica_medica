package com.dossantoscarlos.consultoria.clinica_medica.modules.paciente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacienteService {
	
	@Autowired
	PacienteRepository repository;

}
