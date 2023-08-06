package com.dossantoscarlos.consultoria.clinica_medica.modules.medico;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicoService {
	
	@Autowired
	MedicoRepository repository;

	public MedicoModel update(MedicoModel medicoModel, UUID id) {
		var medico = repository.findById(id);
		var medicoUpdate = medico.orElseThrow();
		medicoUpdate.setNome(medicoModel.getNome());
		medicoUpdate.setSobrenome(medicoModel.getSobrenome());
		return repository.saveAndFlush(medicoUpdate);
	}
	
	public String deleteMedico (UUID id) {
		repository.findById(id);
		return "OK";
	}
}
