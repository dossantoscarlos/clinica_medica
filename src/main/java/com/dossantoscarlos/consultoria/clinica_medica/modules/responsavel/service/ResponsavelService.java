package com.dossantoscarlos.consultoria.clinica_medica.modules.responsavel.service;

import java.util.Optional;
import java.util.UUID;

import com.dossantoscarlos.consultoria.clinica_medica.modules.responsavel.model.Responsavel;
import com.dossantoscarlos.consultoria.clinica_medica.modules.responsavel.repository.ResponsavelRespository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@Component
public class ResponsavelService {
	
	@Autowired
	public ResponsavelRespository repository;

	public Responsavel updateAllField(Responsavel responsavel , UUID id) {
		Optional<Responsavel> findResponsavel = repository.findById(id);
		Responsavel responsavelModel = findResponsavel.orElseThrow();
		responsavelModel.setNome(responsavel.getNome());
		responsavelModel.setSobrenome(responsavel.getSobrenome());
		responsavelModel.setDataNascimento(responsavel.getDataNascimento());
		responsavelModel.setVinculo(responsavel.getVinculo());
		return repository.saveAndFlush(responsavelModel);
	}
	
	public String delete(UUID id) {
		repository.deleteById(id);
		return "OK";
	}

	public Responsavel find(UUID id) {
		Optional<Responsavel> findResponsavel = repository.findById(id);
		return findResponsavel.orElseThrow();
	}
	
}
