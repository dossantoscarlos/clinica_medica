package com.dossantoscarlos.consultoria.clinica_medica.modules.exame;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExameService {
	
	@Autowired
	ExameRepository repository;
	
	public ExameModel update(ExameModel exame, UUID uuid) {
		Optional<ExameModel> findExame = repository.findById(uuid);

		ExameModel exameModel = findExame.orElseThrow();

		exameModel.setNome(exame.getNome());
		exameModel.setDescricaoLonga(exame.getDescricaoLonga());
		exameModel.setDescricaoCurta(exame.getDescricaoCurta());
	
		return repository.saveAndFlush(exameModel);
	}
	
	public String delete( UUID id ) {
		Optional<ExameModel> exame = repository.findById(id);
		ExameModel exameModel = exame.orElseThrow();
		repository.delete(exameModel);
		return "OK";
	}
	
}
