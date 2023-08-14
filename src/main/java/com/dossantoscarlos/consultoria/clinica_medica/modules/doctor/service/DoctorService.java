package com.dossantoscarlos.consultoria.clinica_medica.modules.doctor.service;

import java.util.UUID;

import com.dossantoscarlos.consultoria.clinica_medica.modules.doctor.model.Doctor;
import com.dossantoscarlos.consultoria.clinica_medica.modules.doctor.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {
	
	@Autowired
    public DoctorRepository repository;

	public Doctor update(Doctor doctorModel, UUID id) {
		var medico = repository.findById(id);
		var medicoUpdate = medico.orElseThrow();
		medicoUpdate.setNome(doctorModel.getNome());
		medicoUpdate.setSobrenome(doctorModel.getSobrenome());
		return repository.saveAndFlush(medicoUpdate);
	}
	
	public String delete (UUID id) {
		repository.findById(id);
		return "OK";
	}
}
