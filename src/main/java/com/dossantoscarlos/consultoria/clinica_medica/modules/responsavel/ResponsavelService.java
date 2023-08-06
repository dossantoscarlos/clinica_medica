package com.dossantoscarlos.consultoria.clinica_medica.modules.responsavel;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResponsavelService {
	
	@Autowired
	ResponsavelResponsavel repository;

	public ResponsavelModel updateAllField(ResponsavelModel responsavel ,UUID id) {
		Optional<ResponsavelModel> findResponsavel = repository.findById(id);
		ResponsavelModel responsavelModel = findResponsavel.orElseThrow();
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

	public ResponsavelModel find(UUID id) {
		Optional<ResponsavelModel> findResponsavel = repository.findById(id);
		ResponsavelModel responsavel = findResponsavel.orElseThrow();
		return responsavel;
	}
	
}
