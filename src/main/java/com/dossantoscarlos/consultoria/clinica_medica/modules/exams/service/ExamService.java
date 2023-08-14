package com.dossantoscarlos.consultoria.clinica_medica.modules.exams.service;

import java.util.Optional;
import java.util.UUID;

import com.dossantoscarlos.consultoria.clinica_medica.modules.exams.dto.ExamUpdateDTO;
import com.dossantoscarlos.consultoria.clinica_medica.modules.exams.model.Exam;
import com.dossantoscarlos.consultoria.clinica_medica.modules.exams.repository.ExamRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
@Slf4j
public class ExamService {
	
	@Autowired
	public ExamRepository repository;
	
	public Exam update(ExamUpdateDTO exameDTO, UUID uuid) {
		Optional<Exam> findExame = repository.findById(uuid);
		Exam examModel = findExame.orElseThrow();
		examModel.setNome(exameDTO.nome());
		examModel.setDescricaoLonga(exameDTO.descricaoLonga());
		examModel.setDescricaoCurta(exameDTO.descricaoCurta());
		return repository.saveAndFlush(examModel);
	}
	
	public String delete( UUID id ) {
		Optional<Exam> exame = repository.findById(id);
		Exam examModel = exame.orElseThrow();
		repository.delete(examModel);
		return "OK";
	}
	
}
