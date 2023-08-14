package com.dossantoscarlos.consultoria.clinica_medica.modules.schedule.service;

import com.dossantoscarlos.consultoria.clinica_medica.modules.schedule.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {

	@Autowired
	public ScheduleRepository repository;
	
	
}
