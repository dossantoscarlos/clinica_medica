package com.dossantoscarlos.consultoria.clinica_medica.modules.agenda;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class AgendaService {

	@Autowired
	AgendaRepository repository;
	
	
}
