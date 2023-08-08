package com.dossantoscarlos.consultoria.clinica_medica.modules.exame;

import java.util.Optional;
import java.util.UUID;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
@Slf4j
public class ExameService {
	
	@Autowired
	ExameRepository repository;
	
	public Exame update(Exame exame, UUID uuid) {
		Optional<Exame> findExame = repository.findById(uuid);
		Exame exameModel = findExame.orElseThrow();
		exameModel.setNome(exame.getNome());
		exameModel.setDescricaoLonga(exame.getDescricaoLonga());
		exameModel.setDescricaoCurta(exame.getDescricaoCurta());
		return repository.saveAndFlush(exameModel);
	}
	
	public String delete( UUID id ) {
		Optional<Exame> exame = repository.findById(id);
		Exame exameModel = exame.orElseThrow();
		repository.delete(exameModel);
		return "OK";
	}
	
}
